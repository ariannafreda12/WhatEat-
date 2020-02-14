package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8078/WhatEatWWW/index.html");
		
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[2]/input[1]")).click();
		
		String title = driver.findElement(By.xpath("//*[@id=\"sec-3dad\"]/div/div/div/div/div[2]/div/div/div/div/div/h6")).getText();
		
		System.out.println("Daily recipe: " + title);

		driver.close();
		
	}
	
	

}
