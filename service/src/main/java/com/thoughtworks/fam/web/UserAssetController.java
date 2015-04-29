package com.thoughtworks.fam.web;


import com.thoughtworks.fam.service.UserAssetService;
import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserAssetController {

    @Autowired
    private UserAssetService userAssetService;

    @RequestMapping(method = RequestMethod.GET, value = "/user/{user_id}/assets")
    public List<UserAssetDTO> getAssets(@PathVariable("user_id") String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new RuntimeException("user id is null or empty");
        }
        return userAssetService.getUserAssets(userId);
    }
}
