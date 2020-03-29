package com.health.model;

public class Page {
    private Integer totalCount;
    private Integer totalPage;
    private Integer curentPage;
    private Integer pageCount;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalPage() {
        this.totalPage =
                (this.totalCount + (this.pageCount - 1)) / this.pageCount;
    }

    public Integer getCurentPage() {
        return curentPage;
    }

    public void setCurentPage(Integer curentPage) {
        this.curentPage = curentPage;
    }
}
