package com.hossein.kesens.dao;

import com.hossein.kesens.model.customer.Customer;

import java.util.List;

/**
 * Created by hossein on 4/16/17.
 */
public interface CustomerDao {
    public Customer getCustomerById(int customerId);

    public List<Customer> getAllCustomers();

    public void addCustomer(Customer customer);

    public void removeCustomerById(int customerId);

    public void updateCustomer(Customer customer);

    public void removeCustomer(Customer customer);

    public Customer getCustomerByEmail(String email);
}
