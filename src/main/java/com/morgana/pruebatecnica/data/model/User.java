package com.morgana.pruebatecnica.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa la entidad de los usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "yelping_since")
    private Date yelpingSince;

    @Column(name = "useful")
    private Integer useful;

    @Column(name = "funny")
    private Integer funny;

    @Column(name = "cool")
    private Integer cool;

    @Column(name = "fans")
    private Integer fans;

    @Column(name = "average_starts")
    private Float averageStarts;

    @Embedded
    private UserCompliment userCompliment;

    @OneToMany(mappedBy = "user")
    private List<UserFriend> userFriendList;

}
