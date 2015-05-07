package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.web.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zy on 2015/5/7.
 */
public class UserDAO {

    private static List<UserDTO>  userCollections = new ArrayList<>();

    public UserDAO() {
    }

    public static void save(UserDTO givenUser) {
        userCollections.add(givenUser);
    }

    public static UserDTO getByUserName(String userName) {
        for (UserDTO user :userCollections){
            if (user.getName()==userName){
                return user;
            }
        }
        return null;
    }
}
