package com.example.feedbackservice.services.thirdpartyservices;

import com.example.feedbackservice.controller.ClientSetupController;
import com.example.feedbackservice.model.thirdpartymodels.Tweets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TwitterDataServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterDataServices.class);

    @Value("${twitter.BearerToken}")
    private String bearerToken;

    @Autowired
    private RestTemplate restTemplate;

    public Tweets getTweets(Integer userid){

        String url = "https://api.twitter.com/2/users/{userid}/tweets";
        Map<String, String> params= new HashMap<>();
        params.put("userid", userid.toString());
        params.put("tweet.fields","lang");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(bearerToken);
            HttpEntity<String> entity = new HttpEntity<>("body", headers);
            ResponseEntity<Tweets> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Tweets.class, params);
            if(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                return null;
            }else{
                return responseEntity.getBody();
            }
        }catch(Exception exception){
            LOGGER.error("Exception occured in getTweets : {}", exception);
            return null;
        }
    }

    public Tweets getMentions(Integer userid){

        String url = "https://api.twitter.com/2/users/{userid}/mentions";
        Map<String, String> params= new HashMap<>();
        params.put("userid", userid.toString());
        params.put("tweet.fields","lang");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(bearerToken);
            HttpEntity<String> entity = new HttpEntity<>("body", headers);
            ResponseEntity<Tweets> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Tweets.class, params);
            if(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                return null;
            }else{
                return responseEntity.getBody();
            }
        }catch(Exception exception){
            LOGGER.error("Exception occured in getMentions : {}", exception);
            return null;
        }
    }
}
