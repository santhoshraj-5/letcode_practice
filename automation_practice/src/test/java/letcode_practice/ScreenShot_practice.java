package letcode_practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot_practice {

	public static void main(String[] args) throws InterruptedException, IOException {
		// set chromedriver location
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co =new ChromeOptions();
		//set testing chrome location 
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");//chrome added testing browser so we need to specify that 
	    //create object for chromedriver and add that chrome in parameters
		 WebDriver driver=new ChromeDriver(co);
		 //launch the site
		driver.get("https://letcode.in/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//take full page screen shot
		TakesScreenshot take_ss=(TakesScreenshot)driver;//we need getscreenshot method for taking ss so need to change the driver 
		File home_ss=take_ss.getScreenshotAs(OutputType.FILE);//we need to store as file type 
		File dest= new File("./Screenshots/image.png");// path where file need to be stored 
		FileHandler.copy(home_ss, dest);
		
		//select work space
		driver.findElement(By.linkText("Work-Space")).click();
		//take screen of a div
		WebElement divofworkspace = driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div"));
		
		/*File workspace_ss=divofworkspace.getScreenshotAs(OutputType.FILE);//we need to store as file type
		String path = "image1.png";
		File dest1= new File("./Screenshots/"+path);// path where file need to be stored 
		FileHandler.copy(workspace_ss, dest1);*/
		Take_screenshot(divofworkspace,"image1.png");
		
		//screen of an button 
		WebElement edit_btn_ss= driver.findElement(By.linkText("Edit"));
		Take_screenshot(edit_btn_ss,"editbutton.png");

	}
	//as we repeat same 3 lines for every screen shot we can create a method 
	public static void Take_screenshot(WebElement ele,String path) throws IOException {
		File Screenshot_done=ele.getScreenshotAs(OutputType.FILE);
		File destination =new File("./Screenshots/"+path);
		FileHandler.copy(Screenshot_done, destination);
		
	}

}
