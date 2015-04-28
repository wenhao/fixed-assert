package com.thoughtworks.fam.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssetsControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private AssetsController assetsController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assetsController).build();

    }

    @Test
    public void should_get_ok_status_given_valid_url() throws Exception {
        // when
        this.mockMvc.perform(get("/assets"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_correct_data_given_valid_url() throws Exception {

        //when
        MvcResult result = this.mockMvc.perform(get("/assets"))
                .andExpect(handler().handlerType(AssetsController.class))
                .andExpect(handler().methodName("onAssetsView"))
                .andReturn();

        //then
        String json = result.getResponse().getContentAsString();
        Map<String, String> map = new Gson().fromJson(json, new TypeToken<Map<String, String>>() {
        }.getType());
        assertThat(map.get("name"), is("MacBook"));
        assertThat(map.get("number"), is("1700160169"));
        assertThat(map.get("assignedDate"), is("20150425"));
        assertThat(map.get("type"), is("laptop"));
    }
}
