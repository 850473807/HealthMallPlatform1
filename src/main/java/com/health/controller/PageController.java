package com.health.controller;

import com.health.model.ContextModel;
import com.health.model.Message;
import com.health.model.SearchCondition;
import com.health.model.User;
import com.health.service.PageService;
import com.health.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private PageService pageService;


    @PostMapping("/init")
    public Object init(HttpServletRequest request,
                       HttpServletResponse response) {
        User loginUser = CommonUtil.getLoginUser(request);
        String user = loginUser == null ? null : loginUser.getName();

        Map<String, Object> result = new HashMap<>();
        result.put("user", user);

        Map<String, Object> map = pageService.initPage();
        result.putAll(map);

        return result;
    }

    /*
    @RequestMapping("/search")
    public Object search(HttpServletRequest request, @RequestParam(value =
            "category") String category) {

        ContextModel.getContext(request).put("category", category);

        ModelAndView mv = new ModelAndView("/html/list");
        return mv;
    }
    */

    @RequestMapping("/detail")
    public Object detail(HttpServletRequest request, @RequestParam(value =
            "prod") String prod) {

        ContextModel.getContext(request).put("prod", prod);

        ModelAndView mv = new ModelAndView("/html/details");
        return mv;
    }

    @RequestMapping("/search")
    public Object search(HttpServletRequest request,
                          @ModelAttribute SearchCondition cond) {

        CommonUtil.putSearchCondition(request,cond);

        ModelAndView mv = new ModelAndView("/html/list");
        return mv;
    }
}
