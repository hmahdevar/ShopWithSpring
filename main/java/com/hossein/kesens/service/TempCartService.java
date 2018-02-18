package com.hossein.kesens.service;

import com.hossein.kesens.model.Cart;

import java.util.List;

/**
 * Created by hossein on 5/4/17.
 */
public interface TempCartService {
    public Cart getCartBySessionId(String sessionId);
    public List<Cart> getAllCarts();
    public void removeCartBySessionId(String sessionId);
    public void updateCart(String sessionId, Cart cart);
}
