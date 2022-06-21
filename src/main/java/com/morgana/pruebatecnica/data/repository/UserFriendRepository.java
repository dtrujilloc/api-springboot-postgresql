package com.morgana.pruebatecnica.data.repository;

import com.morgana.pruebatecnica.data.model.UserFriend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que permite la conexion con la BD para realizar operaciones relacionadas con
 * los amigos de los usuarios
 * @author dtrujillo
 * @version 1.0
 */
@Repository
public interface UserFriendRepository extends CrudRepository<UserFriend, Integer> {
}
