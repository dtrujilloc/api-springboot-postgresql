package com.morgana.pruebatecnica.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el DTO para los amigos de los usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFriendDto {
    private Integer id;
    private String userId;
    private String friendId;
}
