package com.dominic.internshipfinal.service;

import com.dominic.internshipfinal.domain.entity.Goods;

import java.util.List;
import java.util.Map;

public interface ClassificationService {
    List<Goods> getGoods(Map map);
}
