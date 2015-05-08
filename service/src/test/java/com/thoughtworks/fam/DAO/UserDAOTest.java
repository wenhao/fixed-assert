package com.thoughtworks.fam.DAO;

import com.thoughtworks.fam.dao.UserDAO;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by zy on 2015/5/7.
 */
public class UserDAOTest {
    private UserDAO userDAO;

    @Test
    public void should_save_user_and_get_the_user_by_name(){
        UserDTO givenUser = new UserDTO("jTao","P@ss123456");
        UserDAO.save(givenUser);

        UserDTO actualUser = UserDAO.getByUserName(givenUser.getName());

        assertThat(actualUser.getPassword() ,is(givenUser.getPassword()));
        assertThat(actualUser.getName(),is(givenUser.getName()));
    }

    @Test
    public void should_get_null_when_given_unexisted_user_name(){
        UserDTO actualUser = UserDAO.getByUserName("UnexistedUserName");
        assertNull(actualUser);
    }
}
