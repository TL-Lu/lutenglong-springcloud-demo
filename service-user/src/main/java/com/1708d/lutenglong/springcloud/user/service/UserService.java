package com.lutenglong_user.service;

import com.lutenglong.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    String getUsernameById(Integer id);

    User getUserById(Integer id);
}
