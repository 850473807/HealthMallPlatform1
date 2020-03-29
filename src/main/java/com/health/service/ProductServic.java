package com.health.service;

import com.health.model.ProdDetail;
import com.health.model.Product;
import com.health.model.SearchCondition;

import java.util.List;
import java.util.Map;

public interface ProductServic {

    List<Product> searchProdsByCid(String cid);

    Map<String, Object> queryPage(String cid,Product condition);

    Map<String, Object> queryPage(String cid, Product condition, Integer currentPage);

    ProdDetail queryProdDetail2Page(Long pid);

    Map<String, Object> queryByCondition(SearchCondition cond);
}
