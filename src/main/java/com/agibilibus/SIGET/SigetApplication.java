package com.agibilibus.SIGET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agibilibus.SIGET.dao.UserDAO;
import com.agibilibus.SIGET.model.Usuario;


@SpringBootApplication
public class SigetApplication implements CommandLineRunner{
	
	@Autowired
	UserDAO userdao;

	public static void main(String[] args) {
		SpringApplication.run(SigetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//userdao.save(new Usuario("carlos", "aaa", "Carlos", "Rivas", 666, "a@a.com", "062x","10/05/1997", "admin"));
	}

}
