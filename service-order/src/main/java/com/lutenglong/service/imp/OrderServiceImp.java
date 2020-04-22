package com.lutenglong.service.imp;

import com.lutenglong.entity.Order;
import com.lutenglong.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Override
    public Order getOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setName("第一个订单");
        return order;
    }
}
