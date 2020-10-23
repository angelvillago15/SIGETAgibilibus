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
		this.day = Calendar.DAY_OF_WEEK;
		this.semana = 0;
	}
	/**
	 * El JSONArray contiene 7 JSON Object uno por cada dia de la semana de lunes a domingo
	 * Los JSONObject contienen:
	 *  - un campo "fecha" con un objeto Date del dia
	 *  - un cambo "reuniones" con un JSONArray de JSONObjects que corresponden a las reuniones
	 * */
	public JSONArray getSemana(Usuario user) {
		this.semana = 0;
		return getSemana(0,user);
	}
	public JSONArray getSemanaSiguiente(Usuario user) {
		return getSemana(++this.semana,user);
	}
	public JSONArray getSemanaAnterior(Usuario user) {
		return getSemana(--this.semana,user);
	}

	private List<Date> getDates(int semana) {
		
		List<Date> result = new LinkedList<>();
		semana *= 7;
		
		for(int i=2;i<9;i++) {
			Calendar c = Calendar.getInstance();
			c.setFirstDayOfWeek(Calendar.SUNDAY); //Si empieza en lunes lo quitamos
			c.add(Calendar.DAY_OF_YEAR,semana+i-day );
			result.add(c.getTime());
		}
		return result;
	}
	private JSONObject getReuniones(Date dia,Usuario user) {
		JSONObject jso = new JSONObject();
		JSONArray jsa = new JSONArray();
		
		jso.put("fecha", dia);
		jso.put("reuniones", jsa);
		return jso;
	}
	private JSONArray getSemana(int semana,Usuario user) {
		JSONArray jsa = new JSONArray();
		List<Date> ls = getDates(semana);
		for(Date d : ls)
			jsa.put(getReuniones(d,user));
		return jsa;
	}
}
