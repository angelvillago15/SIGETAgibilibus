package com.agibilibus.SIGET.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.agibilibus.SIGET.model.Usuario;


public interface UserDAO extends MongoRepository <Usuario, String> {
}
