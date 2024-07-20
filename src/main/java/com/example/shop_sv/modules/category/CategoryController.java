package com.example.shop_sv.modules.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        List<CategoryModel> categoryModels = categoryService.findAll();
        return new ResponseEntity<>( categoryModels, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create (@RequestBody CategoryModel categoryReq){

        try{
            CategoryModel categoryResp = categoryService.create(categoryReq);
            return new ResponseEntity<>(categoryResp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update (@PathVariable Integer id, @RequestBody CategoryModel categoryReq){
        try{
            CategoryModel categoryResp = categoryService.update(id, categoryReq);
            return new ResponseEntity<>(categoryResp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete (@PathVariable Integer id){
        try{
            categoryService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
