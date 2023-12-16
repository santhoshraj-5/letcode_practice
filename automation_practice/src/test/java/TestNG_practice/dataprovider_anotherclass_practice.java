package TestNG_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class dataprovider_anotherclass_practice //extends Dataprovider_practice this is one way
{
	@Test(dataProvider = "login",dataProviderClass = Dataprovider_practice.class)
	public void login(String email,String password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co= new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://letcode.in/signin");
		driver.findElement(By.name("email")).sendKeys(email,Keys.TAB,password);
		driver.findElement(By.tagName("button")).click();
		System.out.println(driver.getTitle());
	} 
}
