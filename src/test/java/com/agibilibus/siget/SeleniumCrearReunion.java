package com.agibilibus.siget;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCrearReunion {

 private WebDriver driver;

 @Before
 public void setUp() {

  System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://sigetagibilibus.herokuapp.com/newEvent.html");

 }

 @Test
 public void testCrearReunion() {
  WebElement nReunion = driver.findElement(By.id("nombreReunion"));
  WebElement url = driver.findElement(By.id("url"));
  WebElement Fecha = driver.findElement(By.id("fecha"));
  WebElement invitar = driver.findElement(By.id("invitar"));
  WebElement hInicio = driver.findElement(By.name("horaInicio"));
  WebElement hFin = driver.findElement(By.name("horaFin"));
  WebElement descripcion = driver.findElement(By.id("descripcion"));
  WebElement btnCrear = driver.findElement(By.id("crear"));

  nReunion.sendKeys("Selenium");
  url.sendKeys("https://sonarcloud.io/organizations/agibilibus/projects");
  Fecha.sendKeys("30/12/2020");
  invitar.sendKeys("cristina@gmail.com");
  hInicio.sendKeys("15:20");
  hFin.sendKeys("16:40");
  descripcion.sendKeys("Es una reunion de prueba");

  btnCrear.click();

  String expectedUrl = "https://sigetagibilibus.herokuapp.com/Login.html";
  String actualUrl = driver.getCurrentUrl();

  assertEquals(actualUrl, expectedUrl);

 }

 @After
 public void tearDown() {
  driver.quit();
 }
}
