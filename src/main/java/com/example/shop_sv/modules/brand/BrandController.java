package com.example.shop_sv.modules.brand;

import com.example.shop_sv.modules.brand.dto.resquest.BrandReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;


    @GetMapping("")
    public ResponseEntity<Object> getBrand() {
        try {
            List<BrandModel> brandList = brandService.getAll();
            return ResponseEntity.ok(brandList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get Brand fail");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addBrand(@RequestBody BrandReq brandReq) {
        try{
            brandService.save(brandReq);
            return ResponseEntity.ok("Add Brand ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Add Brand fail");
        }
    }

}
