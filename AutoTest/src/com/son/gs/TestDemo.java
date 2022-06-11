package com.son.gs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// Input Url and data
		String baseUrl = sc.nextLine();
		String username = sc.nextLine();
		String password = sc.nextLine();		
		String actitle = "Dashboard";

		//Load driver
		System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		if(baseUrl.length()>5) {
			//Run Url
			driver.get(baseUrl);
			driver.manage().window().maximize();
			driver.findElement(By.id("inputName")).sendKeys(username);
	        driver.findElement(By.id("inputPassword")).sendKeys(password);
	        driver.findElement(By.id("submit")).click();
	        driver.navigate().forward();
	        String title = driver.getTitle();
//	        System.out.println(title);
	        if(title.equals(actitle)) {
	        	String name = driver.findElement(By.xpath("//*[@id=\"action-menu-toggle-0\"]/span/span[1]")).getText();
	        	System.out.println(name);
	        }else {
	        	System.out.println("User or pass incorrect");
	        }
	        driver.quit();
		}else {
			System.out.println("baseUrl is not found");
			driver.quit();
		}

	}

}
