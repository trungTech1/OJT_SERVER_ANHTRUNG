package com.example.shop_sv.modules.product;

import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import com.example.shop_sv.modules.ProductDetail.ProductDetailService;
import com.example.shop_sv.modules.brand.BrandService;
import com.example.shop_sv.modules.category.CategoryService;
import com.example.shop_sv.modules.product.dto.request.ProductCreateDTO;
import com.example.shop_sv.modules.productImage.ProductImageModel;
import com.example.shop_sv.modules.productImage.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        //set các giá trị cho product VAF NEEUS ADD PRODUCT THÌ SET CREATED_AT
        productModel.setCreated_at(new Date());
        return getProductModel(productCreateDTO, productModel);
    }

    public Page<ProductModel> getProducts(String search, Boolean status, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (search != null && !search.isEmpty() && status != null) {
            return productRepository.findByProductNameContainingIgnoreCaseAndStatus(search, status, pageable);
        } else if (search != null && !search.isEmpty()) {
            return productRepository.findByProductNameContainingIgnoreCase(search, pageable);
        } else if (status != null) {
            return productRepository.findByStatus(status, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }


    public void delete(Byte id) {
        //dđôi lại status của product
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        ProductModel productModel = productRepository.findById(id).get();
        productModel.setStatus(false);
        productRepository.save(productModel);
    }

    public ProductModel update(Byte id, ProductCreateDTO productCreateDTO) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        ProductModel productModel = productRepository.findById(id).get();
        return getProductModel(productCreateDTO, productModel);
    }

    private ProductModel getProductModel(ProductCreateDTO productCreateDTO, ProductModel productModel) {
        boolean isUpdate = productModel.getId() != null;
        productModel.setProductName(productCreateDTO.getProductName());
        productModel.setDescription(productCreateDTO.getDescription());
        if (productCreateDTO.getSku() != null) {
            productModel.setSku(productCreateDTO.getSku());
        }

        if (productCreateDTO.getBrandId() != null) {
            productModel.setBrand(brandService.findById(productCreateDTO.getBrandId().byteValue()));
        } else {
            productModel.setBrand(null);
        }

        if (productCreateDTO.getCategoryId() != null) {
            productModel.setCategory(categoryService.findById(productCreateDTO.getCategoryId()));
        } else {
            productModel.setCategory(null);
        }

        if (productCreateDTO.getImages() != null && !productCreateDTO.getImages().isEmpty()) {
            productModel.setImage(productCreateDTO.getImages().get(0));
        } else {
            productModel.setImage(null);
        }

        ProductModel savedProduct = productRepository.save(productModel);

        List<ProductImageModel> productImageModels = new ArrayList<>();
        if (isUpdate) {
            // Nếu là cập nhật, xóa hình ảnh cũ
            try {
                imageService.deleteAllByProductId(savedProduct.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            productModel.getImages().clear();
        }

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

    public ProductModel findById(Integer id) {
        return productRepository.findById(Byte.valueOf(String.valueOf(id))).orElse(null);
    }
}
