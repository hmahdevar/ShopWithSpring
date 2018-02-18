package com.hossein.kesens.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hossein on 4/10/17.
 */
@Entity
public class Attribute implements Serializable {

    private static final long serialVersionUID = 6845941457491813059L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attributeId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "attributeItem")
    private AttributeItem attributeItem;


    @Column(columnDefinition = "TEXT")
    private String value = "";


    @ManyToOne
    @JoinColumn(name = "productId")
    @JsonIgnore
    private Product product;


    public Attribute() {
        this.attributeItem = new AttributeItem();
    }


    public Attribute(String value, String attributeItemName) {
        this.value = value;
        attributeItem = new AttributeItem(attributeItemName);
    }

    public Attribute(AttributeItem attributeItem, String value) {
        attributeItem.addAttribute(this);
        this.attributeItem = attributeItem;
        this.value = value;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public AttributeItem getAttributeItem() {
        return attributeItem;
    }

    public void setAttributeItem(AttributeItem attributeItem) {
//        this.attributeItem.removeAttribute(this);
        this.attributeItem = attributeItem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttributeItemName() {
        return this.attributeItem.getName();
    }

    public void setAttributeItemName(String name) {
        this.attributeItem.setName(name);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
