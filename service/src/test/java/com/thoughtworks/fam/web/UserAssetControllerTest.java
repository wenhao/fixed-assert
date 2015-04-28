package com.thoughtworks.fam.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserAssetControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserAssetController userAssetController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userAssetController).build();

    }

    @Test
    public void should_access_to_get_user_assets() throws Exception {
        // when
        this.mockMvc.perform(get("/user/assets"))
                .andExpect(status().isOk());

    }
}