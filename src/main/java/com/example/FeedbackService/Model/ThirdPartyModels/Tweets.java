package com.example.FeedbackService.Model.ThirdPartyModels;

import java.util.List;

public class Tweets {
    List<Tweet> data;
    MetaFields meta;

    public List<Tweet> getData() {
        return data;
    }

    public void setData(List<Tweet> data) {
        this.data = data;
    }

    public MetaFields getMeta() {
        return meta;
    }

    public void setMeta(MetaFields meta) {
        this.meta = meta;
    }
}
