package com.health.mapper;

import com.health.model.ProdDetail;
import com.health.model.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> queryProduct(Product product);

    Product queryProductById(Product product);

    List<Product> queryProductByCondition(Product product);
}
