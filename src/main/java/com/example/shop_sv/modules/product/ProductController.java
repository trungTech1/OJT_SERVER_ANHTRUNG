package com.example.shop_sv.modules.product;


import com.example.shop_sv.modules.product.dto.request.ProductCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        System.out.println("đang chạy");
        try {
            ProductModel productModel = productService.save(productCreateDTO);
            return new ResponseEntity<> (productModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<> ("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Byte id) {
        try {
            productService.delete(id);
            return new ResponseEntity<> ("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<> ("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
