package com.thoughtworks.fam.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
    public void should_return_create_successful_message_when_given_a_valid_username() throws Exception {
        this.mockMvc.perform(post("/admin/create").param("username", "jtao"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("creationStatus").value("success"))
                .andExpect(jsonPath("message").value("User has been succesfully created."));
    }

    @Test
    public void should_return_please_enter_an_username_when_given_an_empty_username() throws Exception {
        this.mockMvc.perform(post("/admin/create", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("creationStatus").value("failed"))
                .andExpect(jsonPath("message").value("Please enter an username"));
    }

    @Test
    public void should_return_invalid_username_when_given_one() throws Exception {
        this.mockMvc.perform(post("/admin/create").param("username", "hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("creationStatus").value("failed"))
                .andExpect(jsonPath("message").value("Invalid username in ThoughtWorks system."));
    }
}