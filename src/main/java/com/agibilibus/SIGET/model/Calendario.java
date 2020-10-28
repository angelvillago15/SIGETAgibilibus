package com.agibilibus.SIGET.model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Calendario {
	private int day;
	private int semana;
	
	public Calendario () {
		Calendar today = Calendar.getInstance();
		today.setFirstDayOfWeek(Calendar.MONDAY);
		this.day = today.DAY_OF_WEEK;
		this.semana = 0;			
	}
	private JSONArray getReuniones(Date dia,Usuario user) {
		JSONArray jsa = new JSONArray();
		return jsa;
	}
	
}