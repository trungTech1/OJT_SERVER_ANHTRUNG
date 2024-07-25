package com.example.shop_sv.modules.user.repository;

import com.example.shop_sv.modules.user.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
    //change information user without password
    @Modifying
    @Transactional
    @Query("UPDATE UserModel u SET u.username = ?2, u.email = ?3, u.phone = ?4, u.full_name = ?5 WHERE u.id = ?1")
    void changeInforUserWithoutPassword(String id, String username, String email, String phone, String full_name);
}
