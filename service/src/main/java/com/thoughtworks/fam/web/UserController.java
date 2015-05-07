package com.thoughtworks.fam.web;

import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zy on 2015/5/7.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody
    UserDTO create(@RequestBody UserDTO userDTO) {
        return userDTO;
    }
}
