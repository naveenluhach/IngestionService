package com.example.feedbackservice.response;

public class IngestionServiceResponse {
    int ingestionID;
    String status;

    public int getIngestionID() {
        return ingestionID;
    }

    public void setIngestionID(int ingestionID) {
        this.ingestionID = ingestionID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
