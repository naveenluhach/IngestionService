package com.example.FeedbackService.Strategy;

import org.springframework.stereotype.Component;

@Component
public class DiscourseClient implements Strategy{
    @Override
    public void callClient() {
        //implement algorithm A here
    }

    @Override
    public String getStrategyName() {
        return "DISCOURSE";
    }

}
