package com.lutenglong_order.interfaces;

import com.lutenglong.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeginFallback implements com.lutenglong_order.interfaces.UserFeginClient {
    @Override
    public String getUsernameById(Integer id) {
        return "服务调用失败";
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setUsername("失败");
        return user;
    }
}
