package com.example.shop_sv.modules.user.repository;

import com.example.shop_sv.modules.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
