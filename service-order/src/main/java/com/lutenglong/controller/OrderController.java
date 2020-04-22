package com.lutenglong.controller;

import com.lutenglong.entity.Order;
import com.lutenglong.entity.User;
import com.lutenglong.interfaces.UserFeginClient;
import com.lutenglong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeginClient userFeginClient;

    @RequestMapping("getOrderById")
    public Order getOrderById(@RequestParam("id")Integer id){
        System.err.println(1);
        Order orderById = orderService.getOrderById(id);
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id=1", User.class);
        User user = userFeginClient.getUserById(orderById.getId());
        orderById.setUsername(user.getUsername());
        return orderById;
    }

}
