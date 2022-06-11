package com.gs.nguyen;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
;

public class NewTest {
	public String baseUrl = "https://mlearning.hoasen.edu.vn/";
	String driverPath = "D:\\WebDriver\\chromedriver.exe";
	public WebDriver driver ; 
  
  @BeforeTest
  public void setupTest() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }
  
  @Test
  public void TestUser(){
	  
      driver.findElement(By.xpath("//*[@id=\"inputName\"]")).sendKeys("son.ng4973@sinhvien.hoasen.edu.vn");
      driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("G.son262318");
      driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
      driver.navigate().forward();
      String actualTitle = driver.findElement(By.xpath("//*[@id=\"action-menu-toggle-0\"]/span/span[1]"))
    		  .getText();
      String expectedTitle = "Nguyễn Gia Sơn";
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.quit();
  }
}
