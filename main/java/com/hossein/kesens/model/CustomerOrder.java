package com.hossein.kesens.model;

import com.hossein.kesens.model.customer.Address;
import com.hossein.kesens.model.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hossein on 4/12/17.
 */
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 300350214431818778L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerOrderId;
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
