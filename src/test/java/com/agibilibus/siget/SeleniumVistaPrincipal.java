package com.agibilibus.siget;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumVistaPrincipal {

	private WebDriver driver;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sigetagibilibus.herokuapp.com/Login.html");

		WebElement nombreUsuario = driver.findElement(By.id("username"));
		  WebElement contraseña = driver.findElement(By.id("pass"));
		  WebElement btnLogin = driver.findElement(By.id("login"));

		  nombreUsuario.clear();
		  nombreUsuario.sendKeys("Elisa");

		  contraseña.clear();
		  contraseña.sendKeys("Seguridad2020");

		  btnLogin.click();


	}

	@Test
	 public void testPrincipalPage() {
			//WebElement menu = driver.findElement(By.id("menu"));
			WebElement menu = driver.findElement(By.xpath("//div[@id='main']/span"));
			menu.click();
			
			WebElement evento = driver.findElement(By.linkText("Nuevo Evento"));
			evento.click();
			
			String urlEsperada = "https://sigetagibilibus.herokuapp.com/newEvent.html";
			String urlActual = driver.getCurrentUrl();
			
			assertEquals(urlEsperada, urlActual);
			
			WebElement logo = driver.findElement(By.linkText("logo"));
			logo.click();
			
			
			WebElement nosotros = driver.findElement(By.linkText("Sobre Nosotros"));
			nosotros.click();
			
			String urlEsperada2 = "https://sigetagibilibus.herokuapp.com/AboutUs.html";
			String urlActual2 = driver.getCurrentUrl();
			
			assertEquals(urlEsperada2, urlActual2);
	 }

	 @After
	 public void tearDown() {
	  // driver.quit();
	 }

}
