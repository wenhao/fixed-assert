package com.thoughtworks.fam.dao;


import com.thoughtworks.fam.web.dto.UserAssetDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserAssetDAO {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public List<UserAssetDTO> getUserAssets(String userId) {

        // TODO: mock some data

        List<UserAssetDTO> userAssetDTOs = new ArrayList<>();
        UserAssetDTO userAssetDTO = new UserAssetDTO();
        userAssetDTO.setAssetName("Mac Book 15 inch");
        userAssetDTO.setAssetNumber("201400356");
        userAssetDTO.setAssetType("MAC");
        userAssetDTO.setOwnerName("Waterstrong");
        try {
            userAssetDTO.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userAssetDTOs.add(userAssetDTO);
        return userAssetDTOs;
    }
}
