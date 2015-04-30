package com.thoughtworks.fam.dao;


import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class UserAssetDAO {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public List<UserAssetDTO> getUserAssets(String userId) {

        // TODO: mock some data

        List<UserAssetDTO> userAssetDTOs = new ArrayList<UserAssetDTO>();

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

        UserAssetDTO userAsset3 = new UserAssetDTO();
        userAsset3.setAssetName("Dac Mini 2nd");
        userAsset3.setAssetNumber("201500423");
        userAsset3.setAssetType("MAC_MINI");
        userAsset3.setOwnerName("Waterstrong");
        try {
            userAsset3.setAssignDate(format.parse("2015-3-23"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset3);

        UserAssetDTO userAsset4 = new UserAssetDTO();
        userAsset4.setAssetName("Aac Mini 2nd");
        userAsset4.setAssetNumber("201500423");
        userAsset4.setAssetType("MAC_MINI");
        userAsset4.setOwnerName("Waterstrong");
        try {
            userAsset4.setAssignDate(format.parse("2015-3-23"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset4);

        UserAssetDTO userAsset5 = new UserAssetDTO();
        userAsset5.setAssetName("Zac Mini 2nd");
        userAsset5.setAssetNumber("201500423");
        userAsset5.setAssetType("MAC_MINI");
        userAsset5.setOwnerName("Waterstrong");
        try {
            userAsset5.setAssignDate(format.parse("2015-3-23"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset5);

        UserAssetDTO userAsset6 = new UserAssetDTO();
        userAsset6.setAssetName("Qac Mini 2nd");
        userAsset6.setAssetNumber("201500423");
        userAsset6.setAssetType("MAC_MINI");
        userAsset6.setOwnerName("Waterstrong");
        try {
            userAsset6.setAssignDate(format.parse("2015-3-23"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset6);


        UserAssetDTO userAsset7 = new UserAssetDTO();
        userAsset7.setAssetName("Uac Book 15 inch");
        userAsset7.setAssetNumber("201400356");
        userAsset7.setAssetType("MAC");
        userAsset7.setOwnerName("Waterstrong");
        try {
            userAsset7.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset7);

        UserAssetDTO userAsset8 = new UserAssetDTO();
        userAsset8.setAssetName("Xac Book 15 inch");
        userAsset8.setAssetNumber("201400356");
        userAsset8.setAssetType("MAC");
        userAsset8.setOwnerName("Waterstrong");
        try {
            userAsset8.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset8);

        UserAssetDTO userAsset9 = new UserAssetDTO();
        userAsset9.setAssetName("Maa Book 15 inch");
        userAsset9.setAssetNumber("201400356");
        userAsset9.setAssetType("MAC");
        userAsset9.setOwnerName("Waterstrong");
        try {
            userAsset9.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset9);

        UserAssetDTO userAsset10 = new UserAssetDTO();
        userAsset10.setAssetName("Fac Book 15 inch");
        userAsset10.setAssetNumber("201400356");
        userAsset10.setAssetType("MAC");
        userAsset10.setOwnerName("Waterstrong");
        try {
            userAsset10.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset10);


        UserAssetDTO userAsset11 = new UserAssetDTO();
        userAsset11.setAssetName("Mpc Book 15 inch");
        userAsset11.setAssetNumber("201400356");
        userAsset11.setAssetType("MAC");
        userAsset11.setOwnerName("Waterstrong");
        try {
            userAsset11.setAssignDate(format.parse("2015-4-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userAssetDTOs.add(userAsset11);


        // TODO: the sort is from the database
        Collections.sort(userAssetDTOs, new Comparator<UserAssetDTO>() {
            @Override
            public int compare(UserAssetDTO o1, UserAssetDTO o2) {
                return o1.getAssetName().compareTo(o2.getAssetName());
            }
        });

        return userAssetDTOs;
    }
}
