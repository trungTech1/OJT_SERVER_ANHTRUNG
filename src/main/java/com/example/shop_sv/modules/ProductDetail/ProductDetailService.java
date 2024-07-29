package com.example.shop_sv.modules.ProductDetail;

import com.example.shop_sv.modules.ProductDetail.dto.ProductDetailRequest;
import com.example.shop_sv.modules.color.ColorService;
import com.example.shop_sv.modules.config.ConfigService;
import com.example.shop_sv.modules.product.ProductModel;
import com.example.shop_sv.modules.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        ProductDetailModel productDetailCover = coverProductDetail(productDetailRes, productDetailModel);if (productId != null) {
            ProductModel product = productService.findById(productId);
            if (product == null) {
                throw new RuntimeException("Product not found with id: " + productId);
            }
            productDetailCover.setProduct(product);
        } else {
            throw new RuntimeException("ProductId is required");
        }
        if (productDetailCover.getProductDetailName() == null || productDetailCover.getProductDetailName().isEmpty()) {
            throw new RuntimeException("Product detail name is required");
        }
        if (productDetailCover.getStock() == null) {
            throw new RuntimeException("Stock is required");
        }
        if (productDetailCover.getUnitPrice() == null) {
            throw new RuntimeException("Unit price is required");
        }
        ProductDetailModel savedModel = productDetailRepository.save(productDetailCover);
        return savedModel;
    }

    public ProductDetailModel findById(Integer id) {
        return productDetailRepository.findById(Byte.valueOf(String.valueOf(id))).orElse(null);
    }

    public ProductDetailModel update(ProductDetailRequest productDetailRes, Integer productDetailId) {
        ProductDetailModel productDetailModel = findById(productDetailId);
        if (productDetailModel == null) {
            return null;
        }
        coverProductDetail(productDetailRes, productDetailModel);
        return productDetailRepository.save(productDetailModel);
    }

    private ProductDetailModel coverProductDetail(ProductDetailRequest productDetailRes, ProductDetailModel productDetailModel) {
        productDetailModel.setProductDetailName(productDetailRes.getProductDetailName());
        productDetailModel.setStock(productDetailRes.getStock());
        productDetailModel.setUnitPrice(productDetailRes.getUnitPrice());
        // Khởi tạo danh sách productDetailImages nếu nó là null
        if (productDetailModel.getProductDetailImages() == null) {
            productDetailModel.setProductDetailImages(new ArrayList<>());
        }

        if (productDetailRes.getImages() != null && !productDetailRes.getImages().isEmpty()) {
            List<String> images = productDetailRes.getImages();
            for (String image : images) {
                ProductDetailImageModel productDetailImageModel = new ProductDetailImageModel();
                productDetailImageModel.setImage(image);
                productDetailImageModel.setProductDetail(productDetailModel);
                productDetailModel.getProductDetailImages().add(productDetailImageModel);
            }
        } else {
            productDetailModel.setProductDetailImages(new ArrayList<>()); // Hoặc giữ nguyên nếu đã được khởi tạo
        }
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
        return productDetailModel;
    }
}
