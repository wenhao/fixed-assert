package com.thoughtworks.fam.web;

import com.google.gson.Gson;
import com.thoughtworks.fam.service.AuthService;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private AuthController authController;
    private Gson gson;

    private AuthService authService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        gson = new Gson();

        authService = mock(AuthService.class);
        ReflectionTestUtils.setField(authController, "authService", authService);
    }

    @Test
    public void should_be_able_to_login() throws Exception {
        String userJson = gson.toJson(new UserDTO("test", "123456"));

        // when
        this.mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk());
    }

}