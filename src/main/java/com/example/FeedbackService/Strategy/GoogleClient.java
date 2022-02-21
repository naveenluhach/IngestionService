package com.example.FeedbackService.Strategy;

import org.springframework.stereotype.Component;


@Component
public class GoogleClient implements Strategy{
    @Override
    public void callClient() {
        //implement algorithm A here
    }

    @Override
    public String getStrategyName() {
        return "GOOGLE";
    }

}
