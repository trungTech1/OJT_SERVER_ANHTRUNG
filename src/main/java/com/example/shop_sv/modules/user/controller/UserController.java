package com.example.shop_sv.modules.user.controller;

import com.example.shop_sv.modules.user.UserModel;
import com.example.shop_sv.modules.user.req.LoginDTO;
import com.example.shop_sv.modules.user.req.RegisterDTO;
import com.example.shop_sv.modules.user.service.UserService;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

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

    //dang ki
    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDTO data) {
        System.out.println("register" + data);
        try {
            UserModel user = new UserModel();
            user.setUsername(data.getUsername());
            user.setPassword(BCrypt.hashpw(data.getPassword(), BCrypt.gensalt()));
            user.setEmail(data.getEmail());
            user.setPhone(data.getPhone());
            user.setCreated_at(String.valueOf(System.currentTimeMillis()));
            user.setUpdated_at(String.valueOf(System.currentTimeMillis()));
            userService.save(user);

            // ArrayList<String> mails = new ArrayList<>();
            // mails.add(data.getEmail());
            // mailService.sendMail(new Option("Chào mừng", "Cảm ơn bạn đã đăng ký tài khoản", mails));

            return new ResponseEntity<>("Đăng ký thành công", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // This will print the stack trace to the console
            if (e.getMessage().contains("Duplicate")) {
                return new ResponseEntity<>("Email or user name already exists.", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Lỗi chưa xác định: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //dang nhap
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO data) {
        try {
            UserModel user = userService.findUserByInfor(data.getUsername());

            if (user == null) {
                throw new Exception("Tài khoản không tồn tại");
            }
            if (!BCrypt.checkpw(data.getPassword(), user.getPassword())) {
                throw new Exception("Sai mật khẩu");
            }

            if (!user.getStatus()) {
                throw new Exception("Tài khoản da bi khoa");
            }


//            String token = JwtService.createTokenUser(user);

//            JedisPool jedisPool = new JedisPool("localhost", 6379);
//            try (Jedis jedis = jedisPool.getResource()) {
//                jedis.set(String.valueOf(user.getId()), token);
//            }
//            jedisPool.close();

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Đăng nhập thành công");
//            response.put("token", token);


            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}
