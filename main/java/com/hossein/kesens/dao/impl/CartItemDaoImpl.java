package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.CartItemDao;
import com.hossein.kesens.model.Cart;
import com.hossein.kesens.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hossein on 4/27/17.
 */

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{
    @Autowired
    private SessionFactory sessionFactory;
    public CartItem getCartItemById(int cartItemId) {

        Session session = sessionFactory.getCurrentSession();
        CartItem cartItem = (CartItem) session.load(CartItem.class,cartItemId);
        session.flush();
        return cartItem;
    }

    public List<CartItem> getAllCartItems() {
        Session session =sessionFactory.getCurrentSession();
        List<CartItem> cartItemList =session.createCriteria(CartItem.class).list();
        session.flush();
        return cartItemList;
    }

    public void addCartItem(CartItem cartItem) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItemById(int cartItemId) {
        Session session =sessionFactory.getCurrentSession();
        CartItem cartItem = getCartItemById(cartItemId);
        session.delete(cartItem);
        session.flush();
    }

    public void updateCartItem(CartItem cartItem) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session =sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }
}
