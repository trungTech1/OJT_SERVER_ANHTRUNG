package com.example.shop_sv.modules.cart_item;

import com.example.shop_sv.modules.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("")
    public ResponseEntity<Object> findAll(
            @RequestAttribute("data") UserModel user
    ) {
        List<CartItem> cartItems = cartService.findByUserId(user.getId());
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create (@RequestAttribute("data") UserModel user, @RequestBody CartItem cartItem
    ) {
        try {
            cartService.save(user,cartItem);
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(
            @PathVariable Byte id,
            @RequestBody CartItem cartItem
    ) {
        try {
            cartService.update(cartItem, id);
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable Byte id
    ) {
        try {
            cartService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
