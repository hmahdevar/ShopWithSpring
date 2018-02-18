package com.hossein.kesens.dao;

import com.hossein.kesens.model.product.Category;

import java.util.List;

/**
 * Created by hossein on 4/19/17.
 */
public interface CategoryDao {
    public Category getCategoryById(int categoryId);

    public List<Category> getAllCategorys();

    public void addCategory(Category category);

    public void removeCategoryById(int categoryId);

    public void updateCategory(Category category);

    public void removeCategory(Category category);
}
