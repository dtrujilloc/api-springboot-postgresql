package com.morgana.pruebatecnica.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase embebida que representa un conjunto de datos de los usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserCompliment {

    @Column(name = "compliment_hot")
    private Integer complimentHot;

    @Column(name = "compliment_more")
    private Integer complimentMore;

    @Column(name = "compliment_profile")
    private Integer complimentProfile;

    @Column(name = "compliment_cute")
    private Integer complimentCute;

    @Column(name = "compliment_list")
    private Integer complimentList;

    @Column(name = "compliment_note")
    private Integer complimentNote;

    @Column(name = "compliment_plain")
    private Integer complimentPlain;

    @Column(name = "compliment_cool")
    private Integer complimentCool;

    @Column(name = "compliment_funny")
    private Integer complimentFunny;

    @Column(name = "compliment_writer")
    private Integer complimentWriter;

    @Column(name = "compliment_photos")
    private Integer complimentPhotos;
}
