package com.example.shop_sv.modules.banner.service;

import com.example.shop_sv.modules.banner.BannerModel;
import com.example.shop_sv.modules.banner.repository.BannerRepository;
import com.example.shop_sv.modules.category.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;

    public List<BannerModel> findAll() {
        return bannerRepository.findAll();
    }

    public BannerModel save(BannerModel bannerModel) {
        return bannerRepository.save(bannerModel);
    }

    public BannerModel update(Byte id, BannerModel newBannerModel) {
    BannerModel existingBannerModel = bannerRepository.findById(id).orElse(null);
    if (existingBannerModel == null) {
        return null;
    }
    existingBannerModel.setBannerName(newBannerModel.getBannerName());
    existingBannerModel.setDescription(newBannerModel.getDescription());
    existingBannerModel.setImage(newBannerModel.getImage());

    return bannerRepository.save(existingBannerModel);
}

    public void changeStatus(Byte id){
        BannerModel bannerModel= bannerRepository.findById(id).orElse(null);
        if (bannerModel != null){
            if (bannerModel.getStatus()){
                bannerModel.setStatus(false);
                bannerRepository.save(bannerModel);
            }else {
                bannerModel.setStatus(true);
                bannerRepository.save(bannerModel);
            }
        }
    }
    public void delete(Byte id){
        bannerRepository.deleteById(id);
    }

    //hien thi banner theo trang thai
    public List<BannerModel> findAllByStatus(Boolean status){
        return bannerRepository.findAllByStatus(status);
    }
}
