package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.CustomerDao;
import com.hossein.kesens.model.customer.Customer;
import com.hossein.kesens.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hossein on 4/24/17.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public void removeCustomerById(int customerId) {
        customerDao.removeCustomerById(customerId);

    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    public void removeCustomer(Customer customer) {
        customerDao.removeCustomer(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }
}
