package com.thoughtworks.fam.web;


import com.google.common.base.Strings;
import com.thoughtworks.fam.service.UserAssetService;
import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAssetController {

    @Autowired
    private UserAssetService userAssetService;

//    @Autowired
//    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/asset/{user_id}/list")
    public List<UserAssetDTO> getUserAssets(@PathVariable("user_id") String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new RuntimeException("user id is null or empty");
        }
        return userAssetService.getUserAssets(userId);
    }

/*
    @RequestMapping(method = RequestMethod.GET, value = "/asset/{userName}/myassets")
    public List<AssetDTO> getUserAndAssets(@PathVariable("userName") String userName) {
        if (Strings.isNullOrEmpty(userName)) {
            throw new RuntimeException("user id is null or empty");
        }
        User user = userRepository.findUserByName(userName);
        Assert.notNull(user, "No such user");
        return user.getAssetDTOs();
    }
*/
}
