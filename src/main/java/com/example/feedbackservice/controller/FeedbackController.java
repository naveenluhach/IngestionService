package com.example.feedbackservice.controller;

import com.example.feedbackservice.model.Feedback;
import com.example.feedbackservice.request.FeedbackRequest;
import com.example.feedbackservice.response.IngestionServiceResponse;
import com.example.feedbackservice.services.EgressService;
import com.example.feedbackservice.services.IngestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    IngestionService ingestionService;

    @Autowired
    EgressService egressService;

    @PostMapping("/triggerIngestion")
    public IngestionServiceResponse triggerIngestion(@RequestBody FeedbackRequest feedbackRequest) throws Exception{
        LOGGER.info("Request received for triggerIngestion, FeedbackRequest object : {}", feedbackRequest);
        IngestionServiceResponse ingestionServiceResponse = ingestionService.startIngestion(feedbackRequest);
        LOGGER.info("Response for triggerIngestion, IngestionServiceResponse object : {}", ingestionServiceResponse);
        return ingestionServiceResponse;

    }

    @GetMapping("/getFeedback")
    public Feedback getFeedback(@RequestBody FeedbackRequest feedbackRequest) throws Exception{
        LOGGER.info("Request received for getFeedback, FeedbackRequest object : {}", feedbackRequest);
        Feedback feedback = egressService.fetchFeedback(feedbackRequest);
        LOGGER.info("Response for getFeedback, Feedback object : {}", feedback);
        return feedback;
    }

}
