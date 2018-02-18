package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.CartDao;
import com.hossein.kesens.model.Cart;
import com.hossein.kesens.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hossein on 4/25/17.
 */
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public List<Cart> getAllCarts() {
        return cartDao.getAllCarts();
    }

    public void addCart(Cart cart) {
        cartDao.addCart(cart);
    }

    public void removeCartById(int cartId) {
        cartDao.removeCartById(cartId);
    }

    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    public void removeCart(Cart cart) {
        cartDao.removeCart(cart);
    }
}
