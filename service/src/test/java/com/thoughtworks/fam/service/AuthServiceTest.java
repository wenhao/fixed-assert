package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.AuthDAO;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthServiceTest {
    AuthService authService;

    AuthDAO authDAO;

    UserDTO userDTO;

    @Before
    public void setUp() throws Exception {
        authService = new AuthService();
        userDTO = new UserDTO("test", "123456");

        authDAO = mock(AuthDAO.class);
        ReflectionTestUtils.setField(authService, "authDAO", authDAO);
    }

    @Test
    public void should_login_successfully_when_given_correct_name_password() throws Exception {
        when(authDAO.getUser(userDTO.getName())).thenReturn(userDTO);
        UserDTO loginUser = authService.login(userDTO);

        assertThat(loginUser.getName(), is("test"));
        assertThat(loginUser.getPassword(), is("123456"));
    }

    @Test (expected = RuntimeException.class)
    public void should_expect_runtime_exception_when_no_user_found() throws Exception {
        when(authDAO.getUser(userDTO.getName())).thenReturn(null);

        authService.login(userDTO);
    }

    @Test (expected = RuntimeException.class)
    public void should_expect_runtime_exception_when_password_incrrect() throws Exception {
        when(authDAO.getUser(userDTO.getName())).thenReturn(new UserDTO("test", "22345"));

        authService.login(userDTO);
    }
}