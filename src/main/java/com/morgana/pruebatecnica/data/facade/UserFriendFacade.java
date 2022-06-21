package com.morgana.pruebatecnica.data.facade;

import com.morgana.pruebatecnica.common.dto.UserFriendDto;
import com.morgana.pruebatecnica.data.mapper.UserFriendMapper;
import com.morgana.pruebatecnica.data.model.UserFriend;
import com.morgana.pruebatecnica.data.repository.UserFriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Clase que representa el patron Fachada (FACADE) para los amigos de los usuarios, Permite exponer los metodos
 * que realizan las funcionalidades sin dar detalle a como se hace internamente
 * @author dtrujillo
 * @version 1.0
 */
@Slf4j
@Component
public class UserFriendFacade {
    @Autowired
    private UserFriendRepository userFriendRepository;

    private UserFriendMapper userFriendMapper = Mappers.getMapper(UserFriendMapper.class);

    public List<UserFriendDto> saveAll(List<UserFriendDto> dataList) {
        log.info(">>> Start method saveAll -> datalistSize:{}", dataList.size());

        List<UserFriend> userFriendList = userFriendMapper.dtoListToEntityList(dataList);
        userFriendList = StreamSupport.stream(userFriendRepository.saveAll(userFriendList).spliterator(), false).collect(Collectors.toList());
        List<UserFriendDto>  userFriendDtoList= userFriendMapper.entityListToDtoList(userFriendList);

        log.info("<<< End method log saveAll -> userFriendDtoListSize:{}", userFriendDtoList.size());
        return userFriendDtoList;
    }
}
