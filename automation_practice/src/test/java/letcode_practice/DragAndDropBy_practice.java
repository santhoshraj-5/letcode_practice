package letcode_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy_practice {

	public static void main(String[] args) throws InterruptedException {//this is same as dragand drop but here we will give specified location 
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
				//click drag button
				driver.findElement(By.linkText("AUI - 1")).click();
				
				//select the drag object
				WebElement source = driver.findElement(By.id("sample-box"));
				
				//creat an action interface object
				Actions builder=new Actions(driver);
				
				//get location of the outer box
				//WebElement outer_box=driver.findElement(By.className("example-boundary"));
				int x=source.getLocation().getX();
				int y=source.getLocation().getY();
				System.out.println(x);
				System.out.println(y);
				Thread.sleep(2000);
				//builder.moveToElement(source).perform();
				builder.moveToElement(source).doubleClick(source).dragAndDropBy(source,50,50).build().perform();
				//builder.release(source);.release(source)

	}

}
