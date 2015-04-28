package com.thoughtworks.fam.web;


import com.thoughtworks.fam.service.UserAssetService;
import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user/assets")
public class UserAssetController {

    private UserAssetService userAssetService;

    public UserAssetController() {
        userAssetService = new UserAssetService();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<UserAssetDTO> getAssets(String userId)
    {
        return userAssetService.getUserAssets(userId);
    }
}
