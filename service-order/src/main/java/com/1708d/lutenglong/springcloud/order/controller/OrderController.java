package com.lutenglong_order.controller;

import com.lutenglong.entity.Order;
import com.lutenglong.entity.User;
import com.lutenglong_order.interfaces.UserFeginClient;
import com.lutenglong_order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getUserByIdFallbackMethod")
    public Order getOrderById(@RequestParam("id")Integer id) throws InterruptedException {
        System.err.println(1);
        Order orderById = orderService.getOrderById(id);
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id=1", User.class);
        User user = userFeginClient.getUserById(orderById.getId());
        orderById.setUsername(user.getUsername());
        Thread.sleep(1000000);
        return orderById;
    }

    public Order getUserByIdFallbackMethod(@RequestParam("id")Integer id){
        Order order = new Order();
        order.setId(id);
        order.setUsername("调用失败");
        order.setName("err");
        return order;
    }

}
