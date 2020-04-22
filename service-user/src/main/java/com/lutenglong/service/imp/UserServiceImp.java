package com.lutenglong.service.imp;

import com.lutenglong.entity.User;
import com.lutenglong.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Override
    public String getUsernameById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("UserService:"+id);
        return user.getUsername();
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("lsii");
        return user;
    }
}
