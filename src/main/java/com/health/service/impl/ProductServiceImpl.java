package com.health.service.impl;

import com.health.mapper.BrandMapper;
import com.health.mapper.ProdDetailMapper;
import com.health.mapper.ProductMapper;
import com.health.model.*;
import com.health.service.ProductServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductServic {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProdDetailMapper prodDetailMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Product> searchProdsByCid(String cid) {

        Product condition = new Product();

        if (!StringUtils.isEmpty(cid))
        {
            condition.setPcategory(Long.parseLong(cid));
        }

        condition.setStart(null);


        List<Product> list = productMapper.queryProduct(condition);

        return list;

    }

    @Override
    public Map<String, Object> queryPage(String cid,Product condition) {

        return queryPage(cid,null,1);
    }

    private Product getCondition(Product condition) {
        if (condition == null)
        {
            condition = new Product();
        }
        return condition;
    }

    @Override
    public Map<String, Object> queryPage(String cid, Product condition, Integer currentPage) {
        currentPage-=1;
        condition = getCondition(condition);
        if (!StringUtils.isEmpty(cid))
        {
            condition.setPcategory(Long.parseLong(cid));
        }
        condition.setStart(currentPage*condition.getAmount());

        List<Product> list = productMapper.queryProduct(condition);

        Page page = getPage(condition, currentPage, cid);

        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("page",page);
        return map;
    }

    @Override
    public ProdDetail queryProdDetail2Page(Long pid) {
        ProdDetail condition = new ProdDetail();
        condition.setPid(pid);

        ProdDetail detail = prodDetailMapper.queryProdDetail(condition);

        Product product = new Product();
        product.setPid(pid);
        Product prod = productMapper.queryProductById(product);
        detail.setTitle(prod.getPname());
        detail.setPrice(prod.getPrice());
        detail.setMarketPrice(prod.getMarketPrice());

        Brand brand = new Brand();
        brand.setbId(prod.getPbrand());
        String name = brandMapper.queryBrand(brand).getbName();
        detail.setBrand(name);
        detail.setTalkNum(prod.getTalkNum());

        return detail;

    }

    @Override
    public Map<String, Object> queryByCondition(SearchCondition cond) {
        // 查询分页信息

        Page page = getPage(cond);
        List<Product> list = getProducts(cond);

        // 查询页面数据
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("page",page);

        return map;
    }

    private List<Product> getProducts(SearchCondition cond) {
        Product product = getProduct(cond);
        product.setStart((cond.getCurrentPage()-1)*cond.getPageCount());
//        product.setAmount(cond.getPageCount());默认每页显示4条
        return productMapper.queryProductByCondition(product);
    }

    private Page getPage(SearchCondition cond) {
        Product product = getProduct(cond);
        List<Product> list = productMapper.queryProduct(product);
        Page page = new Page();
        page.setPageCount(cond.getPageCount());
        page.setTotalCount(list.size());
        page.setCurentPage(cond.getCurrentPage());
        page.setTotalPage();
        return page;
    }

    /**
     * 获取不包括分页信息的查询条件
     * @param cond 查询条件
     * @return
     */
    private Product getProduct(SearchCondition cond) {

        Product product = new Product();
        product.setPcategory(cond.getCategory());
        product.setPbrands(cond.getBrand());
        product.setPname(cond.getName());
        product.setPrices(cond.getPrice());
        return product;
    }

    private Page getPage(Product condition, Integer currentPage,
                         String cid) {
        List<Product> list = searchProdsByCid(cid);
        Page page = new Page();
        page.setPageCount(condition.getAmount());
        page.setTotalCount(list.size());
        page.setCurentPage(currentPage+1);
        page.setTotalPage();
        return page;
    }
}
