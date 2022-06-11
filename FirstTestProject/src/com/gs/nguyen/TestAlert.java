package com.gs.nguyen;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestAlert {
	  public String baseUrl= "https://output.jsbin.com/enifaf";
	  String driverPath = "D:\\WebDriver\\chromedriver.exe";
	  public WebDriver driver ;

	  @BeforeClass
	  public void setupClass() {
		  System.setProperty("webdriver.chrome.driver", driverPath);
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();  
	  }
	  @Test
	  public void testTextAlert() {
		  
		  //Check text alert
		  driver.findElement(By.xpath("/html/body/button")).click();
		  Alert alert = driver.switchTo().alert();
		  String alertMessage = alert.getText();  
		  String message = "Press a button!";
		  Assert.assertEquals(alertMessage, message);
		  
	  }	  
	  
	  @Test
	  public void TestOk() {
		//Check Press OK and text alert
		  driver.findElement(By.xpath("/html/body/button")).click();
		  Alert alertOK = driver.switchTo().alert();
		  alertOK.accept();
		  String pressOk = driver.findElement(By.id("chosenButton")).getText();
		  String TextOK = "You pressed OK!";
		  Assert.assertEquals(pressOk, TextOK);
	  }
	  @Test
	  public void TestCancel() {
		//Check Press Cancel
		  driver.findElement(By.xpath("/html/body/button")).click();
		  Alert alertCancel = driver.switchTo().alert();
		  alertCancel.dismiss();
		  String pressCancel = driver.findElement(By.id("chosenButton")).getText();
		  
		  String TextCancel = "You pressed Cancel!";
		  Assert.assertEquals(pressCancel, TextCancel);
		  
	  }
  

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
