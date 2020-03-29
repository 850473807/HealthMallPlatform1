package com.health.service.impl;

import com.health.mapper.CategoryMapper;
import com.health.mapper.UserMapper;
import com.health.model.Category;
import com.health.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PageServiceImpl implements PageService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllCategory() {
        Category condition = new Category();
        List<Category> result = categoryMapper.queryCategory(condition);
        return result;
    }

    @Override
    public Map<String, Object> initPage() {
        List<Category> category = queryAllCategory();
        HashMap<String, Object> map = new HashMap<>();
        map.put("category",category);
        return map;
    }
}
