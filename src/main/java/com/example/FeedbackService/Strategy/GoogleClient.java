package com.example.FeedbackService.Strategy;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Request.FeedbackRequest;
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
