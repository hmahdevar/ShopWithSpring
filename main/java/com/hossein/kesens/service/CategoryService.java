package com.hossein.kesens.service;

import com.hossein.kesens.model.product.Category;

import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
public interface CategoryService {

    public Category getCategoryById(int categoryId);

    public List<Category> getAllCategorys();

    public void addCategory(Category category);

    public void removeCategoryById(int categoryId);

    public void updateCategory(Category category);

    public void removeCategory(Category category);
}
