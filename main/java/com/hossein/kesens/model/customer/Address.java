package com.hossein.kesens.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hossein on 4/11/17.
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 8655851883846276464L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    //ostan
    private String state;
    //shahr
    private String city;
    //khiaban
    private String street;
    //ma baghi address
    @Column(columnDefinition = "TEXT")
    private String address;
    //code posti
    private String zipCode;
    //telefone ezterari
    private String emmergencyPhone;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmmergencyPhone() {
        return emmergencyPhone;
    }

    public void setEmmergencyPhone(String emmergencyPhone) {
        this.emmergencyPhone = emmergencyPhone;
    }
}
