package com.thoughtworks.fam.service;

import com.thoughtworks.fam.resource.domain.TempAsset;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TempUserServiceTest
{

    @Test
    public void should_be_able_to_get_assets()
    {
        TempUserService userService = new TempUserService();

        List<TempAsset> assets = userService.getAssets();

        assertThat(assets.size()).isGreaterThan(0);
    }

}