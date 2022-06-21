package com.morgana.pruebatecnica.core.controller;


import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUser() {
        log.info(">>> Start endpoint getAllUser");

        List<UserDto> userDtoList = userService.getAllUser();

        log.info("<<< End endpoint getAllUser");
        return userDtoList;
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto data) {
        log.info(">>> Start endpoint saveUser");

        UserDto userDto = userService.saveUser(data);

        log.info("<<< End endpoint saveUser");
        return userDto;
    }
}
