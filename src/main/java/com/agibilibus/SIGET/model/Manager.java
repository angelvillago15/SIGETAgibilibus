package com.agibilibus.SIGET.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.json.JSONArray;
import org.json.JSONException;

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
