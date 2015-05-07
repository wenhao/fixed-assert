package com.thoughtworks.fam.DAO;

import com.thoughtworks.fam.dao.AuthDAO;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by zy on 2015/5/7.
 */
public class AuthDAOtest {
    private AuthDAO authDAO = new AuthDAO();

    @Test
    public void should_get_user_when_given_existed_name(){
        UserDTO user = authDAO.getUser("test");
        assertThat(user.getName(),is("test"));
        assertThat(user.getPassword(),is("123456"));
    }

    @Test
    public void should_get_null_when_given_unexisted_name(){
        UserDTO user = authDAO.getUser("unexistedUserName");
        assertNull(user);
    }
}
