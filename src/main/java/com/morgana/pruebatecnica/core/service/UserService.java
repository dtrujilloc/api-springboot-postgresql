package com.morgana.pruebatecnica.core.service;


import com.morgana.pruebatecnica.common.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class UserService {
//    @Autowired
//    private UserFacade userFacade;

    public List<UserDto> getAllUser() {
//        log.info(">>> Start method getAllUser");
//        List<UserDto> userDtoList = userFacade.getAllUser();
//        log.info("<<< End method getAllUser");
//        return userDtoList;
        UserDto userDto = new UserDto();
        userDto.setUserId("userId1");
        userDto.setName("userName1");
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(userDto);
        return userDtoList;
    }

    public UserDto saveUser(UserDto data) {
//        UserDto userDto = userFacade.saveUser(data);
        UserDto userDto = new UserDto();
        userDto.setUserId("userId1");
        userDto.setName("userName1");
        return userDto;
    }
}
