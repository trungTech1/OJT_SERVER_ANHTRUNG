package com.example.shop_sv.modules.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> findAll(){
        try{
            return categoryRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }
}
