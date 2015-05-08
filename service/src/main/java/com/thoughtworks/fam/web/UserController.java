package com.thoughtworks.fam.web;

import com.thoughtworks.fam.dao.UserDAO;
import com.thoughtworks.fam.exception.ErrorCode;
import com.thoughtworks.fam.exception.UserException;
import com.thoughtworks.fam.web.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zy on 2015/5/7.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserDAO userDAO=new UserDAO();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)

    @ResponseBody
    UserDTO create(@RequestBody UserDTO userDTO) {
        if (isUserExisted(userDTO)){
            throw new UserException(ErrorCode.USER_NAME_CONFLICT,"user has existed");
        }
        else {
            this.userDAO.save(userDTO);
        }

        return userDTO;
    }

    private boolean isUserExisted(@RequestBody UserDTO userDTO) {
        UserDTO user = this.userDAO.getByUserName(userDTO.getName());
        return user !=null;
    }
}
