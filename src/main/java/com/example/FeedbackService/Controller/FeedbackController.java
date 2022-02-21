package com.example.FeedbackService.Controller;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Request.FeedbackRequest;
import com.example.FeedbackService.Response.FeedbackResponse;
import com.example.FeedbackService.Response.IngestionServiceResponse;
import com.example.FeedbackService.Services.EgressService;
import com.example.FeedbackService.Services.IngestionService;
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
        //call to IngestionService common one
        LOGGER.info("Request received for triggerIngestion, FeedbackRequest object : {}", feedbackRequest);
        IngestionServiceResponse ingestionServiceResponse = ingestionService.startIngestion(feedbackRequest);
        LOGGER.info("Response for triggerIngestion, IngestionServiceResponse object : {}", ingestionServiceResponse);
        return ingestionServiceResponse;

    }

    @GetMapping("/getFeedback")
    public Feedback getFeedback(@RequestBody FeedbackRequest feedbackRequest) throws Exception{
                   Feedback feedback = egressService.fetchFeedback(feedbackRequest);
                   return feedback;
    }

}
