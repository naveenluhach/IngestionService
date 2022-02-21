package com.example.FeedbackService.Services;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Request.FeedbackRequest;
import org.springframework.stereotype.Service;

@Service
public class EgressService {

    public Feedback fetchFeedback(FeedbackRequest feedbackRequest) {
        //on the basis of request
        //get the data and create it
        Feedback feedback = new Feedback();
        return feedback;
    }
}
