package com.example.shop_sv.modules.product;

import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import com.example.shop_sv.modules.ProductDetail.ProductDetailService;
import com.example.shop_sv.modules.brand.BrandService;
import com.example.shop_sv.modules.category.CategoryService;
import com.example.shop_sv.modules.product.dto.request.ProductCreateDTO;
import com.example.shop_sv.modules.productImage.ProductImageModel;
import com.example.shop_sv.modules.productImage.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductImageService imageService;

    public ProductModel save(ProductCreateDTO productCreateDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setProductName(productCreateDTO.getProductName());
        productModel.setDescription(productCreateDTO.getDescription());
        productModel.setSku(productCreateDTO.getSku());
        productModel.setBrand(brandService.findById(productCreateDTO.getBrandId().byteValue()));
        productModel.setCategory(categoryService.findById(productCreateDTO.getCategoryId()));

        if (productCreateDTO.getImages() != null && !productCreateDTO.getImages().isEmpty()) {
            productModel.setImage(productCreateDTO.getImages().get(0));
        } else {
            productModel.setImage(null);
        }

        ProductModel savedProduct = productRepository.save(productModel);

        List<ProductImageModel> productImageModels = new ArrayList<>();
        if (productCreateDTO.getImages() != null && !productCreateDTO.getImages().isEmpty()) {
            productImageModels = productCreateDTO.getImages().stream()
                    .map(src -> {
                        ProductImageModel img = new ProductImageModel();
                        img.setImage(src);
                        img.setProduct(savedProduct);
                        return img;
                    })
                    .collect(Collectors.toList());

            productImageModels = imageService.saveAll(productImageModels);
        }

        savedProduct.setImages(productImageModels);

        return savedProduct;
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public void delete(Byte id) {
        //dđôi lại status của product
        ProductModel productModel = productRepository.findById(id).get();
        productModel.setStatus(false);
        productRepository.save(productModel);
    }
}
