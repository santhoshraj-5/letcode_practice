package TestNG_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_practice {//this data are dummy it wont work
	
	@DataProvider(name="login")//indices = {0} this indices will pass only first row data
	public String[][] getdata() {
		//this data provider will run only if we have 2d array data
		String[][] data=new String[2][2];
		
		data[0][0]="santhoshraj532000@gmail.com";
		data[0][1]="Santhoshraj@5";
		
		data[1][0]="santhoshraj532000@gmail.com";//i dont have athother data so used same
		data[1][1]="Santhoshraj@5";
		
		return data;
	}
	
	@Test(dataProvider = "login")//its like dependsonmethod attribute  
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
