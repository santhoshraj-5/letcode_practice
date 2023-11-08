package letcode_practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alert_practice {

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
		//click dailog button
		driver.findElement(By.linkText("Dialog")).click();

		//click simple alert
		driver.findElement(By.id("accept")).click();
		//jump to alert popup
		Alert SImple_alert_popup=driver.switchTo().alert();
		//get text in the popup
		String smp_text=SImple_alert_popup.getText();
		System.out.println("the text we got in simple alert is - "+smp_text);
		//click the ok button in alert popup
		SImple_alert_popup.accept();
		//as we only have ok button dismiss method also will work
		//SImple_alert_popup.dismiss();

		//confirm alert popup
		driver.findElement(By.id("confirm")).click();
		Alert confirm_alert_popup=driver.switchTo().alert();
		//get text in the popup
		String confirm_text=SImple_alert_popup.getText();
		System.out.println("the text we got in confirm alert is - "+confirm_text);
		//click the ok button in alert popup
		confirm_alert_popup.accept();

		//prompt alert
		driver.findElement(By.id("prompt")).click();
		Alert prompt_alert_popup=driver.switchTo().alert();
		prompt_alert_popup.sendKeys("santhosh raj");//this will not be visible in the popup
		prompt_alert_popup.accept();
		//prompt_alert_popup.dismiss();
		Thread.sleep(2000);
		//sweet alert
		//					driver.findElement(By.id("modern")).click();
		//					Alert sweet_alert_popuop=driver.switchTo().alert();
		//					sweet_alert_popuop.accept();



	}

}
