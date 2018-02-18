package com.hossein.kesens.service.impl;

import com.hossein.kesens.model.Cart;
import com.hossein.kesens.service.TempCartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossein on 5/4/17.
 */
@Service
public class TempCartServiceImpl implements TempCartService {

    private Map<String, Cart> cartMap = new HashMap<String, Cart>();

    public Cart getCartBySessionId(String sessionId) {
        Cart cart = cartMap.get(sessionId);
        if (cart != null)
            return cart;
        return new Cart();
    }

    public List<Cart> getAllCarts() {
        List<Cart> list = new ArrayList<Cart>();
        list.addAll(cartMap.values());
        return list;
    }

    public void removeCartBySessionId(String sessionId) {
        if (cartMap.containsKey(sessionId))
            cartMap.remove(sessionId);
    }

    public void updateCart(String sessionId, Cart cart) {
        cartMap.put(sessionId, cart);
    }


}
