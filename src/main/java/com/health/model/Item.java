package com.health.model;

public class Item {
    private Long pId;
    private String img;
    private String name;
    private Long platformPrice;
    private Long price;
    private Long discount;
    private Integer count;
    private Long sumPrice;
    private Long disRate;

    public Long getDisRate() {
        return disRate;
    }

    public void setDisRate(Long disRate) {
        this.disRate = disRate;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPlatformPrice() {
        return platformPrice;
    }

    public void setPlatformPrice(Long platformPrice) {
        this.platformPrice = platformPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Long sumPrice) {
        this.sumPrice = sumPrice;
    }

    public void setDiscount() {
        this.discount= (this.platformPrice-this.price)*this.count;
    }

    public void setDisRate() {
        this.disRate = price*100/ platformPrice;
    }

    public void setSumPrice() {
        this.sumPrice = this.price*this.count;
    }
}
