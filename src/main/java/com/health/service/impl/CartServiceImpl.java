package com.health.service.impl;

import com.health.mapper.CartMapper;
import com.health.mapper.ProdDetailMapper;
import com.health.mapper.ProductMapper;
import com.health.model.*;
import com.health.service.CartService;
import com.health.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProdDetailMapper prodDetailMapper;

    @Override
    public void add2Cart(Long user, Long pid, Integer count) {
        Cart cart = new Cart();
        cart.setuId(user);
        cart.setpId(pid);
        Cart oldCart = cartMapper.qryOldCart(cart);
        if (oldCart!=null)
        {
            cart.setCount(oldCart.getCount()+count);
            cartMapper.updateCart(cart);
            return;
        }
        cart.setCount(count);
        cartMapper.add2Cart(cart);
    }

    @Override
    public List<Item> getItems(Item item) {
        if (item == null) {
            return null;
        }
        Item item1 = getItem(item.getpId(), item.getCount());
        List<Item> list = new ArrayList<>();
        list.add(item1);
        return list;

    }

    @Override
    public Long getTotalPrice(List<Item> list) {
        Long totalPrice = 0L;
        for (Item item : list) {
            totalPrice += item.getSumPrice();
        }
        return totalPrice;
    }

    @Override
    public List<Item> getCart(User loginUser) {

        List<Cart> carts = cartMapper.qryCartByUser(loginUser.getId());
        List<Item> list = new ArrayList<>();
        for (Cart cart : carts) {

            Item item1 = getItem(cart.getpId(), cart.getCount());

            list.add(item1);
        }

        return list;

    }

    /**
     * 根据产品id和数量计算单个产品的订单信息
     * @param pid
     * @param count
     * @return
     */
    private Item getItem(Long pid, Integer count) {
        Product product = new Product();
        product.setPid(pid);
        product = productMapper.queryProductById(product);

        Item item1 = new Item();
        item1.setCount(count);
        item1.setName(product.getPname());
        item1.setImg(product.getImg());
        item1.setPrice(product.getPrice());

        ProdDetail detail = new ProdDetail();
        detail.setPid(pid);
        Long platformPrice = prodDetailMapper.queryProdDetail(detail).getPlatformPrice();
        item1.setPlatformPrice(platformPrice);
        item1.setDiscount();
        item1.setDisRate();
        item1.setSumPrice();
        return item1;
    }
}
