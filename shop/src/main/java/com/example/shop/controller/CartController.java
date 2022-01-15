package com.example.shop.controller;

import com.example.shop.model.Cart;
import com.example.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("cart/create")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/cart/update")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("cart/delete")
    public void deleteCart(@RequestBody Cart cart) {
        cartService.deleteCart(cart);
    }

    @GetMapping("cart/{id}")
    public Cart findById(@PathVariable int id) {
        return cartService.getById(id);
    }

    @GetMapping("/cart/all")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PutMapping("cart/{id}/add/{idProduct}")
    public Cart addProduct(@PathVariable int id, @PathVariable int idProduct) {
        return cartService.addProductToCart(id, idProduct);
    }

    @DeleteMapping("cart/{id}/delete/{idProduct}")
    public Cart deleteProduct(@PathVariable int id, @PathVariable int idProduct) {
        return cartService.deleteProductFromCart(id, idProduct);
    }

    @GetMapping("cart/price/{id}")
    public Double getPriceFromCart(@PathVariable int id) {
        return cartService.getPriceInCard(id);
    }
}
