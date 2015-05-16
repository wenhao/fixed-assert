package com.thoughtworks.fam.resource;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/uid/assets", method = RequestMethod.GET)
    public ResponseEntity<List<Asset>> getUserAssets() throws ParseException
    {
        List<Asset> assets = userService.getAssets();
        return new ResponseEntity<List<Asset>>(assets, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user)
    {
        if (!userService.createUser(user)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

