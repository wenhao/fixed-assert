package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.web.dto.UserAssetDTO;
import com.thoughtworks.fam.web.dto.UserDTO;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<UserDTO> userDTOs = userCollections.stream().filter(t -> t.getName() == userName).collect(Collectors.toList());
        return userDTOs.get(0);
    }
}
