package com.morgana.pruebatecnica.core.controller;


import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controllador que contiene todos los endpoints o servicios relacionados con Usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Endpoitn que permite obtener todos los usuarios
     * @return una lista de Usuarios
     */
    @GetMapping
    public List<UserDto> getAllUser() {
        log.info(">>> Start endpoint getAllUser");

        List<UserDto> userDtoList = userService.getAllUser();

        log.info("<<< End endpoint getAllUser");
        return userDtoList;
    }

    /**
     * Endpoitn que permite guardar un usuario nuevo
     * @param data Objeto de tipo UserDto con la informacion a guardar
     * @return un objeto de tipo UserDto con la informacion guardada
     * @throws Exception
     */
    @PostMapping
    public UserDto saveUser(@RequestBody UserDto data) throws Exception {
        log.info(">>> Start endpoint saveUser");

        UserDto userDto = userService.saveUser(data);

        log.info("<<< End endpoint saveUser");
        return userDto;
    }
}
