package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.CartItemDao;
import com.hossein.kesens.model.CartItem;
import com.hossein.kesens.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hossein on 4/27/17.
 */
@Repository
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;
    public CartItem getCartItemById(int cartItemId) {
        return cartItemDao.getCartItemById(cartItemId);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemDao.getAllCartItems();
    }

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItemById(int cartItemId) {
        cartItemDao.removeCartItemById(cartItemId);
    }

    public void updateCartItem(CartItem cartItem) {
        cartItemDao.updateCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }
}
