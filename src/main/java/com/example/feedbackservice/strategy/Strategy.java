package com.example.feedbackservice.strategy;

import com.example.feedbackservice.model.Feedback;
import com.example.feedbackservice.request.FeedbackRequest;

import java.util.List;

public interface Strategy {

    List<Feedback> callClient(FeedbackRequest feedbackRequest);

    String getStrategyName();
}
