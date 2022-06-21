package com.morgana.pruebatecnica.data.repository;

import com.morgana.pruebatecnica.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface que permite la conexion con la BD para realizar operaciones relacionadas con
 * los Usuraios
 * @author dtrujillo
 * @version 1.0
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM User u")
    List<User> getAll();
}


