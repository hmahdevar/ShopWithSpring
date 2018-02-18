package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.CategoryDao;
import com.hossein.kesens.model.product.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{


    @Autowired
    private SessionFactory sessionFactory;

    public Category getCategoryById(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, categoryId);
        session.flush();
        return category;
    }

    public List<Category> getAllCategorys() {
        Session session = sessionFactory.getCurrentSession();
        List<Category> categoryList = session.createCriteria(Category.class).list();
        session.flush();
        return categoryList;
    }

    public void addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        session.flush();
    }

    public void removeCategoryById(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, categoryId);
        session.delete(category);
        session.flush();

    }

    public void updateCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        session.flush();

    }

    public void removeCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
        session.flush();

    }
}
