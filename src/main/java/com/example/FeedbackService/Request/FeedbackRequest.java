package com.example.FeedbackService.Request;

import com.example.FeedbackService.Strategy.StrategyName;

import javax.validation.constraints.NotBlank;

public class FeedbackRequest {

    String sourceName;

    @NotBlank(message = "The tenantID is required.")
    int tenantID;
    int appID;


    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getAppID() {
        return appID;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    @Override
    public String toString() {
        return "FeedbackRequest{" +
                "sourceName='" + sourceName + '\'' +
                ", tenantID=" + tenantID +
                ", appID=" + appID +
                '}';
    }
}

