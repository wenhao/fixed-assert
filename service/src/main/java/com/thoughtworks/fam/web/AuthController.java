package com.thoughtworks.fam.web;

import com.thoughtworks.fam.service.AuthService;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    @ResponseBody
    public UserDTO login(@RequestBody UserDTO userDTO) {
        // TODO: use annotation to check userDTO data valid
        return authService.login(userDTO);
    }

}
