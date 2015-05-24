package com.thoughtworks.fam.resource;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.thoughtworks.fam.TestUtils;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.service.AssetService;

public class UserAssetsControllerTest
{
    private AssetService assetService;
    @InjectMocks
    private UserAssetsController userAssetsController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        HandlerExceptionResolver handlerExceptionResolver = TestUtils.
                prepareExceptionHandlerConfig().handlerExceptionResolver();

        assetService = mock(AssetService.class);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userAssetsController)
                .setHandlerExceptionResolvers(handlerExceptionResolver).build();
    }

    @Test
    public void should_be_able_to_get_other_users_assets() throws Exception
    {
        String account = "admin";
        given(assetService.getOthersAssets(account)).willReturn(
                newArrayList(
                        new Asset("admin", "foo", "bar", "awe", "some"),
                        new Asset("admin", "aaa", "bbb", "ccc", "ddd")
                )
        );
        mockMvc.perform(get("/users/" + account + "/others/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].account", is("admin")))
                .andExpect(jsonPath("$[0].assetName", is("foo")))
                .andExpect(jsonPath("$[0].assetNumber", is("bar")))
                .andExpect(jsonPath("$[0].assignedDate", is("awe")))
                .andExpect(jsonPath("$[0].assetType", is("some")));
    }

    @Test
    public void should_get_assets_given_valid_user_id() throws Exception
    {
        String account = "admin";
        given(assetService.getUserAssets(account)).willReturn(
                newArrayList(
                        new Asset("account","foo", "bar", "awe", "some"),
                        new Asset("account","aaa", "bbb", "ccc", "ddd")));
        String urlTemplate = "/users/"+account+"/assets";
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].account", is("account")))
                .andExpect(jsonPath("$[0].assetName", is("foo")))
                .andExpect(jsonPath("$[0].assetNumber", is("bar")))
                .andExpect(jsonPath("$[0].assignedDate", is("awe")))
                .andExpect(jsonPath("$[0].assetType", is("some")));
    }

}