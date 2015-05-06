package com.thoughtworks.fam.web;

import com.thoughtworks.fam.service.AuthService;
import com.google.common.base.Strings;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public UserDTO login(@RequestBody UserDTO user) {
        // TODO: use annotation to check userDTO data valid
        if(Strings.isNullOrEmpty(user.getName())||Strings.isNullOrEmpty(user.getPassword())) {
            throw new AuthException(ErrorCode.LOST_NECESSARY_AUTH_INFO,"lost user name or password");
        }

        return authService.login(user);
    }
}
