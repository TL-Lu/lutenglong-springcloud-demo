package com.lutenglong.controller;

import com.lutenglong.entity.User;
import com.lutenglong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id){
        return userService.getUsernameById(id);
    }


    @RequestMapping("getUserById")
    public User getUserById(
            @RequestParam("id") Integer id){
        System.err.println(1111);
        return userService.getUserById(id); }
}
