package com.example.shop_sv.modules.user.service;

import com.example.shop_sv.modules.user.UserModel;
import com.example.shop_sv.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired UserRepository userRepository;

    //find all users
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

}
