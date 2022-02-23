package com.example.FeedbackService.Request;

import javax.validation.constraints.NotBlank;

public class FeedbackRequest {

    @NotBlank(message = "sourcename is a mandatory field")
    String sourcename;

    @NotBlank(message = "tenantname is a mandatory field")
    String tenantname;
    int appid;


    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename;
    }

    public String getTenantname() {
        return tenantname;
    }

    public void setTenantname(String tenantname) {
        this.tenantname = tenantname;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    @Override
    public String toString() {
        return "FeedbackRequest{" +
                "sourcename='" + sourcename + '\'' +
                ", tenantname='" + tenantname + '\'' +
                ", appid=" + appid +
                '}';
    }
}

