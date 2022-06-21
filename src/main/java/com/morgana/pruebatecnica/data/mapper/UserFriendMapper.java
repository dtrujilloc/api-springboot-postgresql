package com.morgana.pruebatecnica.data.mapper;

import com.morgana.pruebatecnica.common.dto.UserFriendDto;
import com.morgana.pruebatecnica.data.model.UserFriend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Inteface que permite el mappeo de los datos entre la entidad y el DTO de amigos de usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Mapper
public interface UserFriendMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "user.userId", target = "userId"),
            @Mapping(source = "friend.userId", target = "friendId"),
    })
    UserFriendDto entityToDto(UserFriend entity);

    List<UserFriendDto> entityListToDtoList(List<UserFriend> entityList);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userId", target = "user.userId"),
            @Mapping(source = "friendId", target = "friend.userId"),
    })
    UserFriend dtoToEntity(UserFriendDto dto);

    List<UserFriend> dtoListToEntityList(List<UserFriendDto> dtoList);
}
