package com.thoughtworks.fam.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.thoughtworks.fam.TestUtils;
import com.thoughtworks.fam.domain.Asset;
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
                .content("{\"assetNumber\": \"17000001\", \"assetType\": \"Laptop\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    @Ignore
    public void should_return_bad_request_and_error_message_when_asset_name_be_null() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetType\": \"Laptop\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("INVALID_ASSET_NUMBER")))
                .andExpect(jsonPath("$.errorMessage", is("Number should not be null.")));
    }

    @Test
    public void should_return_bad_request_and_error_message_when_asset_type_be_null() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetNumber\": \"17000001\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("INVALID_ASSET_TYPE")))
                .andExpect(jsonPath("$.errorMessage", is("Type should not be null.")));
    }

    @Test
    @Ignore
    public void should_return_bad_request_and_error_message_when_asset_name_not_be_made_up_of_8_numbers() throws Exception
    {
        doNothing().when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetName\": \"123456\",\"assetType\": \"Apple Laptop\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("INVALID_ASSET_NUMBER")))
                .andExpect(jsonPath("$.errorMessage", is("Number should be made up of 8 numbers.")));
    }

    @Test
    @Ignore
    public void should_return_bad_request_and_error_message_when_asset_name_existed() throws Exception
    {
        doThrow(new ConflictException(ErrorCode.ASSET_NUMBER_EXISTED,"The number already exist, please use another one."))
                .when(assetService).createAsset(any(Asset.class));

        mockMvc.perform(post("/asset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assetName\": \"17000000\",\"assetType\": \"Laptop\"}"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorCode", is("ASSET_NUMBER_EXISTED")))
                .andExpect(jsonPath("$.errorMessage", is("The number already exist, please use another one.")));
    }


}
