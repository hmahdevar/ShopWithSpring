package com.hossein.kesens.dao.impl;


import com.hossein.kesens.model.product.AttributeItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hossein.kesens.dao.AttributeItemDao;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
@Repository
@Transactional
public class AttributeItemDaoImpl implements AttributeItemDao {

    
    @Autowired
    private SessionFactory sessionFactory;

    public AttributeItem getAttributeItemById(int attributeItemId) {
        Session session = sessionFactory.getCurrentSession();
        AttributeItem attributeItem = (AttributeItem) session.load(AttributeItem.class, attributeItemId);
        session.flush();
        return attributeItem;
    }

    public List<AttributeItem> getAllAttributeItems() {
        Session session = sessionFactory.getCurrentSession();
        List<AttributeItem> attributeItemList = session.createCriteria(AttributeItem.class).list();
        session.flush();
        return attributeItemList;
    }

    public void addAttributeItem(AttributeItem attributeItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(attributeItem);
        session.flush();
    }

    public void removeAttributeItemById(int attributeItemId) {
        Session session = sessionFactory.getCurrentSession();
        AttributeItem attributeItem = (AttributeItem) session.load(AttributeItem.class, attributeItemId);
        session.delete(attributeItem);
        session.flush();

    }

    public void updateAttributeItem(AttributeItem attributeItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(attributeItem);
        session.flush();

    }

    public void removeAttributeItem(AttributeItem attributeItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(attributeItem);
        session.flush();

    }
}
