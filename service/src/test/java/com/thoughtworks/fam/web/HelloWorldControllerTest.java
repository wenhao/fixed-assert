package com.thoughtworks.fam.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloWorldControllerTest
{

    private MockMvc mockMvc;
    @InjectMocks
    private HelloWorldController helloWorldController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

    }

    @Test
    public void should_be_able_to_run_test() throws Exception
    {
        // when
        this.mockMvc.perform(get("/helloworld"))
                .andExpect(status().isOk());
    }
}