package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task_04 {
  WebDriver driver;
  @Test

  public void f() {
	  WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
  }
  @Test
  public void login() throws InterruptedException
  {
	  Thread.sleep(4000);
	  WebElement username = driver.findElement(By.name("username"));
	  username.sendKeys("Admin");
	  WebElement password = driver.findElement(By.name("password"));
	  password.sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String actualUrl = driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	 
  }
  
  @Test(dependsOnMethods="login")
  public void logout()throws InterruptedException{
	  
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	  Thread.sleep(4000);
	  driver.quit();
  }
}
