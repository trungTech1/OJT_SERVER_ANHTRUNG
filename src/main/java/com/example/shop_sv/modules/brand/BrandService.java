package com.example.shop_sv.modules.brand;

import com.example.shop_sv.modules.brand.dto.resquest.BrandReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandModel> getAll() {
        return brandRepository.findAll();
    }

    public BrandModel save(BrandReq brand) {
        BrandModel brandModel = new BrandModel();
        brandModel.setBrandName(brand.getBrandName());
        return brandRepository.save(brandModel);
    }

    public BrandModel findById(Byte id) {
        return brandRepository.findById(id).orElse(null);
    }
}
