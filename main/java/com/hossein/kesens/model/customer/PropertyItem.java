package com.hossein.kesens.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hossein on 4/12/17.
 */
@Entity
public class PropertyItem implements Serializable {

    private static final long serialVersionUID = -3351316889584792924L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int propertyItemId;
    @Column(columnDefinition = "TEXT")
    private String name;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyItem", fetch = FetchType.EAGER)
    private List<Property> propertyList;

    public int getPropertyItemId() {
        return propertyItemId;
    }

    public void setPropertyItemId(int propertyItemId) {
        this.propertyItemId = propertyItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
}
