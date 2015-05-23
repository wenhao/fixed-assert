package com.thoughtworks.fam.resource;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.thoughtworks.fam.TestUtils;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.service.AssetService;

public class AssetControllerTest
{
    private AssetService assetService;
    @InjectMocks
    private AssetController assetController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        HandlerExceptionResolver handlerExceptionResolver = TestUtils.
                prepareExceptionHandlerConfig().handlerExceptionResolver();

        assetService = mock(AssetService.class);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assetController)
                .setHandlerExceptionResolvers(handlerExceptionResolver).build();
    }


    @Test
    public void should_return_201_when_create_assets_success() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetName\": \"17001176\", \"assetType\": \"Apple Laptop\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_bad_request_and_error_message_when_asset_name_be_null() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetType\": \"Apple Laptop\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("INVALID_ASSET_NAME")))
                .andExpect(jsonPath("$.errorMessage", is("Name should not be null.")));
    }

    @Test
    public void should_return_bad_request_and_error_message_when_asset_type_be_null() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetName\": \"12345678\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("INVALID_ASSET_TYPE")))
                .andExpect(jsonPath("$.errorMessage", is("Type should not be null.")));
    }

    @Test
    public void should_return_bad_request_and_error_message_when_asset_name_not_be_made_up_of_8_numbers() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetName\": \"123abc\",\"assetType\": \"Apple Laptop\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("INVALID_ASSET_NAME")))
                .andExpect(jsonPath("$.errorMessage", is("Name should be made up of 8 numbers.")));
    }

    @Test
    public void should_return_bad_request_and_error_message_when_asset_name_existed() throws Exception
    {
        doThrow(new ConflictException(ErrorCode.ASSET_NAME_EXISTED,"The name already exist, please use another one."))
                .when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetName\": \"12345678\",\"assetType\": \"Apple Laptop\"}"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorCode", is("ASSET_NAME_EXISTED")))
                .andExpect(jsonPath("$.errorMessage", is("The name already exist, please use another one.")));
    }

    @Test
    public void should_be_able_to_get_other_users_assets() throws Exception
    {
        given(assetService.getOthersAssets()).willReturn(
                newArrayList(
                        new Asset("shuiqiang", "foo", "bar", "awe", "some"),
                        new Asset("kaihu", "aaa", "bbb", "ccc", "ddd")
                )
        );
        mockMvc.perform(get("/asset/others"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].ownerName", is("shuiqiang")))
                .andExpect(jsonPath("$[0].assetName", is("foo")))
                .andExpect(jsonPath("$[0].assetNumber", is("bar")))
                .andExpect(jsonPath("$[0].assignedDate", is("awe")))
                .andExpect(jsonPath("$[0].assetType", is("some")));
    }

    @Test
    public void should_get_assets_given_valid_user_id() throws Exception
    {
        long uid = 1L;
        given(assetService.getUserAssets(uid)).willReturn(
                newArrayList(
                        new Asset("owner","foo", "bar", "awe", "some"),
                        new Asset("owner","aaa", "bbb", "ccc", "ddd")));
        String urlTemplate = "/asset/"+uid;
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].assetName", is("foo")))
                .andExpect(jsonPath("$[0].assetNumber", is("bar")))
                .andExpect(jsonPath("$[0].assignedDate", is("awe")))
                .andExpect(jsonPath("$[0].assetType", is("some")));
    }


}
