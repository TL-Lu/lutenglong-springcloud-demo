package com.lutenglong.service;

import com.lutenglong.entity.Order;
import org.springframework.stereotype.Service;


public interface OrderService {
    Order getOrderById(Integer id);
}
