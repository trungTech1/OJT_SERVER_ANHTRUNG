package com.example.shop_sv.modules.user.service;

import com.example.shop_sv.modules.user.UserModel;
import com.example.shop_sv.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //find all users
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    //descending users by name
    public List<UserModel> findAllByOrderByNameAsc() {
        return userRepository.findAllByOrderByUsernameAsc();
    }

    //ascending users by name
    public List<UserModel> findAllByOrderByNameDesc() {
        return userRepository.findAllByOrderByUsernameDesc();
    }

    public Page<UserModel> findAll(int page, int size) {
        return userRepository.findAll(PageRequest.of(page - 1, size));
    }

    //search user by name
    public List<UserModel> searchUserByName(String name) {
        return userRepository.findByUsernameIgnoreCaseContaining(name);
    }

}
