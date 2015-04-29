package com.thoughtworks.fam.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserAssetControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserAssetController userAssetController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userAssetController).build();

    }

    @Test
    public void should_access_to_get_user_assets() throws Exception {
        // when
        this.mockMvc.perform(get("/user/sqlin@thoughtworks.com/assets"))
                .andExpect(status().isOk());
    }

    @Test //(expected = RuntimeException.class)
    public void should_get_runtime_exception() throws Exception {
        // this.mockMvc.perform(get("/user//assets"));
    }
}