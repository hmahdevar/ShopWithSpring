package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.CustomerDao;
import com.hossein.kesens.model.access.Users;
import com.hossein.kesens.model.customer.Customer;
import com.hossein.kesens.service.AccessService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hossein on 4/16/17.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    SessionFactory sessionFactory;


    @Autowired
    private AccessService accessService;

    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, customerId);
        session.flush();
        return customer;
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createCriteria(Customer.class).list();
        session.flush();
        return customerList;
    }

    public void addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
//        session.saveOrUpdate(user);
        session.flush();
    }

    public void removeCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = getCustomerById(customerId);
        session.delete(customer);
        session.flush();
    }

    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }

    public void removeCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        session.flush();

    }

    public Customer getCustomerByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        Customer customer = (Customer) criteria.add(Restrictions.eq("email", email)).uniqueResult();
        return customer;
    }
}
