package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestLoginSelenium {


	@Test
	void testlogin() {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8078/WhatEatWWW/index.html");
		
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/input[1]")).sendKeys("arianna");
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/input[2]")).sendKeys("arianna");
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/button")).click();
		String user = driver.findElement(By.xpath("//*[@id=\"sec-5feb\"]/label")).getText();
		
		assertEquals("Hi arianna", user);
		System.out.println("Welcome message: " + user);

		driver.close();
		
	}

}
