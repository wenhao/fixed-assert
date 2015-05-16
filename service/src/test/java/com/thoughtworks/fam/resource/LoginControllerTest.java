package com.thoughtworks.fam.resource;

import com.google.gson.Gson;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest {

    @Mock
    LoginService loginService;
    @InjectMocks
    LoginController loginController;

    private User user;
    private String userJson;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User("admin","P@ssword");
        userJson = (new Gson()).toJson(user);
    }

    @Test
    public void should_be_able_to_get_user_when_given_account_and_password() throws Exception {
        given(loginService.login("admin","P@ssword")).willReturn(user);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk());
    }


}

