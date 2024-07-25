package com.example.shop_sv.modules.ProductDetail;

import com.example.shop_sv.modules.ProductDetail.dto.ProductDetailRequest;
import com.example.shop_sv.modules.color.ColorService;
import com.example.shop_sv.modules.config.ConfigService;
import com.example.shop_sv.modules.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ColorService colorService;
    @Autowired
    private ConfigService configService;

    @Autowired
    private ProductService productService;


    public List<ProductDetailModel> findAll() {
        return productDetailRepository.findAll();
    }
    public ProductDetailModel save(ProductDetailRequest productDetailRes , Integer productId) {
        ProductDetailModel productDetailModel = new ProductDetailModel();

        productDetailModel.setProductDetailName(productDetailRes.getProductDetailName());
        productDetailModel.setStock(productDetailRes.getStock());
        productDetailModel.setUnitPrice(productDetailRes.getUnitPrice());
        if (productDetailRes.getColorId() != null)
        {
            productDetailModel.setColor(colorService.findById(productDetailRes.getColorId()));
        }else {
            productDetailModel.setColor(null);
        }
        if (productDetailRes.getConfigId() != null)
        {
            productDetailModel.setConfig(configService.findById(productDetailRes.getConfigId()));
        }else {
            productDetailModel.setConfig(null);

        }
        if(productId != null)
        {
           try{
                productDetailModel.setProduct(productService.findById(productId));
           }catch (Exception e){
               productDetailModel.setProduct(null);
           }
        }else {
            productDetailModel.setProduct(null);
        }
        return productDetailRepository.save(productDetailModel);
    }

    public ProductDetailModel findById(Integer id) {
        return productDetailRepository.findById(Byte.valueOf(String.valueOf(id))).orElse(null);
    }
}
