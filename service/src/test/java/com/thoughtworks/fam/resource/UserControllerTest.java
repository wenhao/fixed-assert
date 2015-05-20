package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.TestUtils;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.exception.GlobalExceptionHandler;
import com.thoughtworks.fam.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

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

public class UserControllerTest
{

    UserService userService;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        userService = mock(UserService.class);
        MockitoAnnotations.initMocks(this);

        HandlerExceptionResolver handlerExceptionResolver = TestUtils.
                prepareExceptionHandlerConfig().handlerExceptionResolver();

        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setHandlerExceptionResolvers(handlerExceptionResolver)
                .build();
    }

    @Test
    public void should_be_able_to_get_user_assets() throws Exception
    {
        given(userService.getAssets()).willReturn(
                newArrayList(
                        new Asset("foo", "bar", "awe", "some"),
                        new Asset("aaa", "bbb", "ccc", "ddd")));
        mockMvc.perform(get("/users/uid/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].assetName", is("foo")))
                .andExpect(jsonPath("$[0].assetNumber", is("bar")))
                .andExpect(jsonPath("$[0].assignedDate", is("awe")))
                .andExpect(jsonPath("$[0].assetType", is("some")));
    }

    @Test
    public void should_be_able_to_create_user() throws Exception
    {
        doNothing().when(userService).createUser(any(User.class));

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content("{\"account\": \"test\", \"password\": \"123456\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_get_conflict_status_code_when_account_exist() throws Exception
    {
        doThrow(new ConflictException(ErrorCode.ACCOUNT_EXISTED, "account has existed"))
                .when(userService).createUser(any(User.class));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"account\": \"twer\", \"p   assword\": \"123456\"}"))
                .andExpect(status().isConflict());
    }
}
