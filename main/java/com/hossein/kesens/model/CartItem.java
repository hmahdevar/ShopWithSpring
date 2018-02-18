package com.hossein.kesens.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hossein.kesens.model.product.Product;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hossein on 4/11/17.
 */
@Entity
public class CartItem implements Serializable {
    private static final long serialVersionUID = -8052181198875263888L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartItemId;
    @ManyToOne
    @JoinColumn(name = "productId")
    @JsonIgnore
    private Product product;
    private int quantity;
    private long totalPrice;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public CartItem() {
    }

    public CartItem(Product product) {
        this.product = product;
        quantity = 1;
        totalPrice = product.getPrice();

    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        totalPrice = product.getPrice()*quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
