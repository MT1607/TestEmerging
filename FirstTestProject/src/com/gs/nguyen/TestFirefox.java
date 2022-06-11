package com.gs.nguyen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFirefox {
  public String baseUrl = "https://galaxyplay.vn/";
  String driverPath = "D:\\WebDriver\\geckodriver.exe";
  public WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get(baseUrl);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  @Test
  public void titleGalaxy() {
	  String title = driver.getTitle();
	  String resultTitle = "Galaxy Play - Phim hay, Xem ngay!";
	  Assert.assertEquals(title, resultTitle);
  }
  
  @Test
  public void KhoPhim() {
	  String khophim = "Kho Phim";
	  String reString = driver.findElement(By.xpath("//*[@id=\"navbar-glx\"]/li[2]/a")).getText();
	  Assert.assertEquals(khophim, reString);
  }
}
