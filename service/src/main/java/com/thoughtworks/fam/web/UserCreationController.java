package com.thoughtworks.fam.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class UserCreationController {

    @RequestMapping(method = RequestMethod.POST)
    public String createAnUser(String username) {
        if (username == null || username.equals("")) {
            return "Please enter an username";
        }

        return "Invalid username in ThoughtWorks system.";
    }
}
