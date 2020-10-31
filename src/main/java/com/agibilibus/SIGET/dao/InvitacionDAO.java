package com.agibilibus.SIGET.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agibilibus.SIGET.model.Invitacion;

public interface InvitacionDAO extends MongoRepository <Invitacion, String>{

}
