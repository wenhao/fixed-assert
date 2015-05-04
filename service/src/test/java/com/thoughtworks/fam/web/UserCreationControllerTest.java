package com.thoughtworks.fam.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserCreationControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserCreationController userCreationController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userCreationController).build();
    }

    @Test
    public void should_return_please_enter_an_username_when_given_an_empty_username() throws Exception {
        this.mockMvc.perform(post("/admin", ""))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Please enter an username"));
    }

    @Test
    public void should_return_invalid_username_when_given_one() throws Exception {
        this.mockMvc.perform(post("/admin").param("username", "hello"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Invalid username in ThoughtWorks system."));
    }
}