package com.hossein.kesens.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hossein.kesens.model.CartItem;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hossein on 3/13/17.
 */
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = -8933164924218402118L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @NotEmpty(message = "اسم محصول الزامی است!!!")
    private String name = "";

    private Date addTime;

    @Min(value = 0, message = "قیمت محصول باید عددی نا منفی باشد!!!")
    private long price = 0;

    @Min(value = 0, message = " تعداد محصول باید عددی نا منفی باشد!!!")
    private int quantity = 0;

    @JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "Product_Category",
            joinColumns =
            @JoinColumn(name = "productId", referencedColumnName = "productId"),
            inverseJoinColumns =
            @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    )
    private List<Category> categoryList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "product", fetch = FetchType.LAZY)
    private List<Attribute> attributeList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItemList;


    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(columnDefinition = "TEXT")
    private String summaryDescription;

    public Product() {
        categoryList = new ArrayList<Category>();
        attributeList = new ArrayList<Attribute>();
        addTime = Calendar.getInstance().getTime();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummaryDescription() {
        return summaryDescription;
    }

    public void setSummaryDescription(String summaryDescription) {
        this.summaryDescription = summaryDescription;
    }

    public void setCategorys(List<Category> categorys) {
        this.categoryList = categorys;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public void addCategory(Category category) {
        category.addProduct(this);
        categoryList.add(category);
    }

    public void removeCategory(Category category) {

//        category.addProduct(this);
        categoryList.remove(category);
    }

    public void addAttribute(Attribute attribute) {
        attribute.setProduct(this);
        attributeList.add(attribute);
    }

    public void removeAttribute(Attribute attribute) {
//        attribute.removeProduct(this);
        attributeList.remove(attribute);
    }

}
