package com.agibilibus.SIGET.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Manager {


	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	private static class ManagerHolder {
		static Manager singleton = new Manager();
	}

	private Manager() {

	}


}
