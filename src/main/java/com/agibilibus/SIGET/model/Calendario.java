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
	public JSONObject getSemana(Usuario user) {
		this.semana = 0;
		return getSemana(0,user);
	}
	public JSONObject getSemanaSiguiente(Usuario user) {
		return getSemana(++this.semana,user);
	}
	public JSONObject getSemanaAnterior(Usuario user) {
		return getSemana(--this.semana,user);
	}

	private List<Date> getDates(int semana) {
		
		List<Date> result = new LinkedList<>();
		semana *= 7;
		
		for(int i=2;i<9;i++) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_YEAR,semana+i-day+1 );
			result.add(c.getTime());
		}
		return result;
	}
	private JSONArray getReuniones(Date dia,Usuario user) {
		JSONArray jsa = new JSONArray();
		return jsa;
	}
	@SuppressWarnings("deprecation")
	private JSONObject getSemana(int semana,Usuario user) {
		
		JSONObject jso = new JSONObject();
		
		List<Date> ls = getDates(semana);
		int i = 0;
		for(Date d : ls) {
			
			jso.put("d"+i, d.getDate()+"/"+(d.getMonth()+1));
			jso.put("ls"+i,getReuniones(d,user));
			i++;
		}
			
		return jso;
	}
}