package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestDRecipeSelenium {


	@Test
	void testDailyRecipe() {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8078/WhatEatWWW/index.html");
		
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[2]/input")).click();
		
		String daily = driver.findElement(By.xpath("//*[@id=\"sec-3dad\"]/div/div/div/div/div[2]/div/div/div/label")).getText();
		assertEquals("Try daily recipe", daily);
		

		driver.close();
	}

}
