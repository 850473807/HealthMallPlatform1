package com.health.controller;

import com.health.model.Item;
import com.health.model.User;
import com.health.service.CartService;
import com.health.service.PageService;
import com.health.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add2Cart")
    public void init(HttpServletRequest request, @RequestParam(value =
            "pid") Long pid, @RequestParam(value =
            "count") Integer count) {
        User loginUser = CommonUtil.getLoginUser(request);

        if (loginUser == null || pid == null || count == null) {
            return;
        }
        Long uid = loginUser.getId();
        cartService.add2Cart(uid, pid, count);

    }

    @PostMapping("/buyNow")
    public Object buyNow(HttpServletRequest request, @RequestParam(value =
            "pid") Long pid, @RequestParam(value =
            "count") Integer count) {
        User loginUser = CommonUtil.getLoginUser(request);

        Map<String, String> map = new HashMap<>();

        if (loginUser == null || pid == null || count == null) {
            map.put("href","/html/login.html");
            return map;
        }

        CommonUtil.setBuyNow(request,pid,count);
        map.put("href","/html/cart.html");
        return map;
    }


    @RequestMapping("/item")
    public Object item(HttpServletRequest request) {
        User loginUser = CommonUtil.getLoginUser(request);

        if (loginUser == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<>();
        Item item = CommonUtil.getBuyNow(request);
        if (item != null)
        {
            List<Item> list =cartService.getItems(item);
            Long totalPrice =cartService.getTotalPrice(list);
            map.put("items",list);
            map.put("totalPrice",totalPrice);
        }
        else
        {
            List<Item> list = cartService.getCart(loginUser);
            Long totalPrice =cartService.getTotalPrice(list);
            map.put("items",list);
            map.put("totalPrice",totalPrice);
        }


        return map;
    }

    @RequestMapping("/toCart")
    public Object toCart(HttpServletRequest request) {
        User loginUser = CommonUtil.getLoginUser(request);

        Map<String, String> map = new HashMap<>();

        if (loginUser == null) {
            map.put("href","/html/login.html");
            return map;
        }

        CommonUtil.clearBuyNow(request);
        map.put("href","/html/cart.html");
        return map;
    }
}
