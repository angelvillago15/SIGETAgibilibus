package com.agibilibus.siget.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agibilibus.siget.model.Reunion;

public interface ReunionDAO extends MongoRepository <Reunion, String> {

}
