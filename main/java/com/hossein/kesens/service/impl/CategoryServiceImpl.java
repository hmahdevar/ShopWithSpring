package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.CategoryDao;
import com.hossein.kesens.model.product.Category;
import com.hossein.kesens.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
@Repository
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    public Category getCategoryById(int categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    public List<Category> getAllCategorys() {
        return categoryDao.getAllCategorys();
    }

    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    public void removeCategoryById(int categoryId) {
        categoryDao.removeCategoryById(categoryId);
    }

    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    public void removeCategory(Category category) {
        categoryDao.removeCategory(category);
    }
}
