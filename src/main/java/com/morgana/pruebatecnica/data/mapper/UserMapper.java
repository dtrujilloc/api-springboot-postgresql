package com.morgana.pruebatecnica.data.mapper;

import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.data.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Inteface que permite el mappeo de los datos entre la entidad y el DTO de Usuario
 * @author dtrujillo
 * @version 1.0
 */
@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface UserMapper {

    @AfterMapping
    default void dtoToEntityCall(@MappingTarget UserDto dto, User user) {
        List<String> friends = new ArrayList<>();
        if (Objects.nonNull(user) && Objects.nonNull(user.getUserFriendList()) && !user.getUserFriendList().isEmpty())
        {
            friends = user.getUserFriendList().stream().map(userTemp -> userTemp.getFriend().getUserId()).collect(Collectors.toList());

        }
        dto.setFriends(friends);
    }

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "reviewCount", target = "reviewCount"),
            @Mapping(source = "useful", target = "useful"),
            @Mapping(source = "funny", target = "funny"),
            @Mapping(source = "cool", target = "cool"),
            @Mapping(source = "fans", target = "fans"),
            @Mapping(source = "averageStarts", target = "averageStarts"),
            @Mapping(source = "userCompliment.complimentHot", target = "complimentHot"),
            @Mapping(source = "userCompliment.complimentMore", target = "complimentMore"),
            @Mapping(source = "userCompliment.complimentProfile", target = "complimentProfile"),
            @Mapping(source = "userCompliment.complimentCute", target = "complimentCute"),
            @Mapping(source = "userCompliment.complimentList", target = "complimentList"),
            @Mapping(source = "userCompliment.complimentNote", target = "complimentNote"),
            @Mapping(source = "userCompliment.complimentPlain", target = "complimentPlain"),
            @Mapping(source = "userCompliment.complimentCool", target = "complimentCool"),
            @Mapping(source = "userCompliment.complimentFunny", target = "complimentFunny"),
            @Mapping(source = "userCompliment.complimentWriter", target = "complimentWriter"),
            @Mapping(source = "userCompliment.complimentPhotos", target = "complimentPhotos"),
            @Mapping(target = "friends", ignore = true),
            @Mapping(source = "yelpingSince", target = "yelpingSince", dateFormat = "YYYY-MM-DD")
    })
    UserDto entityToDto(User entity);

    List<UserDto> entityListToDtoList(List<User> entityList);

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "reviewCount", target = "reviewCount"),
            @Mapping(source = "useful", target = "useful"),
            @Mapping(source = "funny", target = "funny"),
            @Mapping(source = "cool", target = "cool"),
            @Mapping(source = "fans", target = "fans"),
            @Mapping(source = "averageStarts", target = "averageStarts"),
            @Mapping(source = "complimentHot", target = "userCompliment.complimentHot"),
            @Mapping(source = "complimentMore", target = "userCompliment.complimentMore"),
            @Mapping(source = "complimentProfile", target = "userCompliment.complimentProfile"),
            @Mapping(source = "complimentCute", target = "userCompliment.complimentCute"),
            @Mapping(source = "complimentList", target = "userCompliment.complimentList"),
            @Mapping(source = "complimentNote", target = "userCompliment.complimentNote"),
            @Mapping(source = "complimentPlain", target = "userCompliment.complimentPlain"),
            @Mapping(source = "complimentCool", target = "userCompliment.complimentCool"),
            @Mapping(source = "complimentFunny", target = "userCompliment.complimentFunny"),
            @Mapping(source = "complimentWriter", target = "userCompliment.complimentWriter"),
            @Mapping(source = "complimentPhotos", target = "userCompliment.complimentPhotos"),
            @Mapping(target = "userFriendList", ignore = true),
            @Mapping(source = "yelpingSince", target = "yelpingSince", dateFormat = "YYYY-MM-DD")
    })
    User dtoToEntity(UserDto dto);

    List<User> dtoListToEntityList(List<UserDto> dtoList);

}
