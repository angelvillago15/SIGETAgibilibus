package com.agibilibus.SIGET.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agibilibus.SIGET.model.Usuario;

public interface UserDAO extends MongoRepository<Usuario, String> {

}
