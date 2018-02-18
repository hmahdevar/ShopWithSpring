package com.hossein.kesens.model.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by hossein on 5/9/17.
 */
@Entity
public class Context implements Serializable{

    private static final long serialVersionUID = -1558854592378071128L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contextId;

    private String context;

    private String text;

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getContextId() {
        return contextId;
    }

    public void setContextId(int contextId) {
        this.contextId = contextId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
