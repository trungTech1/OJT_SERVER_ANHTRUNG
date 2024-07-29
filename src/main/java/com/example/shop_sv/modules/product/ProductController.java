package com.example.shop_sv.modules.product;


import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import com.example.shop_sv.modules.ProductDetail.ProductDetailService;
import com.example.shop_sv.modules.product.dto.request.ProductCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getProducts(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "all") String filterStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Boolean statusBoolean = null;
        if ("active".equals(filterStatus)) {
            statusBoolean = true;
        } else if ("inactive".equals(filterStatus)) {
            statusBoolean = false;
        }
        Page<ProductModel> productPage = productService.getProducts(search, statusBoolean, page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("products", productPage.getContent());
        response.put("currentPage", productPage.getNumber());
        response.put("totalItems", productPage.getTotalElements());
        response.put("totalPages", productPage.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Byte id, @RequestBody ProductCreateDTO productCreateDTO) {
        System.out.println("đang chạy" + id + productCreateDTO.getProductName());
        try {
            ProductModel productModel = productService.update(id, productCreateDTO);
            System.out.println("ã vào đây12312");
            return new ResponseEntity<> (productModel, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("ã vào đây12312" + e.getMessage());
            return new ResponseEntity<> ("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Integer id) {
        System.out.println("đang chạy" + id);
        try {
            ProductDetailModel productModel = productDetailService.findById(id);
            return new ResponseEntity<> (productModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<> ("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
