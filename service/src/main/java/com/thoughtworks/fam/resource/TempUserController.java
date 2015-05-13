package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.resource.domain.TempAsset;
import com.thoughtworks.fam.resource.domain.User;
import com.thoughtworks.fam.service.TempUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class TempUserController {
    @Autowired
    private TempUserService userService;

    @RequestMapping(value = "/uid/assets", method = RequestMethod.GET)
    public ResponseEntity<List<TempAsset>> getUserAssets() throws ParseException {
        List<TempAsset> assets = userService.getAssets();
        return new ResponseEntity<List<TempAsset>>(assets, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        if(!userService.createUser(user)){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

