package com.thoughtworks.fam.service;


import com.thoughtworks.fam.dao.UserAssetDAO;
import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.assertj.core.util.Strings;

import java.util.List;

public class UserAssetService {

    private UserAssetDAO userAssetDAO;

    public UserAssetService() {
        userAssetDAO = new UserAssetDAO();
    }

    public List<UserAssetDTO> getUserAssets(String userId) {

        if (Strings.isNullOrEmpty(userId)) {
            throw new RuntimeException("user id is null");
        }

        // TODO: check if there is a user in db

        List<UserAssetDTO> userAssets = userAssetDAO.getUserAssets(userId);

        return userAssets;
    }
}
