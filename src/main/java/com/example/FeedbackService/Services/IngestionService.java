package com.example.FeedbackService.Services;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Repository.FeedbackRepository;
import com.example.FeedbackService.Request.FeedbackRequest;
import com.example.FeedbackService.Response.IngestionServiceResponse;
import com.example.FeedbackService.Strategy.Strategy;
import com.example.FeedbackService.Strategy.StrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngestionService.class);

    @Autowired
    private StrategyFactory strategyFactory;

    @Autowired
    private FeedbackRepository feedbackRepository;

    public IngestionServiceResponse startIngestion(FeedbackRequest feedbackRequest) throws Exception {
             String sourceName = feedbackRequest.getSourcename();
             Strategy strategy = strategyFactory.findStrategy(sourceName);
             List<Feedback> feedbackList = strategy.callClient(feedbackRequest);
             persistFeedback(feedbackList);
             //go to mysql table and find the last ingestion id
             IngestionServiceResponse ingestionServiceResponse = new IngestionServiceResponse();
             ingestionServiceResponse.setIngestionID(1);
             ingestionServiceResponse.setStatus("processing");
             return ingestionServiceResponse;
        }

        private int persistFeedback(List<Feedback> feedbackList){
           for(Feedback feedback : feedbackList){
               try {
                   feedbackRepository.save(feedback);
               }catch (Exception ex){
                   LOGGER.error("Exception occured while saving a feedback :{} and error: {}", feedback, ex);
               }
           }
           return 1;
        }
}
