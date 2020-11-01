package pasos;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;


import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsCrearReunion {

	    
    @Given("^Estoy autenticado como usuario /.*/ /.*/ /.*/$")
    public void estoy_autenticado_en_el_sistema(HttpSession httpSession, String userName, String pwd) throws Throwable{
    	Sesion.get().login(httpSession, userName, pwd);
    	
    	throw new PendingException();
    }
	@When("^Guardo una nueva reunion /.*/ /.*/ /.*/ /.*/ /.*/ /.*/ /.*/ /.*/$")
	public void guardar_esa_reunion (int idReunion, String titulo, String descripcion, DateTime horaInicio, DateTime horaFin, Usuario organizador, String[] asistentes, String url) throws Throwable{
		Reunion.get().guardarReunion(titulo, descripcion, horaInicio, horaFin, organizador, asistentes, url);
		throw new PendingException();
	}
	
	@Then("^Actualizo mi calendario con la nueva reunion$")
	public void actualizar_mi_calendario_con_la_nueva_reunion()  throws Throwable{
		//Manager.get().cargarCalendario();
	}
	

}
