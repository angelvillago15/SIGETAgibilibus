package com.agibilibus.SIGET;


import java.sql.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

import com.agibilibus.SIGET.model.Calendario;

public class Pruebas {
	public static void main(String[] args) {
		
		Calendario c = new Calendario();
		
			
		System.out.println(toString(c.getSemanaAnterior()));
		
		System.out.println(toString(c.getSemana()));
		
		System.out.println(toString(c.getSemanaSiguiente()));
		
	}

	public static String toString(JSONArray jsa) {
		String txt ="";
		
		Iterator<Object> it = jsa.iterator();
		while(it.hasNext()) {
			JSONObject obj = (JSONObject) it.next();
			txt += obj.get("fecha").toString()+"\n";
			//Date date =  (Date) obj.get("fecha");
			//txt +="Date:"+ date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900) +"\n";
		}
		
		return txt;
	}

}
