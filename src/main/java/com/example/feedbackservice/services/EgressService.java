package com.example.feedbackservice.services;

import com.example.feedbackservice.model.Feedback;
import com.example.feedbackservice.model.Sources;
import com.example.feedbackservice.model.Tenant;
import com.example.feedbackservice.repository.FeedbackRepository;
import com.example.feedbackservice.repository.SourceRepository;
import com.example.feedbackservice.repository.TenantRepository;
import com.example.feedbackservice.request.FeedbackRequest;
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
