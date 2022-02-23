package com.example.FeedbackService.Services.ThirdPartyServices;

import com.example.FeedbackService.Model.ThirdPartyModels.Tweets;
import com.example.FeedbackService.Model.ThirdPartyModels.TwitterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TwitterDataServices {

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
            System.out.println(exception);
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
            System.out.println(exception);
            return null;
        }
    }
}
