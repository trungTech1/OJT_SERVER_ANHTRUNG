package com.example.shop_sv.modules.user.controller;

import com.example.shop_sv.modules.user.UserModel;
import com.example.shop_sv.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

   // find all users
    @GetMapping("/findAll")
    public List<UserModel> getAllUser(){
        return userService.findAll();
    }
}
