package com.example.shop_sv.modules.user.controller;

import com.example.shop_sv.modules.user.UserModel;
import com.example.shop_sv.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    // find all users

    @GetMapping("findAll")
    public List<UserModel> getAllUser() {
        return userService.findAll();
    }

    //descending users by name
    @GetMapping("findAllByOrderByNameAsc")
    public List<UserModel> getAllUserByOrderByNameAsc() {
        return userService.findAllByOrderByNameAsc();
    }

    //ascending users by name
    @GetMapping("findAllByOrderByNameDesc")
    public List<UserModel> getAllUserByOrderByNameDesc() {
        return userService.findAllByOrderByNameDesc();
    }

    @GetMapping("findAllByPagination")
    public Page<UserModel> getAllUserByPagination(@RequestParam int page, @RequestParam int size) {
        return userService.findAll(page, size);
    }

    //search user by name
    @GetMapping("searchUserByName")
    public List<UserModel> searchUserByName(@RequestParam String name) {
        return userService.searchUserByName(name);
    }

    //block or unblock user by id
    @PutMapping("toggleBlockUser/{id}")
    public ResponseEntity<String> toggleBlockUser(@PathVariable Integer id) {
        Optional<UserModel> user = userService.findById(id);
        if (user.isPresent()) {
            UserModel userModel = user.get();
            boolean previousStatus = userModel.getStatus();
            userModel.setStatus(!previousStatus); // toggle status
            userService.save(userModel);
            if (previousStatus) {
                return ResponseEntity.ok("block success");
            } else {
                return ResponseEntity.ok("unblock success");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
