package com.morgana.pruebatecnica.data.mapper;

import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.data.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "name", target = "name")
    })
    UserDto entityToDto(User entity);

    List<UserDto> entityListToDtoList(List<User> entityList);

    User dtoToEntity(UserDto dto);

    List<User> dtoListToEntityList(List<UserDto> dtoList);

}
