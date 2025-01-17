package com.example.shop_sv.modules.ProductDetail;

import com.example.shop_sv.modules.ProductDetail.dto.ProductDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-detail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        try {
            return new ResponseEntity<>(productDetailService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Get ProductDetail fail", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create/{productId}")
    public ResponseEntity<Object> addProductDetail(@PathVariable Integer productId, @RequestBody ProductDetailRequest productDetailRes) {
        try {
          ProductDetailModel productDetailResp = productDetailService.save(productDetailRes, productId);
            return new ResponseEntity<>(productDetailResp, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error saving product detail: " + e.getMessage());
            return new ResponseEntity<>("Add ProductDetail fail", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{productDetailId}")
    public ResponseEntity<Object> updateProductDetail(@PathVariable Integer productDetailId, @RequestBody ProductDetailRequest productDetailRes) {
        try {
            ProductDetailModel productDetailResp = productDetailService.update(productDetailRes, productDetailId);
            return new ResponseEntity<>(productDetailResp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Update ProductDetail fail", HttpStatus.BAD_REQUEST);
        }
    }

}
