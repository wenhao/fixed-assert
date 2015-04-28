package com.thoughtworks.fam.web;

import com.thoughtworks.fam.service.AssetsService;
import com.thoughtworks.fam.web.dto.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/user/assets")
public class AssetsController {
    @Autowired
    private AssetsService assetsService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Asset> getAssets(/*param : who's assets*/) {
        return assetsService.getAllAssets();
    }
}
