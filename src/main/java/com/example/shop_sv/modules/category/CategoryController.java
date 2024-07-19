package com.example.shop_sv.modules.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        System.out.println("findAll");
        List<CategoryModel> categoryModels = categoryService.findAll();
        return new ResponseEntity<>( categoryModels, HttpStatus.OK);
    }
}
