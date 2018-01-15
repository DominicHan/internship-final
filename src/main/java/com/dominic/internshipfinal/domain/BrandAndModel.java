package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.Brand;
import com.dominic.internshipfinal.domain.entity.GetModel;

import java.util.List;

public class BrandAndModel {
    private List<String> brandList;
    private List<String> getModelList;


    public List<String> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<String> brandList) {
        this.brandList = brandList;
    }

    public List<String> getGetModelList() {
        return getModelList;
    }

    public void setGetModelList(List<String> getModelList) {
        this.getModelList = getModelList;
    }
}
