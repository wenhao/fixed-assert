package com.thoughtworks.fam.dao;


import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAssetDAO {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public List<UserAssetDTO> getUserAssets(String userId) {

        // TODO: mock some data

        List<UserAssetDTO> userAssetDTOs = new ArrayList<>();
        UserAssetDTO userAsset1 = new UserAssetDTO();
        userAsset1.setAssetName("Mac Book 15 inch");
        userAsset1.setAssetNumber("201400356");
        userAsset1.setAssetType("MAC");
        userAsset1.setOwnerName("Waterstrong");
        try {
            userAsset1.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset1);

        UserAssetDTO userAsset2 = new UserAssetDTO();
        userAsset2.setAssetName("Mac Mini 2nd");
        userAsset2.setAssetNumber("201500423");
        userAsset2.setAssetType("MAC_MINI");
        userAsset2.setOwnerName("Waterstrong");
        try {
            userAsset2.setAssignDate(format.parse("2015-3-28"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset2);

        return userAssetDTOs;
    }
}
