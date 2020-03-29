package com.health.service;

import com.health.model.Item;
import com.health.model.User;

import java.util.List;

public interface CartService {
    void add2Cart(Long user, Long pid, Integer count);

    List<Item> getItems(Item item);

    Long getTotalPrice(List<Item> list);

    List<Item> getCart(User loginUser);
}
