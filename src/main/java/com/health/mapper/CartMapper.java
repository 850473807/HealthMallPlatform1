package com.health.mapper;

import com.health.model.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    void add2Cart(Cart cart);

    List<Cart> qryCartByUser(@Param(value="uId")Long uId);

    Cart qryOldCart(Cart cart);

    void updateCart(Cart cart);
}
