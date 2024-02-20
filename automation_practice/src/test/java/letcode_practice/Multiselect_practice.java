package letcode_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Multiselect_practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co =new ChromeOptions();
		//set testing chrome location 
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");//chrome added testing browser so we need to specify that 
		//create object for chromedriver and add that chrome in parameters
		WebDriver driver=new ChromeDriver(co);
		//maximize the tab
		driver.manage().window().maximize();
		//launch the site
		driver.get("https://letcode.in/");
		//click workspace header
		driver.findElement(By.linkText("Work-Space")).click();
		Thread.sleep(1000);
		//click drag button
		driver.findElement(By.linkText("AUI - 4")).click();
		
		/*
		 * WebElement
		 * selenium_bt=driver.findElement(By.xpath("//h3[text()='Selenium']/parent::div"
		 * ));// WebElement protractor_bt=driver.findElement(By.xpath(
		 * "//h3[text()='Protractor']/parent::div"));
		 * 
		 * Actions builder=new Actions(driver);
		 * builder.keyDown(Keys.LEFT_CONTROL).click(protractor_bt).click(selenium_bt).
		 * build().perform();
		 */
		Actions builder=new Actions(driver);
		 
		  WebElement total_out=driver.findElement(By.cssSelector("#container"));
		 List<WebElement> select_list=total_out.findElements(By.tagName("div"));
		 for(WebElement each_select : select_list) {
			 String xpath=each_select.getText();
			 WebElement button=driver.findElement(By.xpath("//h3[text()='"+xpath+"']/parent::div"));//
			 builder.keyDown(Keys.LEFT_CONTROL).click(button).perform();
		 }

	}

}
