package dataprovider_with_xlfile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class Testclass {
	@Test(dataProvider="login",dataProviderClass =Xl_data.class )
	public void login(String data[]) {
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co= new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://letcode.in/signin");
		driver.findElement(By.name("email")).sendKeys(data[0],Keys.TAB,data[1]);
		driver.findElement(By.tagName("button")).click();
		System.out.println(driver.getTitle());
	} 
}
 