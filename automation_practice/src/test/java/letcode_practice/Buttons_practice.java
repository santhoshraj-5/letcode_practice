package letcode_practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buttons_practice {

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
		Thread.sleep(1000);


		//go to buttons section 
		driver.findElement(By.linkText("Click")).click();
		Thread.sleep(1000);


		//now click the home page tab 
		driver.findElement(By.id("home")).click();
		//now check the current url and confirm its home page 
		String home_url =driver.getCurrentUrl(); System.out.println(home_url); Thread.sleep(1000);

		//now use navigate to access back button in header 
		driver.navigate().back();
		//driver.navigate().forward(); 
		//now check the back is worked and button url is got
		String button_url = driver.getCurrentUrl();
		System.out.println(button_url); Thread.sleep(1000);

		//Get the X & Y co-ordinates 
		WebElement Location_btn = driver.findElement(By.id("position"));
		//Webelement data type is element
		Point point= Location_btn.getLocation();
		//getlocation ve x y loaction and point is the data type it will give
		int x=point.getX(); int y=point.getY();
		System.out.println("x value "+x+" y value "+y); Thread.sleep(1000);

		//find color of the button 
		WebElement Color_btn =driver.findElement(By.id("color")); 
		String color= Color_btn.getCssValue("background-color");
		//only color value is text color bg clr is only the tab clr
		System.out.println(color); Thread.sleep(1000);

		//Find the height & width of the button 
		Rectangle rect=driver.findElement(By.id("property")).getRect(); 
		Dimension dim =rect.getDimension(); int height =dim.getHeight(); int width =dim.getWidth();
		rect.getPoint();
		System.out.println("dimension - "+dim+",height - "+height+",width - "+width);

		//without dimension also we can get height and width
		System.out.println("with out using dimension method height "+rect.getHeight());
		System.out.println("with out using dimension method width "+rect.getWidth());

		//check button is editable
		Boolean Disable_btn=driver.findElement(By.id("isDisabled")).isEnabled();
		System.out.println("is the button is intractable - "+Disable_btn);

		//long press the button so we need action class
		Actions builder=new Actions(driver);
		WebElement hold_button=driver.findElement(By.xpath("//div[@class='card-content']//div[6]//div[1]//button[1]"));
		//first get the text we use that in the wait
		String text=hold_button.getText();
		builder.clickAndHold(hold_button).perform();
		//wait function
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@class='card-content']//div[6]//div[1]//button[1]"), text));

		String expected=hold_button.getText();
		System.out.println(expected);

	}

}
