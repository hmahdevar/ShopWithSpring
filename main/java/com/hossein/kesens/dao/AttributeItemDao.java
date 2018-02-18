package com.hossein.kesens.dao;

import com.hossein.kesens.model.product.AttributeItem;

import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
public interface AttributeItemDao {
    public AttributeItem getAttributeItemById(int attributeItemId);

    public List<AttributeItem> getAllAttributeItems();

    public void addAttributeItem(AttributeItem attributeItem);

    public void removeAttributeItemById(int attributeItemId);

    public void updateAttributeItem(AttributeItem attributeItem);

    public void removeAttributeItem(AttributeItem attributeItem);
}
