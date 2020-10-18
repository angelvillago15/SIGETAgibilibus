package com.agibilibus.SIGET.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agibilibus.SIGET.model.Reunion;

public interface ReunionDAO extends MongoRepository <Reunion, String> {

}
