package letcode_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Navigation_practice {

	public static void main(String[] args) throws InterruptedException {
		// set chromedriver location
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co =new ChromeOptions();
		//set testing chrome location 
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");//chrome added testing browser so we need to specify that 
	    //create object for chromedriver and add that chrome in parameters
		 WebDriver driver=new ChromeDriver(co);
		 //launch the site
		driver.navigate().to("https://letcode.in/buttons");
		/*this is same as GET method ,actually if we look in to 
		the code of navigation the get is called inside of to method*/
		Thread.sleep(1000);
		
		//now click the home page tab
		driver.findElement(By.id("home")).click();
		//now check the current url and confirm its home page
		String home_url = driver.getCurrentUrl();
		System.out.println(home_url);
		Thread.sleep(1000);

		//now use navogate to access back button in header
		driver.navigate().back();
		//driver.navigate().forward();
		//now check the back is worked and button url is got
		String button_url = driver.getCurrentUrl();
		System.out.println(button_url);
		Thread.sleep(1000);

		//refresh the current page
		driver.navigate().refresh();
		
		/*we can store the navigation method in navigation variable 
		 * and can be accessed easily by calling the variable 
		 */
        /* Navigation nav= driver.navigate();
         nav.refresh();
         nav.back();
         nav.forward();*/
	}

}
