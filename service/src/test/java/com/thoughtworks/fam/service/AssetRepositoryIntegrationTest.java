package com.thoughtworks.fam.service;

import com.thoughtworks.fam.ApplicationRunner;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationRunner.class)
public class AssetRepositoryIntegrationTest
{
    @Autowired
    private AssetRepository assetRepository;

    @Test
    public void should_find_assets_imported_from_sql_script() throws Exception
    {
        //when
        long count = this.assetRepository.count();

        //then
        assertThat(count).isGreaterThan(0);
    }

    @Test
    public void should_find_correct_assets_given_valid_number()
    {
        //given
        String number = "17000001";
        String expectedOwnerName = "lwzhang";
        String expectedAssetName = "MacBook Pro";
        String expectedAssetType = "Laptop";

        //when
        Asset asset = assetRepository.findByAssetNumber(number);

        //then
        assertThat(asset.getOwnerName()).isEqualTo(expectedOwnerName);
        assertThat(asset.getAssetName()).isEqualTo(expectedAssetName);
        assertThat(asset.getAssetType()).isEqualTo(expectedAssetType);
    }

    @Test
    public void should_get_failed_given_invalid_number()
    {
        //when
        Asset asset = assetRepository.findByAssetNumber(null);

        //then
        assertThat(asset).isNull();
    }
}