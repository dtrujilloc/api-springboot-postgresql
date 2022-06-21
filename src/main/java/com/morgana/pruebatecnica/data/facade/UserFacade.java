package com.morgana.pruebatecnica.data.facade;

import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.data.mapper.UserMapper;
import com.morgana.pruebatecnica.data.model.User;
import com.morgana.pruebatecnica.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Clase que representa el patron Fachada (FACADE) para los usuarios, Permite exponer los metodos
 * que realizan las funcionalidades sin dar detalle a como se hace internamente
 * @author dtrujillo
 * @version 1.0
 */
@Slf4j
@Component
public class UserFacade {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public List<UserDto> getAllUser() {
        log.info(">>> Start method getAllUser");

        List<User> userList = userRepository.getAll();
        List<UserDto> userDtoList = userMapper.entityListToDtoList(userList);

        log.info("<<< End method getAllUser -> userDtoLisSize:{}", userDtoList.size());
        return userDtoList;
    }

    public UserDto saveUser(UserDto data) {
        log.info(">>> Start method saveUser");

        User user = userMapper.dtoToEntity(data);
        user = userRepository.save(user);
        UserDto userDto = userMapper.entityToDto(user);

        log.info("<<< End method saveUser -> userDto:{}", userDto);
        return userDto;
    }
}
