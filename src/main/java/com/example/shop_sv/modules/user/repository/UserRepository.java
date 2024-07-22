package com.example.shop_sv.modules.user.repository;

import com.example.shop_sv.modules.user.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
    List<UserModel> findAllByOrderByUsernameAsc();
    List<UserModel> findAllByOrderByUsernameDesc();
    List<UserModel> findByUsernameIgnoreCaseContaining(String name);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    @Query(value = "SELECT * FROM users WHERE users.username = :id or (users.email = :id and users.is_deleted = true)", nativeQuery = true)
    UserModel findUserByInfor(@Param("id") String id);
}
