package TestNG_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_annotation_practice {
	@Parameters({"emailId","password","browser"})//here the name should be same as name we given inxml file
	@Test
	public void login(String email,String pass,String browser)//here the name can be any but the order should be same
	{
		WebDriver driver = null;//inside method we should compulsory initialize the variable or put outside the method
		
		//from xml file we run 2 type of test according to our child test brower data this switch statement will fix our driver
		switch (browser) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			System.err.println("un-defined driver");
			break;
		}
		  driver.get("https://letcode.in/signin");
		  driver.findElement(By.name("email")).sendKeys(email,Keys.TAB,pass);
		  driver.findElement(By.tagName("button")).click();
		 
	}

}
