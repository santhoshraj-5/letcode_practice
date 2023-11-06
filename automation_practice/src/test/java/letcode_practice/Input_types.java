package letcode_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Input_types {

	public static void main(String[] args) throws InterruptedException {
		// set chromedriver location
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co =new ChromeOptions();
		//set testing chrome location 
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");//chrome added testing browser so we need to specify that 
	    //create object for chromedriver and add that chrome in parameters
		 WebDriver driver=new ChromeDriver(co);
		 //launch the site
		driver.get("https://letcode.in/");
		//click workspace header
		driver.findElement(By.linkText("Work-Space")).click();
		//maximize 
		driver.manage().window().maximize();
		//select input tab
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(1000);
		//enter fullname 
		driver.findElement(By.id("fullName")).sendKeys("Santhosh Raj");
		Thread.sleep(1000);
		//add text and press tab key 
		driver.findElement(By.id("join")).sendKeys("Boy",Keys.TAB);
		Thread.sleep(1000);
		//get what text inside in tab
		String get_text =driver.findElement(By.id("getMe")).getAttribute("value");
		//print the value
		System.out.println(get_text);
		//clear text 
		driver.findElement(By.id("clearMe")).clear();
		Thread.sleep(1000);
		//noedit
		Boolean edit_option=  driver.findElement(By.id("noEdit")).isEnabled();
		System.out.println("is the tab is editable - "+edit_option);
		Thread.sleep(1000);
		//check the tab is only readable
		String is_readableonly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println("this tab is only readable - "+is_readableonly);
		}

}
