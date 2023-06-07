package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task_01 {
  @Test
  public void verifyTitle() {
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver = new EdgeDriver();
	  driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle,"Guest Registration Form – User Registration" );
	  
  }
}
