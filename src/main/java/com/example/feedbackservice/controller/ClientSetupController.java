package com.example.feedbackservice.controller;

import com.example.feedbackservice.model.thirdpartymodels.TwitterUser;
import com.example.feedbackservice.services.thirdpartyservices.TwitterSetupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setup")
public class ClientSetupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSetupController.class);

    @Autowired
    private TwitterSetupService twitterSetupService;

    @GetMapping("/getUserID/{username}")
    public Integer getUserID(@PathVariable String username) throws Exception{
        LOGGER.info("Request received in getUserID : {}", username);
        TwitterUser twitterUser = twitterSetupService.findUserIDByusername(username);
        LOGGER.info("Response sent by getUserID : {}", twitterUser.getId());
        return twitterUser.getId();
    }
}
