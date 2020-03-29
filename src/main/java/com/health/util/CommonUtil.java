package com.health.util;

import com.health.model.ContextModel;
import com.health.model.Item;
import com.health.model.SearchCondition;
import com.health.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CommonUtil {
    public static User getLoginUser(HttpServletRequest request) {
        Map<String, Object> context = ContextModel.getContext(request);
        return (User) context.get("login");
    }

    public static void logout(HttpServletRequest request) {
        ContextModel.getContext(request).put("login", null);
    }

    public static void login(HttpServletRequest request, User user) {
        ContextModel.getContext(request).put("login", user);
    }

    public static void setBuyNow(HttpServletRequest request, Long pid, Integer count) {
        Map<String, Object> context = ContextModel.getContext(request);
        Item item = new Item();
        item.setpId(pid);
        item.setCount(count);
        context.put("buyNow",item);
    }

    public static Item getBuyNow(HttpServletRequest request) {
        Map<String, Object> context = ContextModel.getContext(request);
        Object item = context.get("buyNow");
        if (item!=null)
        {
            return (Item) item;
        }
        return null;
    }

    public static void clearBuyNow(HttpServletRequest request) {
        Map<String, Object> context = ContextModel.getContext(request);
        context.put("buyNow",null);
    }

    public static void putSearchCondition(HttpServletRequest request, SearchCondition cond) {
        ContextModel.getContext(request).put("searchCondition",cond);
    }

    public static SearchCondition getSearchCondition(HttpServletRequest request) {
        return (SearchCondition) ContextModel.getContext(request).get("searchCondition");
    }

    public static void updateSearchCondition(HttpServletRequest request, SearchCondition cond) {
        SearchCondition old = getSearchCondition(request);


    }
}
