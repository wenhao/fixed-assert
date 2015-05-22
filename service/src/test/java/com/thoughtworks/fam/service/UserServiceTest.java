package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest
{
    private UserService userService;

    @Before
    public void setUp()
    {
        userService = new UserService();
    }

    @Test
    public void should_be_able_to_get_assets()
    {
        List<Asset> assets = userService.getUserAssets("uid");

        assertThat(assets.size()).isGreaterThan(0);
    }

    @Test
    public void should_be_able_to_create_user()
    {
        int beforeCreateAmount = UserService.getUsers().size();
        userService.createUser(new User("test", "123"));

        assertThat(UserService.getUsers().size())
                .isEqualTo(beforeCreateAmount + 1);
    }

    @Test(expected = ConflictException.class)
    public void should_create_user_failed_when_user_exist()
    {
        userService.createUser(new User("twer", "123"));
    }
}