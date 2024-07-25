package com.example.shop_sv.modules.banner.repository;

import com.example.shop_sv.modules.banner.BannerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<BannerModel, Byte> {
    List<BannerModel> findAllByStatus(Boolean status);

}
