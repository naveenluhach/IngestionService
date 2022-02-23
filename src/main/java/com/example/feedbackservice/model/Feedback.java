package com.example.feedbackservice.model;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String type;
    int sourceid;
    int tenantid;
    String content;
    String language;
    int metadataid;
    String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMetadataid() {
        return metadataid;
    }

    public void setMetadataid(int metadataid) {
        this.metadataid = metadataid;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", type=" + type +
                ", sourceid=" + sourceid +
                ", tenantid=" + tenantid +
                ", contentid='" + content + '\'' +
                ", Language='" + language + '\'' +
                ", metadata=" + metadataid +
                '}';
    }
}
