package com.dominic.internshipfinal.domain.entity;

import java.io.Serializable;

public class GetModel implements Serializable {
    private Integer id;

    private String modelName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }
}