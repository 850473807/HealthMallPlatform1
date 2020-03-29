package com.health.model;

import lombok.Data;

@Data
public class Brand {
    private Integer bId;
    private String bName;
    private String bIds;

    public String getbIds() {
        return bIds;
    }

    public void setbIds(String bIds) {
        this.bIds = bIds;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}
