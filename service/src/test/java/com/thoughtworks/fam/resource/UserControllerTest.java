package com.thoughtworks.fam.resource;

import com.google.gson.Gson;
import com.thoughtworks.fam.TestUtils;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.ConflictException;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.service.UserService;
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

public class UserControllerTest
{

    private UserService userService;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;
    private Gson gson;
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
        gson = new Gson();
    }

    @Test
    public void should_be_able_to_get_user_assets() throws Exception
    {
        given(userService.getUserAssets("uid")).willReturn(
                newArrayList(
                        new Asset("twer", "foo", "bar", "awe", "some"),
                        new Asset("twer", "aaa", "bbb", "ccc", "ddd")));
        mockMvc.perform(get("/users/uid/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].assetName", is("foo")))
                .andExpect(jsonPath("$[0].assetNumber", is("bar")))
                .andExpect(jsonPath("$[0].assignedDate", is("awe")))
                .andExpect(jsonPath("$[0].assetType", is("some")));
    }

    @Test
    public void should_be_able_to_get_other_users_assets() throws Exception
    {
        given(userService.getUserAssets()).willReturn(
                newArrayList(
                        new Asset("shuiqiang", "foo", "bar", "awe", "some"),
                        new Asset("kaihu", "aaa", "bbb", "ccc", "ddd")
                )
        );
        mockMvc.perform(get("/users/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].ownerName", is("shuiqiang")))
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
                .content(gson.toJson(new User("test","123456"))))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_get_conflict_status_code_when_account_exist() throws Exception
    {
        doThrow(new ConflictException(ErrorCode.ACCOUNT_EXISTED, "account has existed"))
                .when(userService).createUser(any(User.class));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new User("twer","123456"))))
                .andExpect(status().isConflict());
    }
}
