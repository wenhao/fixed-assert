package com.thoughtworks.fam.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssetsController
{
    @RequestMapping(value = "/asset", method = RequestMethod.POST)
    public ResponseEntity create()
    {
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
