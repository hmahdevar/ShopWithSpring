package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.ProductDao;
import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hossein on 4/13/17.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public void removeProductById(int productId) {
        productDao.removeProductById(productId);
    }

    public List<Product> getProductList() {
        return productDao.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void removeProduct(Product product) {
        productDao.removeProduct(product);
    }
}