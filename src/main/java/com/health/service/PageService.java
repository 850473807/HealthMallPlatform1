package com.health.service;

import com.health.model.Category;

import java.util.List;
import java.util.Map;

public interface PageService {
    List<Category> queryAllCategory();

    Map<String,Object> initPage();
}
