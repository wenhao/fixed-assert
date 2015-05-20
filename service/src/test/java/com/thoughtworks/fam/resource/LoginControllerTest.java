package com.thoughtworks.fam.resource;

import com.google.gson.Gson;
import com.thoughtworks.fam.TestUtils;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthenticationException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest
{

    @Mock
    LoginService loginService;
    @InjectMocks
    LoginController loginController;

    private User user;
    private String userJson;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        HandlerExceptionResolver handlerExceptionResolver = TestUtils.
                prepareExceptionHandlerConfig().handlerExceptionResolver();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController)
                .setHandlerExceptionResolvers(handlerExceptionResolver)
                .build();

        user = new User("admin", "P@ssword");
        userJson = (new Gson()).toJson(user);
    }

    @Test
    public void should_be_able_to_get_user_when_given_account_and_password() throws Exception
    {
        given(loginService.login("admin", "P@ssword")).willReturn(user);

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_unauthorized_status_code_and_error_message_when_account_not_exist() throws Exception
    {
        given(loginService.login(any(String.class), any(String.class)))
                .willThrow(new AuthenticationException(ErrorCode.USER_NOT_EXIST,
                        "The user is not exist."));

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.errorCode", is("USER_NOT_EXIST")))
                .andExpect(jsonPath("$.errorMessage", is("The user is not exist.")));
    }

    @Test
    public void should_get_unauthorized_status_code_and_error_message_when_password_not_matched() throws Exception
    {
        given(loginService.login(any(String.class), any(String.class)))
                .willThrow(new AuthenticationException(ErrorCode.PASSWORD_NOT_MATCHED,
                        "The password is not correct, please input again."));

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.errorCode", is("PASSWORD_NOT_MATCHED")))
                .andExpect(jsonPath("$.errorMessage", is("The password is not correct, please input again.")));
    }
}

