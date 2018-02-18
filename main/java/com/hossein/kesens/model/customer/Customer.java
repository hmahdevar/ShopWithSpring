package com.hossein.kesens.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hossein.kesens.model.Cart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hossein on 4/11/17.
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = -6493500388468477948L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;


    private String customerEmail;
    private String customerPassword;
    private String customerPhoneNumber;
    private String customerName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Address> customerAddressList;
    private boolean enabled;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Property> propertyList;


    public Customer() {
        this.cart = new Cart();
        this.cart.setCustomer(this);

    }

    public int getCustomerId() {
        return customerId;
    }


    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Address> getCustomerAddressList() {
        return customerAddressList;
    }

    public void setCustomerAddressList(List<Address> customerAddressList) {
        this.customerAddressList = customerAddressList;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
