package com.thoughtworks.fam.resource;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.service.LoginService;

@RestController
@RequestMapping(value = "/auth")
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) throws ParseException
    {
        User userFromDB = loginService.login(user.getAccount(), user.getPassword());
        return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    }


}
