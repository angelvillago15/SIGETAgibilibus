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

public class SeleniumLogin {

 private WebDriver driver;

 @Before
 public void setUp() {

  System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://sigetagibilibus.herokuapp.com/Login.html");

 }

 @Test
 public void testLoginPage() {

  WebElement nombreUsuario = driver.findElement(By.id("username"));
  WebElement contraseña = driver.findElement(By.id("pass"));
  WebElement btnLogin = driver.findElement(By.id("login"));

  nombreUsuario.clear();
  nombreUsuario.sendKeys("pilar");

  contraseña.clear();
  contraseña.sendKeys("Hola1234");

  btnLogin.click();

  String tituloEsperado = "Login";
  String tituloActual = driver.getTitle();

  assertEquals(tituloEsperado, tituloActual);

 }
 
 
}
