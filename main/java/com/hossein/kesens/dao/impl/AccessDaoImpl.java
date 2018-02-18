package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.AccessDao;
import com.hossein.kesens.model.access.Authorities;
import com.hossein.kesens.model.access.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hossein on 4/16/17.
 */
@Repository
@Transactional
public class AccessDaoImpl implements AccessDao {
    @Autowired
    SessionFactory sessionFactory;

    public void addUser(Users user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();

    }

    public void updateUser(Users user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();


    }

    public void removeUser(Users user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();

    }

    public void addAuthority(Authorities authority) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(authority);
        session.flush();
    }

    public void updateAuthority(Authorities authority) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(authority);
        session.flush();
    }

    public void removeAuthority(Authorities authority) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(authority);
        session.flush();
    }

    public Users getUserById(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users) session.load(Users.class, userId);
        return user;
    }

    public Users getUserByEmail(String userEmail) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Users.class);
        Users user = (Users) criteria.add(Restrictions.eq("email", userEmail)).uniqueResult();
        return user;
    }
}
