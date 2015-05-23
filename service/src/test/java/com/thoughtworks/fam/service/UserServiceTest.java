package com.thoughtworks.fam.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;

public class UserServiceTest
{
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp()
    {
        initMocks(this);
        userService = new UserService(userRepository);
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

}