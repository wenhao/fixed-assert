package com.thoughtworks.fam.service;


import com.thoughtworks.fam.dao.UserAssetDAO;
import com.thoughtworks.fam.web.dto.UserAssetDTO;

import java.util.List;

public class UserAssetService {

    private UserAssetDAO userAssetDAO;

    public UserAssetService() {
        userAssetDAO = new UserAssetDAO();
    }

    public List<UserAssetDTO> getUserAssets(String userId) {

        // TODO: check if there is a user in db
        List<UserAssetDTO> userAssets = userAssetDAO.getUserAssets(userId);

        return userAssets;
    }
}
