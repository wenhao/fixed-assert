package com.thoughtworks.fam.service;

import com.thoughtworks.fam.ApplicationRunner;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
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

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_find_assets_imported_from_sql_script() throws Exception
    {
        //when
        long count = this.assetRepository.count();

        //then
        assertThat(count).isGreaterThan(0);
    }

    @Test
    public void should_find_correct_assets_given_valid_user() throws Exception
    {
        //given
        String account = "lwzhang";
        String expectedNumberOne = "170170170";
        String expectedNumberTwo = "180170170";
        User user = this.userRepository.findByAccount(account);

        //when
        List<Asset> assets = this.assetRepository.findByUser(user);

        //then
        assertThat(assets.size()).isNotZero();
        assertThat(assets.get(0).getAssetNumber()).isEqualTo(expectedNumberOne);
        assertThat(assets.get(1).getAssetNumber()).isEqualTo(expectedNumberTwo);
    }

    @Test
    public void should_get_failed_given_invalid_user() throws Exception
    {
        //when
        List<Asset> assets = this.assetRepository.findByUser(null);

        //then
        assertThat(assets.size()).isZero();
    }
}