package com.thoughtworks.fam.resource;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TempUserControllerTest
{

    @Test
    public void should_be_able_to_get_user_assets() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new TempUserController()).build();
        mockMvc.perform(get("/users/uid/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].assetName", is("Macbook")))
                .andExpect(jsonPath("$[0].assetNumber", is("123456")))
                .andExpect(jsonPath("$[0].assignedDate", is("2015-05-08")))
                .andExpect(jsonPath("$[0].assetType", is("Laptop")));
    }

}
