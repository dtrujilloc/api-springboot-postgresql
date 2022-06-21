package com.morgana.pruebatecnica.data.facade;

import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.data.mapper.UserMapper;
import com.morgana.pruebatecnica.data.model.User;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserFacade {

//    @Autowired
//    private UserRepository userRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);;

    public List<UserDto> getAllUser() {
        log.info(">>> Start method getAllUser");

//        List<User> userList = (ArrayList<User>)userRepository.findAll();
//        List<UserDto> userDtoList = userMapper.entityListToDtoList(userList);

        List<User> userList = new ArrayList<>();
        userList.add(buildUser());
        List<UserDto> userDtoList = userMapper.entityListToDtoList(userList);
        log.info("<<< End method getAllUser -> userDtoLisSize:{}", userDtoList.size());
        return userDtoList;
    }

    public UserDto saveUser(UserDto data) {
        log.info(">>> Start method saveUser");

//        User user = userMapper.dtoToEntity(data);
//        User userSaved = userRepository.save(user);

        User user = buildUser();
        UserDto userDto = userMapper.entityToDto(user);

        log.info("<<< End method saveUser -> userDto:{}", userDto);
        return userDto;
    }

    private User buildUser() {
        User user = new User();
        user.setUserId("userId1.2");
        user.setName("userName1.2");
        return user;
    }
}
