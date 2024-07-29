package com.example.shop_sv.modules.wishlist;

import com.example.shop_sv.modules.product.ProductModel;
import com.example.shop_sv.modules.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishListService {
    @Autowired
    WishListRepository wishListRepository;

    public void save(WishListModel wishListModel) {
        wishListRepository.save(wishListModel);
    }

    public Optional<WishListModel> findByUserAndProduct(UserModel user, ProductModel product) {
        return wishListRepository.findByUserAndProduct(user, product);
    }

    public void delete(WishListModel wishListModel) {
        wishListRepository.delete(wishListModel);
    }

    public Iterable<WishListModel> findAll() {
        return wishListRepository.findAll();
    }
}
