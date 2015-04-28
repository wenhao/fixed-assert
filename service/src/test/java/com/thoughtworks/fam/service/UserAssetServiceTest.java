package com.thoughtworks.fam.service;

import com.thoughtworks.fam.web.dto.UserAssetDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserAssetServiceTest {

    private UserAssetService userAssetService;


    @Before
    public void setUp() throws Exception {
        userAssetService = new UserAssetService();
    }

    @Test
    public void should_get_user_assets_when_given_user_id() throws Exception {

        List<UserAssetDTO> userAssets = userAssetService.getUserAssets("123");

        assertThat(userAssets.size(), is(1));
        assertThat(userAssets.get(0).getAssetName(), is("Mac Book 15 inch"));
        assertThat(userAssets.get(0).getAssetNumber(), is("201400356"));
        assertThat(userAssets.get(0).getAssetType(), is("MAC"));
        assertThat(userAssets.get(0).getOwnerName(), is("Waterstrong"));

    }

    @Test (expected = RuntimeException.class)
    public void shoud_get_runtime_exception() throws Exception {
        List<UserAssetDTO> userAssets = userAssetService.getUserAssets("");
    }
}