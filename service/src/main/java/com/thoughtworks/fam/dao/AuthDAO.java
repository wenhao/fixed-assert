package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthDAO {

    private static Map<String, String> userMapper = new HashMap<String, String>(){{
        put("test", "123456");
        put("waterstrong", "123");
        put("wrongkey", "456");
    }};

    public UserDTO getUser(String name) {
        // TODO: waiting for database
        return userMapper.containsKey(name) ? new UserDTO(name, userMapper.get(name)) : null;
    }
}
