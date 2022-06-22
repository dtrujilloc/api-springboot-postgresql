package com.morgana.pruebatecnica.core.service;

import com.morgana.pruebatecnica.common.dto.UserDto;
import com.morgana.pruebatecnica.data.facade.UserFacade;
import com.morgana.pruebatecnica.data.facade.UserFriendFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserFacade userFacade;

    @Mock
    private UserFriendFacade userFriendFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllUserTest() {
        when(userFacade.getAllUser()).thenReturn(buildUserDtoList());

        List<UserDto> result = userService.getAllUser();

        Assertions.assertAll(
                () -> assertNotNull(result),
                () -> assertFalse(result.isEmpty())
        );
    }

    @Nested
    @DisplayName("Casos de prueba saveUser")
    class saveUser {

        @Test
        @DisplayName("Happy Path")
        void saveUserTestHappyPath() throws Exception {
            List<String> friendList = new ArrayList<>();
            friendList.add("userId2");

            UserDto data = buildUserDto("userId1", "userName1");
            data.setFriends(friendList);

            when(userFacade.saveUser(data)).thenReturn(data);
            when(userFriendFacade.saveAll(any())).thenReturn(new ArrayList<>());

            UserDto result = userService.saveUser(data);

            Assertions.assertAll(
                    () -> assertNotNull(result),
                    () -> assertEquals(result.getUserId(), data.getUserId())
            );
        }

        @Test
        @DisplayName("No Happy Path Exception")
        void saveUserTestNoHappyPath() throws Exception {
            List<String> friendList = new ArrayList<>();
            friendList.add("userId2");

            UserDto data = buildUserDto("userId1", "userName1");
            data.setFriends(friendList);

            when(userFacade.saveUser(data)).thenReturn(data);
            when(userFriendFacade.saveAll(any())).thenReturn(null);

            Exception exception = assertThrows(Exception.class, ()
                    -> userService.saveUser(data));

            Assertions.assertAll(
                    () -> assertNotNull(exception),
                    () -> assertEquals(exception.getMessage(), "Error desconocidog al tratar de guardar los friends del usuario")
            );
        }

    }

    private List<UserDto> buildUserDtoList()
    {
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(buildUserDto("userId1", "userName1"));

        return userDtoList;
    }

    private UserDto buildUserDto(String id, String name) {
        return UserDto.builder().userId(id).name(name).build();
    }

}
