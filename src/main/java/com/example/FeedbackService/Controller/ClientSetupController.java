package com.example.FeedbackService.Controller;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Model.ThirdPartyModels.TwitterUser;
import com.example.FeedbackService.Request.FeedbackRequest;
import com.example.FeedbackService.Services.ThirdPartyServices.TwitterSetupService;
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
    public Integer getBalance(@PathVariable String username) throws Exception{
        TwitterUser twitterUser = twitterSetupService.findUserIDByusername(username);
        return twitterUser.getId();
    }
}
