package com.jekss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jekss on 28.10.15.
 */
@Controller
@RequestMapping("/userprofile")
public class UserProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String userProfilePage(){
        return "userprofile";
    }
}
