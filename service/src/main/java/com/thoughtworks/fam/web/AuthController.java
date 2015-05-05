package com.thoughtworks.fam.web;

import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public @ResponseBody UserDTO login(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

}
