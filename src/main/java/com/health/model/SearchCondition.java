package com.health.model;

import org.springframework.util.StringUtils;

public class SearchCondition {
    private String name;
    private Integer currentPage = 1;
    private String price;
    private String brand;
    private String guige;
    private Long category;
    private Integer pageCount = 4;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer page) {
        this.currentPage = page;
    }

    public String[] getPrice() {
        return StringUtils.isEmpty(price) ? null : price.split(",");
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String[] getBrand() {
        return StringUtils.isEmpty(brand) ? null : brand.split(",");
    }

    public String getBrand(boolean b) {
        return StringUtils.isEmpty(brand) ? null : brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getPrice(boolean b) {
        return this.price;
    }
}
