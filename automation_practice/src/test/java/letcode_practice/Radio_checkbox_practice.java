package letcode_practice;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Radio_checkbox_practice {

	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
			co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
			WebDriver driver= new ChromeDriver(co);
			driver.manage().window().maximize();
			//launch the site
			driver.get("https://letcode.in/");
			
			//click workspace header
			driver.findElement(By.linkText("Work-Space")).click();
			Thread.sleep(1000);
			//click frame button
			driver.findElement(By.linkText("Toggle")).click();
			
			//select any one radio button
			driver.findElement(By.id("yes")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("no")).click();
			
			//Confirm you can select only one radio button
			WebElement yes_button=driver.findElement(By.id("one"));
			WebElement no_button=driver.findElement(By.id("two"));
			yes_button.click();
			no_button.click();
			boolean yes_selected=yes_button.isSelected();
			boolean no_selected=no_button.isSelected();
			if(yes_selected!=no_selected) {
				System.out.println("only one is selected");
			}
			else{System.out.println("both is selected");
			}
			//sidfjoewiofiwe

		}
	}



