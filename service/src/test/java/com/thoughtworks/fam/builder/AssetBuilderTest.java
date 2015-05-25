package com.thoughtworks.fam.builder;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.fam.domain.Asset;

public class AssetBuilderTest
{
    private AssetBuilder assetBuilder;

    @Before
    public void setUp() throws Exception
    {
        assetBuilder = new AssetBuilder();

    }

    @Test
    public void testWithAccount()
    {
        //given
        String account = "awesome";

        //when
        Asset asset = assetBuilder.withAccount(account).build();

        //then
        assertThat(asset.getAccount()).isEqualTo(account);

    }

    @Test
    public void testWithAssetName()
    {
        //given
        String assetName = "awesome";

        //when
        Asset asset = assetBuilder.withAssetName(assetName).build();

        //then
        assertThat(asset.getAssetName()).isEqualTo(assetName);
    }

    @Test
    public void testWithAssetNumber()
    {
        //given
        String assetNumber = "17000000";

        //when
        Asset asset = assetBuilder.withAssetNumber(assetNumber).build();

        //then
        assertThat(asset.getAssetNumber()).isEqualTo(assetNumber);

    }

    @Test
    public void testWithAssignedDate()
    {
        //given
        String assignedDate = "awesome";

        //when
        Asset asset = assetBuilder.withAssignedDate(assignedDate).build();

        //then
        assertThat(asset.getAssignedDate()).isEqualTo(assignedDate);

    }

    @Test
    public void testWithAssetType()
    {
        //given
        String assetType = "awesome";

        //when
        Asset asset = assetBuilder.withAssetType(assetType).build();

        //then
        assertThat(asset.getAssetType()).isEqualTo(assetType);

    }

    @Test
    public void testBuild()
    {
        //when
        Asset asset = assetBuilder.build();

        //then
        assertThat(asset).isNotNull();

    }
}