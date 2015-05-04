package com.thoughtworks.fam.service;


import com.thoughtworks.fam.dao.UserAssetDAO;
import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class UserAssetServiceImpl implements UserAssetService {

    @Autowired
    private UserAssetDAO userAssetDAO;

    @Override
    public List<UserAssetDTO> getUserAssets(String userId) {
        // TODO: check if there is a user in db
        return userAssetDAO.getUserAssets(userId);
    }
}
