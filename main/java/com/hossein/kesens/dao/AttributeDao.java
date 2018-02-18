package com.hossein.kesens.dao;

import com.hossein.kesens.model.product.Attribute;

import java.util.List;

/**
 * Created by hossein on 5/9/17.
 */
public interface AttributeDao {
    public Attribute getAttributeById(int attributeId);

    public List<Attribute> getAllAttributes();

    public void addAttribute(Attribute attribute);

    public void removeAttributeById(int attributeId);

    public void updateAttribute(Attribute attribute);

    public void removeAttribute(Attribute attribute);
}
