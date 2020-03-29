package com.health.controller;

import com.health.model.ContextModel;
import com.health.model.ProdDetail;
import com.health.model.SearchCondition;
import com.health.service.ProductServic;
import com.health.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/prod")
public class ProductController {

    @Autowired
    private ProductServic productServic;

/*
    @RequestMapping("/init")
    public Object init(HttpServletRequest request) {
        String cid = (String) ContextModel.getContext(request).get(
                "category");

        Map<String, Object> map = productServic.queryPage(cid, null);

        return map;
    }
*/

    @RequestMapping("/init1")
    public Object init1(HttpServletRequest request) {
        SearchCondition cond = CommonUtil.getSearchCondition(request);

        Map<String, Object> map =productServic.queryByCondition(cond);

        return map;
    }

    /*
    @RequestMapping("/search")
    public Object search(HttpServletRequest request, @RequestParam Integer currentPage) {
        String cid = (String) ContextModel.getContext(request).get(
                "category");

        Map<String, Object> map = productServic.queryPage(cid, null, currentPage);

        return map;
    }
    */

    /**
     * list界面的搜索按钮
     * @param request
     * @param cond
     * @return
     */
    @RequestMapping("/search")
    public Object search(HttpServletRequest request,
                          @ModelAttribute SearchCondition cond) {

        SearchCondition condition = CommonUtil.getSearchCondition(request);
        condition.setBrand(cond.getBrand(true));
        condition.setPrice(cond.getPrice(true));

        Map<String, Object> map =productServic.queryByCondition(condition);

        return map;
    }

    @RequestMapping("/qryPage")
    public Object qryPage(HttpServletRequest request,
                         @ModelAttribute SearchCondition cond) {

        SearchCondition condition = CommonUtil.getSearchCondition(request);
        condition.setCurrentPage(cond.getCurrentPage());

        Map<String, Object> map =productServic.queryByCondition(condition);

        return map;
    }

    @RequestMapping("/detail")
    public Object detail(HttpServletRequest request) {
        String pid = (String)ContextModel.getContext(request).get("prod");
        if (pid == null)
        {
            return null;
        }

        ProdDetail detail = productServic.queryProdDetail2Page(Long.parseLong(pid));

        return detail;
    }
}
