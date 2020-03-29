package com.health.model;

public class Message {
    private boolean isSuccess = true;
    private Object messg;
    private String errorInfo;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getMessg() {
        return messg;
    }

    public void setMessg(Object messg) {
        this.messg = messg;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
