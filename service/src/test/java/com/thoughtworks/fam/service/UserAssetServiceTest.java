package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.UserAssetDAO;
import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserAssetServiceTest {

    private UserAssetService userAssetService;

    private UserAssetDAO userAssetDAO;

    private List<UserAssetDTO> userAssetDTOs;

    private String userId;


    @Before
    public void setUp() throws Exception {
        userAssetService = new UserAssetService();

        userAssetDAO = mock(UserAssetDAO.class);
        ReflectionTestUtils.setField(userAssetService, "userAssetDAO", userAssetDAO);

        userId = "sqlin@thoughtworks.com";
        userAssetDTOs = new LinkedList<UserAssetDTO>();

        UserAssetDTO userAsset1 = new UserAssetDTO();
        userAsset1.setAssetName("Mac Book 15 inch");
        userAsset1.setAssetNumber("201400356");
        userAsset1.setAssetType("MAC");
        userAsset1.setOwnerName("Waterstrong");
        userAssetDTOs.add(userAsset1);

        UserAssetDTO userAsset2 = new UserAssetDTO();
        userAsset2.setAssetName("Mac Mini 2nd");
        userAsset2.setAssetNumber("201500423");
        userAsset2.setAssetType("MAC_MINI");
        userAsset2.setOwnerName("Waterstrong");
        userAssetDTOs.add(userAsset2);

    }

    @Test
    public void should_invoke_user_asset_dao_method_at_least_once() throws Exception {
        userAssetService.getUserAssets(userId);
        verify(userAssetDAO, times(1)).getUserAssets(userId);
    }

    @Test
    public void should_get_user_assets_when_given_user_id() throws Exception {
        when(userAssetDAO.getUserAssets(userId)).thenReturn(userAssetDTOs);
        List<UserAssetDTO> userAssets = userAssetService.getUserAssets(userId);

        assertThat(userAssets.size(), is(2));
        assertThat(userAssets.get(0).getAssetName(), is("Mac Book 15 inch"));
        assertThat(userAssets.get(0).getAssetNumber(), is("201400356"));
        assertThat(userAssets.get(0).getAssetType(), is("MAC"));
        assertThat(userAssets.get(0).getOwnerName(), is("Waterstrong"));

        assertThat(userAssets.get(1).getAssetName(), is("Mac Mini 2nd"));
        assertThat(userAssets.get(1).getAssetNumber(), is("201500423"));
        assertThat(userAssets.get(1).getAssetType(), is("MAC_MINI"));
        assertThat(userAssets.get(1).getOwnerName(), is("Waterstrong"));
    }
}