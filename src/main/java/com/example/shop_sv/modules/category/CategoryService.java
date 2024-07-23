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

    public CategoryModel create(CategoryModel categoryModel){
            return categoryRepository.save(categoryModel);
    }

    public CategoryModel update(Integer id, CategoryModel categoryReq) {
        CategoryModel categoryResp = categoryRepository.findById(Long.valueOf(id)).orElse(null);
        if (categoryResp == null) {
            return null;
        }
        categoryResp.setName(categoryReq.getName());
        categoryResp.setDescription(categoryReq.getDescription());
        categoryResp.setImage(categoryReq.getImage());

        return categoryRepository.save(categoryResp);
    }

    public void delete(Integer id){
        CategoryModel categoryResp = categoryRepository.findById(Long.valueOf(id)).orElse(null);
        if (categoryResp != null){
            if (categoryResp.getStatus()){
                categoryResp.setStatus(false);
                categoryRepository.save(categoryResp);
            }else {
                categoryResp.setStatus(true);
                categoryRepository.save(categoryResp);
            }
        }
    }

    public CategoryModel findById(Integer id){
        return categoryRepository.findById(Long.valueOf(id)).orElse(null);
    }
}
