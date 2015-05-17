package com.thoughtworks.fam.resource;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssetsControllerTest
{
    @InjectMocks
    private AssetsController assetController;
    private MockMvc mockMvc ;

    @Test
    public void should_return_201_when_create_assets_success() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        mockMvc=MockMvcBuilders.standaloneSetup(assetController).build();

        this.mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{name:\"17001176\",type:\"Apple Laptop\"}"))
                .andExpect(status().isCreated());
    }

}
