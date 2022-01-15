package com.example.shop.service;

import com.example.shop.model.Cart;

import java.util.List;

public interface CartService {
    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);

    void deleteCart(Cart cart);

    Cart getById(int id);

    List<Cart> getAll();

    Cart addProductToCart(int id, int idProduct);

    Cart deleteProductFromCart(int id, int idProduct);

    Double getPriceInCard(int id);
}
