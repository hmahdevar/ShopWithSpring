package com.hossein.kesens.dao;

import com.hossein.kesens.model.product.Product;

import java.util.List;

/**
 * Created by hossein on 3/13/17.
 */
public interface ProductDao {

    public Product getProductById(int productId);

    public List<Product> getAllProducts();

    public void addProduct(Product product);

    public void removeProductById(int productId);

    public void updateProduct(Product product);

    public void removeProduct(Product product);
}
