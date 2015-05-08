package com.thoughtworks.fam.web;

import com.google.gson.Gson;
import com.thoughtworks.fam.exception.UserException;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zy on 2015/5/7.
 */
public class UserControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private UserController userController;
    private Gson gson;
    private UserDTO jTao;
    private UserDTO usedUser;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        gson = new Gson();
        jTao = new UserDTO("jTao", "P@ss123456");
        usedUser = new UserDTO("yzhou","P@ss123456");
    }

    @Test
    public void should_create_user_success_when_given_user() throws Exception {

        String response = this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(jTao)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        UserDTO actualUser = gson.fromJson(response,UserDTO.class);
        assertThat(actualUser.getName(), is("jTao"));
        assertThat(actualUser.getPassword(),is("P@ss123456"));
    }

    @Test
    public void should_create_user_fail_when_given_used_name() throws Exception{
        try {
            this.mockMvc.perform(post("/user")
               .contentType(MediaType.APPLICATION_JSON)
               .content(gson.toJson(usedUser)));
         }
         catch (Exception ex){
                assertTrue(ex instanceof UserException);
                assertTrue(ex.getMessage().contains("user has existed"));
         }
    }
}
