package com.thoughtworks.fam.service;

import com.thoughtworks.fam.ApplicationRunner;
import com.thoughtworks.fam.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationRunner.class)
public class UserRepositoryIntegrationTest
{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_find_users_imported_from_sql_script()
    {
        //when
        long count = this.userRepository.count();

        //then
        assertThat(count).isGreaterThan(0);
    }

    @Test
    public void should_find_user_given_valid_account()
    {
        //given
        String account = "admin";

        //when
        User user = this.userRepository.findByAccount(account);

        //then
        assertThat(user).isNotNull();
    }

    @Test
    public void should_get_failed_given_invalid_account()
    {
        //given
        String account = "";

        //when
        User user = this.userRepository.findByAccount(account);

        //then
        assertThat(user).isNull();
    }
}