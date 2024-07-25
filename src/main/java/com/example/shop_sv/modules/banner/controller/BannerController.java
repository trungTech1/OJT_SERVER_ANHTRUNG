package com.example.shop_sv.modules.banner.controller;

import com.example.shop_sv.modules.banner.BannerModel;
import com.example.shop_sv.modules.banner.service.BannerService;
import com.example.shop_sv.modules.category.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    // find all banners
    @GetMapping("findAll")
    public List<BannerModel> getAllBanner() {
        return bannerService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create (@RequestBody BannerModel bannerReq){

        try{
            BannerModel bannerRes = bannerService.save(bannerReq);
            return new ResponseEntity<>(bannerRes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update (@PathVariable Byte id, @RequestBody BannerModel bannerReq){
        try{
            BannerModel bannerResp = bannerService.update(id, bannerReq);
            return new ResponseEntity<>(bannerResp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/changeStatus/{id}")
    public ResponseEntity<Object> delete (@PathVariable Byte id){
        try{
            bannerService.changeStatus(id);
            return new ResponseEntity<>("Thay đổi trạng thái banner thành công", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Thay đổi trạng thái banner thất bại", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBanner (@PathVariable Byte id){
        try{
            bannerService.delete(id);
            return new ResponseEntity<>("Xóa banner thành công", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Xóa banner thất bại", HttpStatus.BAD_REQUEST);
        }
    }

    //hien thi banner theo trang thai
    @GetMapping("findAllByStatus")
    public List<BannerModel> getAllBannerByStatus() {
        return bannerService.findAllByStatus(true);
    }
}
