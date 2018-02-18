package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.CartDao;
import com.hossein.kesens.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hossein on 4/15/17.
 */
@Repository
@Transactional
public class CartDaoImp implements CartDao {

    @Autowired
    SessionFactory sessionFactory;
    public Cart getCartById(int cartId) {
        Session session =sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.load(Cart.class,cartId);
        session.flush();
        return cart;
    }

    public List<Cart> getAllCarts()
    {
        Session session =sessionFactory.getCurrentSession();
        List<Cart> cartList =session.createCriteria(Cart.class).list();
        session.flush();
        return cartList;
    }

    public void addCart(Cart cart) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    public void removeCartById(int cartId) {
        Session session =sessionFactory.getCurrentSession();
        Cart cart = getCartById(cartId);
        session.delete(cart);
        session.flush();
    }

    public void updateCart(Cart cart) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    public void removeCart(Cart cart) {
        Session session =sessionFactory.getCurrentSession();
        session.delete(cart);
        session.flush();
    }
}
