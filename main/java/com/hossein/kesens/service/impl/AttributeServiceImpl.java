package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.AttributeDao;
import com.hossein.kesens.model.product.Attribute;
import com.hossein.kesens.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
@Repository
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeDao attributeDao;

    public Attribute getAttributeById(int attributeId) {
        return attributeDao.getAttributeById(attributeId);
    }

    public List<Attribute> getAllAttributes() {
        return attributeDao.getAllAttributes();
    }

    public void addAttribute(Attribute attribute) {
        attributeDao.addAttribute(attribute);
    }

    public void removeAttributeById(int attributeId) {
        attributeDao.removeAttributeById(attributeId);
    }

    public void updateAttribute(Attribute attribute) {
        attributeDao.updateAttribute(attribute);
    }

    public void removeAttribute(Attribute attribute) {
        attributeDao.removeAttribute(attribute);
    }
}
