package com.example.shop_sv.modules.cart_item;

import com.example.shop_sv.modules.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public CartItem save(UserModel user, CartItem cartItem) {
        //kiem tra xem user da co cart chua
        List<CartItem> cartItems = cartRepository.findByUserId(user.getId());
        for (CartItem item : cartItems) {
            if (item.getProductDetailId().equals(cartItem.getProductDetailId())) {
                item.setQuantity((byte) (item.getQuantity() + cartItem.getQuantity()));
                return cartRepository.save(item);
            }
        }
        cartItem.setUserId(user.getId());
        return cartRepository.save(cartItem);
    }

    public void delete(Byte id) {
        cartRepository.deleteById(id);
    }

    public CartItem update(CartItem cartItem, Byte id) {
        CartItem cartItem1 = cartRepository.findById(id).orElse(null);
        if (cartItem1 == null) {
            return null;
        }
        return cartRepository.save(cartItem);
    }

    public CartItem findById(Byte id) {
        return cartRepository.findById(id).orElse(null);
    }

    public List<CartItem> findByUserId(Integer userId) {
        return cartRepository.findByUserId(userId);
    }
}
