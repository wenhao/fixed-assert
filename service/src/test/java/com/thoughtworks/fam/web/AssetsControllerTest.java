package com.thoughtworks.fam.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssetsControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private AssetsController assetsController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assetsController).build();
    }

    @Test
    public void should_get_status_ok_when_give_correct_url() throws Exception {
        this.mockMvc.perform(get("/user/assets")).andExpect(status().isOk());
    }

}