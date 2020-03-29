package com.health.model;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class Product extends QueryModel{
    private Long pid;
    private Long pcategory;
    private Integer pbrand;
    private String pname;
    private Long pcount;
    private Long price;
    private Integer marketPrice;
    private String pstatus;
    private String detail;
    private String img;
    private Integer sales;
    private Integer talkNum = 0;
    private String[] prices;
    private String[] pbrands;

    public String[] getPrices() {
        return prices;
    }

    public void setPrices(String[] prices) {
        this.prices = prices;
    }

    public String[] getPbrands() {
        return pbrands;
    }

    public void setPbrands(String[] pbrands) {
        this.pbrands = pbrands;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getTalkNum() {
        return talkNum;
    }

    public void setTalkNum(Integer talkNum) {
        this.talkNum = talkNum;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPcategory() {
        return pcategory;
    }

    public void setPcategory(Long pcategory) {
        this.pcategory = pcategory;
    }

    public Integer getPbrand() {
        return pbrand;
    }

    public void setPbrand(Integer pbrand) {
        this.pbrand = pbrand;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getPcount() {
        return pcount;
    }

    public void setPcount(Long pcount) {
        this.pcount = pcount;
    }


    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
