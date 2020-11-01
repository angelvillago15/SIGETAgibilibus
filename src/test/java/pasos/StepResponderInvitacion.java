package pasos;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.agibilibus.SIGET.model.Invitacion;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Sesion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepResponderInvitacion {

	@Given("^Estoy autenticado como usuario /.*/ /.*/ /.*/$")
    public void estoy_autenticado_en_el_sistema(HttpSession httpSession, String userName, String pwd) throws Throwable{
    	Sesion.get().login(httpSession, userName, pwd);
    	
    	throw new PendingException();
    }
	
	@Then("^Respondo a la reunion /.*/ /.*/$")
	public void responder_invitacion(Reunion reunion, Usuario asistente) throws Throwable{
		Invitacion.get().responderInvitacion(reunion, asistente);
		
		throw new PendingException();
	}
}
