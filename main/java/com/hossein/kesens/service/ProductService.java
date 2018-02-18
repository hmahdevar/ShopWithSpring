package com.hossein.kesens.service;

import com.hossein.kesens.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hossein on 4/12/17.
 */

public interface ProductService {
    List<Product> getProductList();
    Product getProductById(int productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(Product product);
    public void removeProductById(int productId);
}
