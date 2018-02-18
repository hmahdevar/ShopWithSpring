package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.AttributeItemDao;
import com.hossein.kesens.model.product.AttributeItem;
import com.hossein.kesens.service.AttributeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
@Repository
public class AttributeItemServiceImpl implements AttributeItemService{

    @Autowired
    private AttributeItemDao attributeItemDao;

    public AttributeItem getAttributeItemById(int attributeItemId) {
        return attributeItemDao.getAttributeItemById(attributeItemId);
    }

    public List<AttributeItem> getAllAttributeItems() {
        return attributeItemDao.getAllAttributeItems();
    }

    public void addAttributeItem(AttributeItem attributeItem) {
        attributeItemDao.addAttributeItem(attributeItem);
    }

    public void removeAttributeItemById(int attributeItemId) {
        attributeItemDao.removeAttributeItemById(attributeItemId);
    }

    public void updateAttributeItem(AttributeItem attributeItem) {
        attributeItemDao.updateAttributeItem(attributeItem);
    }

    public void removeAttributeItem(AttributeItem attributeItem) {
        attributeItemDao.removeAttributeItem(attributeItem);
    }
}
