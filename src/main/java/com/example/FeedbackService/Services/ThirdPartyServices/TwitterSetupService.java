package com.example.FeedbackService.Services.ThirdPartyServices;

import com.example.FeedbackService.Model.ThirdPartyModels.TwitterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TwitterSetupService {

    @Autowired
    private RestTemplate restTemplate;

    //REST call to another endpoint // network call
    public TwitterUser findUserIDByusername(String username){

        String url = "https://api.twitter.com/2/users/by/username/{username}";
        Map<String, String> params= new HashMap<>();
        params.put("username", username);
        try {
            ResponseEntity<TwitterUser> responseEntity = restTemplate.getForEntity(url, TwitterUser.class, params);
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
