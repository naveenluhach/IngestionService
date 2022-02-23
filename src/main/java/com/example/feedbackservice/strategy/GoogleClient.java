package com.example.feedbackservice.strategy;

import com.example.feedbackservice.model.Feedback;
import com.example.feedbackservice.request.FeedbackRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class GoogleClient implements Strategy{
    @Override
    public List<Feedback> callClient(FeedbackRequest feedbackRequest) {
        //implement algorithm A here
        return new ArrayList<>();
    }

    @Override
    public String getStrategyName() {
        return "google";
    }

}
