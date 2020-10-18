package com.agibilibus.SIGET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;


@SpringBootApplication
public class SigetApplication implements CommandLineRunner{
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	ReunionDAO reuniondao;

	public static void main(String[] args) {
		SpringApplication.run(SigetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//reuniondao.save(new Reunion(1,"Bienvenida", "Reunión de bienvenida", "23/10/2020", "12:00", "13:00",userdao.findById("carlos").get(),userdao.findAll(),"hola.com"));
		//userdao.save(new Usuario("carlos", "aaa", "Carlos", "Rivas", 666, "a@a.com", "062x","10/05/1997", "admin"));
	}

}
