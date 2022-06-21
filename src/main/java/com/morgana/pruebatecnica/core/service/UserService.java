package com.morgana.pruebatecnica.core.service;


import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.common.dto.UserFriendDto;
import com.morgana.pruebatecnica.data.facade.UserFacade;
import com.morgana.pruebatecnica.data.facade.UserFriendFacade;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Clase que contien toda la logica de negocio relacionada a los usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private UserFriendFacade userFriendFacade;

    /**
     * Permite obtener todos los usuarios
     * @return una lista de Usuarios
     */
    public List<UserDto> getAllUser() {
        log.info(">>> Start method getAllUser");

        List<UserDto> userDtoList = userFacade.getAllUser();

        log.info("<<< End method getAllUser");
        return userDtoList;
    }

    /**
     * Permite guardar un usuario nuevo
     * @param data Objeto de tipo UserDto con la informacion a guardar
     * @return un objeto de tipo UserDto con la informacion guardada
     * @throws Exception
     */
    public UserDto saveUser(UserDto data) throws Exception {
        log.info(">>> Start method saveUser");

        UserDto userDto;

        if (Objects.nonNull(data)) {
            userDto = userFacade.saveUser(data);

            List<String> friendIdList = saveAllFriend(data.getUserId(), data.getFriends());
            userDto.setFriends(friendIdList);
        }
        else
        {
            throw new Exception("la data es null");
        }

        log.info("<<< End method saveUser");
        return userDto;
    }

    /**
     * Se encarga de hacer el guardado de los amigos relacionados al usuario que se esta guardando
     * @param userId String que reprsenta el idenficador del usuario que se esta guardando
     * @param friends Lista de String que representa los identificadores de los usuarios que son amigos
     * @return una lista de String que representa los idenficadores de los amigos que fueron guardados
     * @throws Exception
     */
    private List<String> saveAllFriend(String userId, List<String> friends) throws Exception {
        log.info(">>> Start method saveAllFriend -> userId:{} - friends:{}", userId, friends);

        List<String> friendIdList = new ArrayList<>();

        try {
            if (Objects.nonNull(userId) && Objects.nonNull(friends) && !friends.isEmpty())
            {
                List<UserFriendDto> userFriendList = friends.stream().map(friendTemp -> UserFriendDto.builder().userId(userId).friendId(friendTemp).build()).collect(Collectors.toList());
                userFriendList = userFriendFacade.saveAll(userFriendList);
                friendIdList = userFriendList.stream().map(UserFriendDto::getFriendId).collect(Collectors.toList());
            }
            else
            {
                log.info("la Info es null o vacia");
            }
        } catch (TransientPropertyValueException ex) {
            log.error("Error, se esta intentando guardar un id de un amigo que no existe en la tabla de usuario -> friendIds:{}", friends);
            throw new Exception("Error al tratar de guardar los friends del usuario");
        } catch (Exception ex) {
            log.error("Error desconocido -> ex:{}", ex.getMessage());
            throw new Exception("Error desconocidog al tratar de guardar los friends del usuario");
        }

        log.info("<<< End method saveAllFriend -> friendIdList:{}", friendIdList);
        return friendIdList;
    }
}
