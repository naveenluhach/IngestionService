package com.example.FeedbackService.Strategy;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Request.FeedbackRequest;

import java.util.List;

public interface Strategy {

    List<Feedback> callClient(FeedbackRequest feedbackRequest);

    String getStrategyName();
}
