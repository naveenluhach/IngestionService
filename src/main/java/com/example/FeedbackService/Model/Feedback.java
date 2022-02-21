package com.example.FeedbackService.Model;

public class Feedback {

    int id;
    int type;
    int sourceid;
    int tenantid;
    String contentid;
    String Language;
    int metadata;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSourceid() {
        return sourceid;
    }

    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    public int getTenantid() {
        return tenantid;
    }

    public void setTenantid(int tenantid) {
        this.tenantid = tenantid;
    }

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getMetadata() {
        return metadata;
    }

    public void setMetadata(int metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", type=" + type +
                ", sourceid=" + sourceid +
                ", tenantid=" + tenantid +
                ", contentid='" + contentid + '\'' +
                ", Language='" + Language + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
