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



public class SeleniumRegistro {
	private WebDriver driver;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sigetagibilibus.herokuapp.com/Login.html");

	}

	@Test
	public void testRegisterPage() {
		WebDriverWait wait = new WebDriverWait(driver,1);;
		driver.get("https://sigetagibilibus.herokuapp.com/Register.html");

		WebElement dni = driver.findElement(By.id("userDni"));
		dni.sendKeys("70707070A");
		
		WebElement nombreCompleto = driver.findElement(By.id("userCompletName"));
		nombreCompleto.sendKeys("SeleniumRegister");
		
		WebElement apellidos = driver.findElement(By.id("userApellidos"));
		apellidos.sendKeys("Garcia Garcia");
		
		WebElement telefono = driver.findElement(By.id("userTelf"));
		telefono.sendKeys("655655655");
		
		WebElement fecha = driver.findElement(By.id("userDate"));
		fecha.sendKeys("06-12-1990");
		
		WebElement nombre  = driver.findElement(By.id("userName"));
		nombre.sendKeys("SeleniumRegister");
		
		WebElement pass = driver.findElement(By.id("pwd1"));
		pass.sendKeys("Seguridad2020");
		
		WebElement validarPass = driver.findElement(By.id("pwd2"));
		validarPass.sendKeys("Seguridad2020");
		
		WebElement mail = driver.findElement(By.id("userMail"));
		mail.sendKeys("register@register.com");
		
		WebElement validarMail = driver.findElement(By.id("mail2"));
		validarMail.sendKeys("register@register.com");
		
		WebElement boton = driver.findElement(By.id("register"));
		boton.click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		String textoAlerta = alert.getText();
		String textoEsperado = "Usuario registrado correctamente";


		assertEquals(textoAlerta, textoEsperado);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
