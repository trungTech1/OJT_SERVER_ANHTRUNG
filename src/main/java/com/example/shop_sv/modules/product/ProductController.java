package com.example.shop_sv.modules.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<Object> getAllProduct() {
        try {
            List<ProductModel> productModels = productService.findAll();
            return new ResponseEntity<> (productModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<> ("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
