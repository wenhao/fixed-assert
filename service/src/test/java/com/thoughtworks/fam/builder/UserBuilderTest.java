package com.thoughtworks.fam.builder;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.fam.domain.User;

public class UserBuilderTest
{
    private UserBuilder userBuilder;

    @Before
    public void setUp() throws Exception
    {
        userBuilder = new UserBuilder();
    }

    @Test
    public void testWithAccount()
    {
        //given
        String account = "awesome";

        //when
        User user = userBuilder.withAccount(account).build();

        //then
        assertThat(user.getAccount()).isEqualTo(account);

    }

    @Test
    public void testWithPassword()
    {
        //given
        String password = "awesome";

        //when
        User user = userBuilder.withPassword(password).build();

        //then
        assertThat(user.getPassword()).isEqualTo(password);

    }

    @Test
    public void testBuild()
    {
        //when
        User user = userBuilder.build();

        //then
        assertThat(user).isNotNull();

    }
}
