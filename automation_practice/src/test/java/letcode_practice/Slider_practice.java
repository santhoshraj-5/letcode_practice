package letcode_practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Slider_practice {

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
		//click slider button
		driver.findElement(By.linkText("AUI - 5")).click();
		
		WebElement slider=driver.findElement(By.id("generate"));
		 Actions builder=new Actions(driver);
		
		//int offset_random=(int) Math.random(); min + (int)(Math.random() * (max - min));exclusive of max num
		 //now we need to generate a random num for the offset vale we already know the min max value of slider
		Random rand=new Random();
		int off_min=-300;
		int off_max= 300;
		
		//same formula can be used in math.random() also for limited random num generation
		int offset_random= off_min + rand.nextInt((off_max - off_min) + 1);
		
		//to make intresting we randomly generated the offset value
		 builder.dragAndDropBy(slider, offset_random, 0).perform();//-300=1,-10=25,0=26,300=50
		 
		 //click Get Countries
		 driver.findElement(By.tagName("button")).click();
		 
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Word limit ')]")).getText());
		
		 
		String List_of_country=driver.findElement(By.xpath("//p[@class='has-text-primary-light']")).getText();
		
		String[] split_country=List_of_country.split("[-,]");
		for(String country: split_country) {
			System.out.println(country);
		}
		

	}

}
