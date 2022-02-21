package com.example.FeedbackService.Services;

import com.example.FeedbackService.Request.FeedbackRequest;
import com.example.FeedbackService.Response.IngestionServiceResponse;
import com.example.FeedbackService.Strategy.Strategy;
import com.example.FeedbackService.Strategy.StrategyFactory;
import com.example.FeedbackService.Strategy.StrategyName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngestionService.class);

    @Autowired
    private StrategyFactory strategyFactory;

    public IngestionServiceResponse startIngestion(FeedbackRequest feedbackRequest) throws Exception {
            //on the basis of feedbackRequest
            //fetch the data
            //and store it in table
             String sourceName = feedbackRequest.getSourceName();
             Strategy strategy = strategyFactory.findStrategy(sourceName);
             strategy.callClient();
             //go to mysql table and find the last ingestion id
             IngestionServiceResponse ingestionServiceResponse = new IngestionServiceResponse();
             ingestionServiceResponse.setIngestionID(1);
             ingestionServiceResponse.setStatus("processing");
             return ingestionServiceResponse;
        }
}
