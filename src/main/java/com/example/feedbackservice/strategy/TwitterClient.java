package com.example.feedbackservice.strategy;

import com.example.feedbackservice.model.Feedback;
import com.example.feedbackservice.model.Sources;
import com.example.feedbackservice.model.Tenant;
import com.example.feedbackservice.model.thirdpartymodels.Tweet;
import com.example.feedbackservice.model.thirdpartymodels.Tweets;
import com.example.feedbackservice.model.TwitterMetaData;
import com.example.feedbackservice.repository.FeedbackRepository;
import com.example.feedbackservice.repository.SourceRepository;
import com.example.feedbackservice.repository.TenantRepository;
import com.example.feedbackservice.repository.TwitterMetaDataRepository;
import com.example.feedbackservice.request.FeedbackRequest;
import com.example.feedbackservice.services.thirdpartyservices.TwitterDataServices;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterClient implements Strategy{

        private static final Logger LOGGER = LoggerFactory.getLogger(TwitterClient.class);

        @Autowired
        TwitterDataServices twitterDataServices;

        @Autowired
        FeedbackRepository feedbackRepository;

        @Autowired
        TwitterMetaDataRepository twitterMetaDataRepository;

        @Autowired
        SourceRepository sourceRepository;

        @Autowired
        TenantRepository tenantRepository;

        @Override
        public List<Feedback> callClient(FeedbackRequest feedbackRequest) {
                //userid of myntra to come from db/cache, db once populated, on the basis of
                //feedbackRequest.getTenantID(), why db/cache and not constant because if we onboard zomato too, all we need is db entry/cache warm up, no code deployment
                Tenant tenant = tenantRepository.findByname(feedbackRequest.getTenantname());
                int tenantid = tenant.getId();
                int userid = tenant.getUserid();
                Tweets userMentions = twitterDataServices.getMentions(userid);
                Tweets userTweets = twitterDataServices.getTweets(userid);
                //store them in db
                List<Feedback> feedbackList = new ArrayList<>();
                List<Tweet> tweets = new ArrayList<>();
                tweets.addAll(userMentions.getData());
                tweets.addAll(userTweets.getData());
                try {
                        Sources sources = sourceRepository.findByname(feedbackRequest.getSourcename());
                        int sourceid = sources.getId();
                        for (Tweet tweet : tweets) {
                                TwitterMetaData twitterMetaData = new TwitterMetaData();
                                twitterMetaData.setCountry("India");
                                TwitterMetaData twitterMetaDataResponse = twitterMetaDataRepository.save(twitterMetaData);
                                Feedback feedback = new Feedback();
                                feedback.setType("Feedback");
                                feedback.setSourceid(sourceid);
                                feedback.setTenantid(tenantid);
                                feedback.setContent(tweet.getText());
                                feedback.setLanguage(tweet.getLang());
                                feedback.setMetadataid(twitterMetaDataResponse.getId());
                                //check for duplicacy
                                String feedbackHash = generateHash(feedback.getType()+feedback.getLanguage()+feedback.getSourceid()+feedback.getTenantid()+feedback.getContent());
                                feedback.setHash(feedbackHash);
                                feedbackList.add(feedback);

                        }
                }catch(Exception ex){
                        LOGGER.error("Error occured while saving to db : {}", ex);
                }
                return feedbackList;
        }

        @Override
        public String getStrategyName() {
                return "twitter";
        }


        private String generateHash(String input){
                return Hashing.sha256()
                        .hashString(input, StandardCharsets.UTF_8)
                        .toString();
        }
}
