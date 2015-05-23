package com.thoughtworks.fam.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.common.collect.Lists;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.ConflictException;

public class AssetServiceTest
{

    @Mock
    private AssetRepository assetRepository;

    private AssetService assetService;

    @Before
    public void setUp() throws Exception
    {
        assetService = new AssetService(assetRepository);
    }

    @Test
    public void should_create_asset() throws Exception
    {
        int beforeCreateAmount = AssetService.getAssets().size();

        Asset asset = new Asset("twer", "11111111", "123321",
                "Apple Laptop", new Date().toString());
        assetService.createAsset(asset);

        assertThat(AssetService.getAssets().size()).isEqualTo(beforeCreateAmount + 1);
        assertThat(AssetService.getAssets().contains(asset)).isTrue();
    }

    @Test(expected = ConflictException.class)
    public void should_throw_conflict_exception_when_asset_name_existed() {
        Asset asset = new Asset("twer", "12345678", "123321",
                "Apple Laptop", new Date().toString());
        assetService.createAsset(asset);
    }

    @Test
    public void should_get_assets_given_valid_user_id()
    {
        //given
        long uid = 1L;

        //when
        List<Asset> assets = assetService.getUserAssets(uid);

        //then
        assertThat(assets.size()).isGreaterThan(0);
        assertThat(assets.get(0).getAssetNumber()).isEqualTo("123456");
        assertThat(assets.get(0).getAssetType()).isEqualTo("Laptop");
    }

    @Test
    public void should_get_others_assets() throws Exception
    {
        List<Asset> othersAssets = assetService.getOthersAssets();

        assertThat(othersAssets.size()).isGreaterThan(0);
        assertThat(othersAssets.get(0).getAssetNumber()).isEqualTo("123456");
        assertThat(othersAssets.get(0).getAssetType()).isEqualTo("Laptop");
    }
}