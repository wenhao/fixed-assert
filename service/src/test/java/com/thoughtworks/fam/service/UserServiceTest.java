package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest
{
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AssetRepository assetRepository;

    @Before
    public void setUp()
    {
        initMocks(this);
        userService = new UserService(userRepository, assetRepository);
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

    @Test
    public void should_get_user_given_valid_user_id()
    {
        //given
        long uid = 1L;
        User mockUser = mock(User.class);
        given(userRepository.findOne(uid)).willReturn(mockUser);

        //when
        User user = userService.getUser(uid);

        //then
        assertThat(user).isEqualTo(mockUser);
    }

    @Test
    public void should_get_assets_given_valid_user_id()
    {
        //given
        long uid = 1L;
        List mockAssets = mock(List.class);
        given(assetRepository.findByUser(any(User.class))).willReturn(mockAssets);

        //when
        List<Asset> assets = userService.getAssets(uid);

        //then
        assertThat(assets).isEqualTo(mockAssets);

    }
}