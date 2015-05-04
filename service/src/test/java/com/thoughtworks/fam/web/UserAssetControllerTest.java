package com.thoughtworks.fam.web;

import com.thoughtworks.fam.service.UserAssetServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserAssetControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserAssetController userAssetController;

    private UserAssetServiceImpl userAssetService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userAssetController).build();

        userAssetService = mock(UserAssetServiceImpl.class);
        ReflectionTestUtils.setField(userAssetController, "userAssetService", userAssetService);

    }

    @Test
    public void should_access_to_get_user_assets() throws Exception {
        this.mockMvc.perform(get("/asset/sqlin@thoughtworks.com/list"))
                .andExpect(status().isOk());
    }

    @Test(expected = RuntimeException.class)
    public void should_get_runtime_exception() throws Exception {
        this.mockMvc.perform(get("/user//assets", null));
    }
}