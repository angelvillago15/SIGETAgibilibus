package com.agibilibus.siget.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agibilibus.siget.model.Invitacion;

public interface InvitacionDAO extends MongoRepository <Invitacion, String>{

}
