package com.example.feedbackservice.services.thirdpartyservices;

import com.example.feedbackservice.model.thirdpartymodels.TwitterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TwitterSetupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterSetupService.class);

    @Autowired
    private RestTemplate restTemplate;

    //REST call to another endpoint // network call
    public TwitterUser findUserIDByusername(String username) throws Exception{

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
            LOGGER.error("Exception in findUserIDByusername : {}", exception);
            throw new Exception("No data found");
        }
    }
}
