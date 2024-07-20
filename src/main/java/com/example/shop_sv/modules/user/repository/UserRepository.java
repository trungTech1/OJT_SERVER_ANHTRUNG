package com.example.shop_sv.modules.user.repository;

import com.example.shop_sv.modules.user.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
    List<UserModel> findAllByOrderByUsernameAsc();
    List<UserModel> findAllByOrderByUsernameDesc();
    List<UserModel> findByUsernameIgnoreCaseContaining(String name);
}
