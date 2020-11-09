package pasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.agibilibus.SIGET.model.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsVisualizarCalendario {
	
	WebDriver driver;

	@Given("Estoy autenticado como usuario en el sistema")
	public void estoy_autenticado_como_usuario () {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/Login.html");
		driver.findElement(By.id("username")).sendKeys("hola");
		driver.findElement(By.id("pass")).sendKeys("aaa");
	}
	
	@And("Hago click en el boton de iniciar sesion")
	public void click_en_iniciar_sesion() {
		driver.findElement(By.id("login")).click();
	}
	
	@When("Entro a la pantalla de calendario semanal")
	public void visualizarCalendario() {
		driver.navigate().to("http://localhost:8080/UserCalendar.html");
	}
	
	@Then("Veo mis reuniones de la semana")
	public void cargarReuniones(Usuario u) {
		String nombreReunion = driver.findElement(By.className("fc-event-title fc-sticky")).getText();
		//Assert.assertEquals(nombreReunion, "Bojack Horseman");
		Assert.assertEquals(nombreReunion, "sdfsdfsd");
	}
	
}