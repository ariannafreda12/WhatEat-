package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestRecipeLikeSelenium {

	@Test
	void testLikeRecipe() {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://localhost:8078/WhatEatWWW/index.html");

		
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/input[1]")).sendKeys("arianna");
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/input[2]")).sendKeys("arianna");
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/button")).click();
		
		String like= driver.findElement(By.xpath("//*[@id=\"sec-3dad\"]/div/div/div/div/div[1]/div/div/div/div[1]/div/table/tbody/tr[2]/td[2]")).getText();
		assertEquals("300013", like);
		System.out.println("Popular recipe's like: " + like);
		
		
		driver.close();
	}

}
