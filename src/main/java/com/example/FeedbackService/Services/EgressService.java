package com.example.FeedbackService.Services;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Model.Sources;
import com.example.FeedbackService.Model.Tenant;
import com.example.FeedbackService.Repository.FeedbackRepository;
import com.example.FeedbackService.Repository.SourceRepository;
import com.example.FeedbackService.Repository.TenantRepository;
import com.example.FeedbackService.Request.FeedbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EgressService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    TenantRepository tenantRepository;

    public Feedback fetchFeedback(FeedbackRequest feedbackRequest) {
        Sources sources = sourceRepository.findByname(feedbackRequest.getSourcename());
        int sourceID = sources.getId();
        Tenant tenant = tenantRepository.findByname(feedbackRequest.getTenantname());
        return feedbackRepository.getFeedbackbySourceIDAndTenantID(sourceID, tenant.getId());
    }
}
