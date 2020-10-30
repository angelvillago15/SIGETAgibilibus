package pasos;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepRegistrarUsuario {
	@Given("^Los campos estan vacios$")
	public void comprobarCampo () {
		Manager.get().comprobarCampos();
	}



	

}
