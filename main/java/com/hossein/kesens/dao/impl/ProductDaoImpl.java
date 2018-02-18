package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.ProductDao;
import com.hossein.kesens.model.product.Attribute;
import com.hossein.kesens.model.product.AttributeItem;
import com.hossein.kesens.model.product.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hossein on 4/7/17.
 */
@Repository
@Transactional
//@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
    //    private Map<> productList;
    @Autowired
    private SessionFactory sessionFactory;

    public ProductDaoImpl() {
//        this.productList = new HashMap<int productId,product>();
    }

    public Product getProductById(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, productId);
        session.flush();
        return product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = session.createCriteria(Product.class).list();
        session.flush();
        return productList;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }



    public void removeProductById(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, productId);
        session.delete(product);
        session.flush();

    }

    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
//        Product product1 = getProductById(product.getProductId());
//        for (Object o: product.getAttributeList().toArray()) {
//            Attribute attribute = (Attribute) o;
//            AttributeItem attributeItem =attribute.getAttributeItem();
//            if (!product1.getAttributeList().contains(attribute))
//                    session.saveOrUpdate(attribute.getAttributeItem());
////            session.saveOrUpdate(attribute);
//        }
//        session.flush();
//
//        session = sessionFactory.getCurrentSession();
//        for (Object o: product.getAttributeList().toArray()) {
//            Attribute attribute = (Attribute) o;
////            session.saveOrUpdate(attribute.getAttributeItem());
//            session.saveOrUpdate(attribute);
//
//        }
////        session.flush();
////        session.delete(product1);
////        session.flush();
////        session = sessionFactory.getCurrentSession();

//        session.merge(product);
        session.saveOrUpdate(product);
        session.flush();

    }

    public void removeProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
