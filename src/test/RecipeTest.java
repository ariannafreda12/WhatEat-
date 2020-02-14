package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecipeTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://localhost:8078/WhatEatWWW/index.html");

		
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/input[1]")).sendKeys("arianna");
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/input[2]")).sendKeys("arianna");
		driver.findElement(By.xpath("//*[@id=\"sec-f5dc\"]/div/div/div/form[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"sec-3dad\"]/div/div/div/div/div[1]/div/div/div/div[1]/div/table/tbody/tr[2]/td[1]/input")).click();
		String title= driver.findElement(By.xpath("//*[@id=\"sec-c349\"]/div/div/div/label")).getText();
		System.out.println("Popular recipe's title: " + title);
		
		
		driver.close();
	
	}

}
