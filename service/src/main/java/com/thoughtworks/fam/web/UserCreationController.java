package com.thoughtworks.fam.web;

import com.thoughtworks.fam.web.dto.UserCreationMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class UserCreationController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserCreationMessage createAnUser(String username) {
        if (username == null || username.equals("")) {
            return new UserCreationMessage("failed", "Please enter an username");
        }

        if (username.equals("hello")) {
            return new UserCreationMessage("failed", "Invalid username in ThoughtWorks system.");
        } else {
            return new UserCreationMessage("success", "User has been succesfully created.");
        }
    }
}
