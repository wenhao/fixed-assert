package com.thoughtworks.fam.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.fam.ApplicationRunner;
import com.thoughtworks.fam.builder.AssetBuilder;
import com.thoughtworks.fam.domain.Asset;

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
        String expectedAccount = "lwzhang";
        String expectedAssetName = "MacBook Pro";
        String expectedAssetType = "Laptop";

        //when
        Asset asset = assetRepository.findByAssetNumber(number);

        //then
        assertThat(asset.getAccount()).isEqualTo(expectedAccount);
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

    @Test
    public void should_get_correct_assets_given_valid_account()
    {
        //given
        String account = "lwzhang";

        //when
        List<Asset> assets = assetRepository.findByAccount(account);

        //then
        assertThat(assets.size()).isEqualTo(2);
        assertThat(assets.get(0).getAssetNumber()).isEqualTo("17000001");
        assertThat(assets.get(0).getAssetType()).isEqualTo("Laptop");
        assertThat(assets.get(1).getAssetNumber()).isEqualTo("17000002");
        assertThat(assets.get(1).getAssetType()).isEqualTo("Mobile");
    }

    @Test
    public void should_get_nothing_given_invalid_account()
    {
        //given
        String account = "";

        //when
        List<Asset> assets = assetRepository.findByAccount(account);

        //then
        assertThat(assets.size()).isZero();

    }

    @Test
    public void should_save_asset_given_valid_asset()
    {
        //given
        long originCount = assetRepository.count();
        Asset asset = new AssetBuilder().withAssetNumber("12345678").withAssetType("awesome").build();

        //when
        assetRepository.save(asset);
        long count = assetRepository.count();

        //then
        assertThat(count).isGreaterThan(originCount);

    }

    @Test(expected = ConstraintViolationException.class)
    public void should_not_save_given_missing_number_asset()
    {
        //given
        Asset asset = new AssetBuilder().withAssetType("awesome").build();

        //when
        assetRepository.save(asset);

    }

    @Test(expected = ConstraintViolationException.class)
    public void should_not_save_given_missing_type_asset()
    {
        //given
        Asset asset = new AssetBuilder().withAssetNumber("12345678").build();

        //when
        assetRepository.save(asset);

    }
}
