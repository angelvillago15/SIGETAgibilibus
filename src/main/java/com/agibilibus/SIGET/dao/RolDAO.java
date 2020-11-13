package com.agibilibus.SIGET.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.agibilibus.SIGET.model.Rol;

public interface RolDAO extends MongoRepository<Rol, String> {

}
