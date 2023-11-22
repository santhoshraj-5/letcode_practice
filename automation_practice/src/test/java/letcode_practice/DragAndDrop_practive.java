package letcode_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop_practive {

	public static void main(String[] args) throws InterruptedException {
		// set chromedriver location
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
		//click drop button
		driver.findElement(By.linkText("AUI - 2")).click();
		
		//get source object to move
		WebElement source =driver.findElement(By.id("draggable"));
		//getthe target to place 
		WebElement target = driver.findElement(By.id("droppable"));
		
		//to perform actions we need action interface 
		Actions builder=new Actions(driver);//always pass the driver object in the constructor
//		builder.scrollToElement(target).perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		//know access the method inside the action interface
		builder.dragAndDrop(source, target).perform();//perform method is important to run
		System.out.println(target.getText());//we can also validate buy getting the text and compare it if its is same then test case is pass
	}

}
