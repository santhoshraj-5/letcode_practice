package letcode_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frame_practice {

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
				//click frame button
				driver.findElement(By.linkText("Inner HTML")).click();
				
				//jump to frame 
				//driver.switchTo().frame(0);//this is index method
				//driver.switchTo().frame("firstFr");//this is name or id method 
				WebElement frame1=driver.findElement(By.id("firstFr"));
				driver.switchTo().frame(frame1);//this is webelement method
				driver.findElement(By.name("fname")).sendKeys("santhosh");
				driver.findElement(By.name("lname")).sendKeys("Raj");
				Thread.sleep(1000);
				
				//jump to inner inner frame
				driver.switchTo().frame(1);//only one fame is visible from current frame
//				WebElement frame2=driver.findElement(By.className("has-background-white"));
//				driver.switchTo().frame(frame2);
				driver.findElement(By.name("email")).sendKeys("santa");
				Thread.sleep(1000);
				
				//jumping out of frame 
				driver.switchTo().parentFrame();//jump just parent of current frame
				driver.findElement(By.name("lname")).sendKeys("Raj .v");
				Thread.sleep(1000);
				
				//jump to the main frame
				driver.switchTo().defaultContent();
				driver.findElement(By.linkText("Watch tutorial")).click();
				
	}

}
