package com.hossein.kesens.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hossein on 4/10/17.
 */
@Entity
public class AttributeItem implements Serializable {
    private static final long serialVersionUID = 7321115779360999464L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attributeItemId;
    @Column(columnDefinition = "TEXT")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "attributeItem", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Attribute> attributeList;

    public AttributeItem() {
        attributeList = new ArrayList<Attribute>();
    }

    public AttributeItem(String name) {
        this.name = name;
    }

    public int getAttributeItemId() {
        return attributeItemId;
    }

    public void setAttributeItemId(int attributeItemId) {
        this.attributeItemId = attributeItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAtribute() {
        return attributeList;
    }
    public void setAtribute(List<Attribute> atribute) {
        this.attributeList = atribute;
    }

    public void addAttribute(Attribute attribute){
        attributeList.add(attribute);
    }
    public void removeAttribute(Attribute attribute){
        attributeList.remove(attribute);
    }

}
