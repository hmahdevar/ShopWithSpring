package com.hossein.kesens.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hossein on 3/14/17.
 */

@Entity
public class Category implements Serializable{

    private static final long serialVersionUID = -1662303140797872921L;

    public Category() {
        productList = new ArrayList<Product>();
    }

    @Id
    @GeneratedValue
    private int categoryId;
    @NotEmpty(message = " نام دسته بندیالزامی است!!!")
    private String name;
    private int parentId;
    @JsonIgnore
    @ManyToMany(mappedBy = "categoryList", fetch = FetchType.EAGER)
    private List<Product> productList;
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }
}
