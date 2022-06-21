package com.morgana.pruebatecnica.core.service;


import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.data.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserFacade userFacade;

    public List<UserDto> getAllUser() {
        log.info(">>> Start method getAllUser");

        List<UserDto> userDtoList = userFacade.getAllUser();

        log.info("<<< End method getAllUser");
        return userDtoList;
    }

    public UserDto saveUser(UserDto data) {
        log.info(">>> Start method saveUser");

        UserDto userDto = userFacade.saveUser(data);

        log.info("<<< End method saveUser");

        return userDto;
    }

    private UserDto buildUser() {
        UserDto userDto = new UserDto();
        userDto.setUserId("userId1.1");
        userDto.setName("userName1.1");
        return userDto;
    }
}
