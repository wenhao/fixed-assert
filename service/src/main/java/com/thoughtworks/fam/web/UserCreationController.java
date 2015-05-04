package com.thoughtworks.fam.web;

import com.thoughtworks.fam.service.UserCreationService;
import com.thoughtworks.fam.service.UserCreationServiceImpl;
import com.thoughtworks.fam.web.dto.UserCreationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class UserCreationController {

    @Autowired
    private UserCreationServiceImpl userCreationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserCreationMessage createAnUser(String username) {
        if (username == null || username.equals("")) {
            return new UserCreationMessage("failed", "Please enter an username");
        }

        if (username.equals("hello")) {
            return new UserCreationMessage("failed", "Invalid username in ThoughtWorks system.");
        }

        return new UserCreationMessage("success", "User has been succesfully created.");
    }
}
