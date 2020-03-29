package com.health.model;

import lombok.Data;

@Data
public class ProdDetail extends QueryModel{
    private Long pid;
    private String bigImg;
    private String smallIMG;
    private String title;
    private Long price;
    private Integer marketPrice;
    private Long platformPrice;
    private Integer grade;
    private Integer baoyou;
    private Integer talkNum;
    private String brand;
    private String changdi;
    private String level;
    private Integer baozhiqi;
    private String code;
    private String guige;
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }

    public String getSmallIMG() {
        return smallIMG;
    }

    public void setSmallIMG(String smallIMG) {
        this.smallIMG = smallIMG;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getPlatformPrice() {
        return platformPrice;
    }

    public void setPlatformPrice(Long platformPrice) {
        this.platformPrice = platformPrice;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getBaoyou() {
        return baoyou;
    }

    public void setBaoyou(Integer baoyou) {
        this.baoyou = baoyou;
    }

    public Integer getTalkNum() {
        return talkNum;
    }

    public void setTalkNum(Integer talkNum) {
        this.talkNum = talkNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getChangdi() {
        return changdi;
    }

    public void setChangdi(String changdi) {
        this.changdi = changdi;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getBaozhiqi() {
        return baozhiqi;
    }

    public void setBaozhiqi(Integer baozhiqi) {
        this.baozhiqi = baozhiqi;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }
}
