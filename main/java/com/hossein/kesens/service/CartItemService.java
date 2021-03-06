package com.hossein.kesens.service;

import com.hossein.kesens.model.CartItem;

import java.util.List;

/**
 * Created by hossein on 4/27/17.
 */
public interface CartItemService {
    public CartItem getCartItemById(int cartItemId);

    public List<CartItem> getAllCartItems();

    public void addCartItem(CartItem cartItem);

    public void removeCartItemById(int cartItemId);

    public void updateCartItem(CartItem cartItem);

    public void removeCartItem(CartItem cartItem);
}
