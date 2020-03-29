package com.health.mapper;

import com.health.model.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> queryCategory(Category category);
}
