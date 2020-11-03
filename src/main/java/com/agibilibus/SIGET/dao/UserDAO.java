package com.agibilibus.SIGET.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.agibilibus.SIGET.model.Usuario;

public interface UserDAO extends MongoRepository<Usuario, String> {
	@Query("{ 'email' : ?0 }")
	Optional<Usuario> findByEmail(String email);

}
