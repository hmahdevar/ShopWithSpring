package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.AttributeDao;
import com.hossein.kesens.model.product.Attribute;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hossein on 5/9/17.
 */
@Repository
@Transactional
public class AttributeDaoImpl implements AttributeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Attribute getAttributeById(int attributeId) {
        Session session = sessionFactory.getCurrentSession();
        Attribute attribute = (Attribute) session.load(Attribute.class, attributeId);
        session.flush();
        return attribute;
    }

    public List<Attribute> getAllAttributes() {
        Session session = sessionFactory.getCurrentSession();
        List<Attribute> attributeList = session.createCriteria(Attribute.class).list();
        session.flush();
        return attributeList;
    }

    public void addAttribute(Attribute attribute) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(attribute);
        session.flush();
    }

    public void removeAttributeById(int attributeId) {
        Session session = sessionFactory.getCurrentSession();
        Attribute attribute = (Attribute) session.load(Attribute.class, attributeId);
        session.delete(attribute);
        session.flush();

    }

    public void updateAttribute(Attribute attribute) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(attribute);
        session.flush();

    }

    public void removeAttribute(Attribute attribute) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(attribute);
        session.flush();

    }
}
