package com.example.shop.service.impl;

import com.example.shop.model.Cart;
import com.example.shop.model.Product;
import com.example.shop.service.CartService;
import com.example.shop.storage.CartStorage;
import com.example.shop.storage.ProductStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    @Override
    public Cart createCart(Cart cart) {
        CartStorage.cartStorageList.add(cart);
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart newCart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId().equals(cart.getId())) {
                tmp.setPriceInCard(cart.getPriceInCard());
                newCart = tmp;
            } else {
                System.err.println("Cannot find cart for update");
            }
        }
        return newCart;
    }

    @Override
    public void deleteCart(Cart cart) {
        CartStorage.cartStorageList.removeIf(tmp -> tmp.getId().equals(cart.getId()));
    }

    @Override
    public Cart getById(int id) {
        Cart cart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId() == id) {
                cart = tmp;
            } else {
                System.err.println("Cannot find cart id");
            }
        }
        return cart;
    }

    @Override
    public List<Cart> getAll() {
        return CartStorage.cartStorageList;
    }

    @Override
    public Cart addProductToCart(int id, int idProduct) {
        Cart cart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (id == tmp.getId()) {
                for (Product tmpProduct : ProductStorage.productStorageList) {
                    if (idProduct == tmpProduct.getId()) {
                        double sum = tmp.getPriceInCard() + tmpProduct.getPrice();
                        tmp.setPriceInCard(sum);
                        cart = tmp;
                    }
                }
            }
        }
        return cart;
    }

    @Override
    public Cart deleteProductFromCart(int id, int idProduct) {
        Cart cart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (id == tmp.getId()) {
                for (Product tmpProduct : ProductStorage.productStorageList) {
                    if (idProduct == tmpProduct.getId()) {
                        double sum = tmp.getPriceInCard() - tmpProduct.getPrice();
                        tmp.setPriceInCard(sum);
                        cart = tmp;
                    }
                }
            }
        }
        return cart;
    }

    @Override
    public Double getPriceInCard(int id) {
        double sum = 0.0;
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId() == id) {
                sum = tmp.getPriceInCard();
            }
        }
        return sum;
    }
}
