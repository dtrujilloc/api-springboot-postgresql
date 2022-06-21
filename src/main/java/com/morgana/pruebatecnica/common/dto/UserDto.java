package com.morgana.pruebatecnica.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase que representa el DTO para los usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String name;
    private Integer reviewCount;
    private String yelpingSince;
    private Integer useful;
    private Integer funny;
    private Integer cool;
    private Integer fans;
    private Float averageStarts;
    private Integer complimentHot;
    private Integer complimentMore;
    private Integer complimentProfile;
    private Integer complimentCute;
    private Integer complimentList;
    private Integer complimentNote;
    private Integer complimentPlain;
    private Integer complimentCool;
    private Integer complimentFunny;
    private Integer complimentWriter;
    private Integer complimentPhotos;
    private List<String> friends;
}
