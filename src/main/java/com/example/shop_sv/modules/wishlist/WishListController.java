package com.example.shop_sv.modules.wishlist;

import com.example.shop_sv.modules.product.ProductModel;
import com.example.shop_sv.modules.product.ProductService;
import com.example.shop_sv.modules.user.UserModel;
import com.example.shop_sv.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    //add product to wishlist
@GetMapping("/getAll")
public ResponseEntity<Object> getAll() {
    return new ResponseEntity<>(wishListService.findAll(), HttpStatus.OK);
}

@PostMapping("/addFavorite/{userId}/{productId}")
public ResponseEntity<Object> addFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
    Optional<UserModel> existingUserOptional = userService.findById(userId);
    Optional<ProductModel> existingProductOptional = Optional.ofNullable(productService.findById(productId));

    if (existingUserOptional.isPresent() && existingProductOptional.isPresent()) {
        UserModel existingUser = existingUserOptional.get();
        ProductModel existingProduct = existingProductOptional.get();

        WishListModel wishListItem = new WishListModel();
        wishListItem.setUser(existingUser);
        wishListItem.setProduct(existingProduct);
        wishListItem.setStatus(true);
        wishListItem.setCreated_at(LocalDateTime.now().toString()); // Set created_at to current date and time

        wishListService.save(wishListItem);

        return new ResponseEntity<>("Thêm sản phẩm vào danh sách yêu thích thành công", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("User or product not found", HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/removeFavorite/{userId}/{productId}")
public ResponseEntity<Object> removeFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
    Optional<UserModel> existingUserOptional = userService.findById(userId);
    Optional<ProductModel> existingProductOptional = Optional.ofNullable(productService.findById(productId));

    if (existingUserOptional.isPresent() && existingProductOptional.isPresent()) {
        UserModel existingUser = existingUserOptional.get();
        ProductModel existingProduct = existingProductOptional.get();

        Optional<WishListModel> wishListItemOptional = wishListService.findByUserAndProduct(existingUser, existingProduct);

        if (wishListItemOptional.isPresent()) {
            wishListService.delete(wishListItemOptional.get());
            return new ResponseEntity<>("Đã xóa sản phẩm khỏi danh sách yêu thích", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sản phẩm không tồn tại trong danh sách yêu thích", HttpStatus.NOT_FOUND);
        }
    } else {
        return new ResponseEntity<>("User or product not found", HttpStatus.NOT_FOUND);
    }
}



}
