package com.thoughtworks.fam.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.ConflictException;

public class AssetServiceTest
{

    private AssetService assetService;

    @Before
    public void setUp() throws Exception
    {
        assetService = new AssetService();
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
}