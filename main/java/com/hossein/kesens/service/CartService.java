package com.hossein.kesens.service;

import com.hossein.kesens.model.Cart;

import java.util.List;

/**
 * Created by hossein on 4/25/17.
 */
public interface CartService {
    public Cart getCartById(int cartId);

    public List<Cart> getAllCarts();

    public void addCart(Cart cart);

    public void removeCartById(int cartId);

    public void updateCart(Cart cart);

    public void removeCart(Cart cart);
}
