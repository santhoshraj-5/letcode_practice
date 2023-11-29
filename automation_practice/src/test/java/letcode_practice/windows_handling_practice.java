package letcode_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class windows_handling_practice {

	public static void main(String[] args) {
		//setup chrome
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions co=new ChromeOptions();
				co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
				WebDriver driver= new ChromeDriver(co);
				
				driver.get("https://letcode.in/windows");
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				driver.findElement(By.id("home")).click();
				System.out.println("after clicking home button url-"+driver.getCurrentUrl()); 
				
				//there are 2 ways we can switch tab 
				
				//1 
				Set<String> AllTabs=driver.getWindowHandles();
				//we dont have get method in list 
				List<String> list=new ArrayList<String>(AllTabs);
				//herewe have only 2 tab so if we have count we can give -1 and easly get 
				int tabs_count= list.size();
				if(tabs_count>1) {
					//this will switch the tsb 
					driver.switchTo().window(list.get(tabs_count-1));
				}
				//after switching to second tab we need to verify
				System.out.println("after changing windows -"+driver.getCurrentUrl());
				System.out.println("title of the current page -"+driver.getTitle());
				
				
				//2
				//Get all the handles currently available
				/*Set<String> handles=driver.getWindowHandles();
				for(String actual: handles) {
				if(!actual.equalsIgnoreCase(currentHandle)) {
				//Switch to the opened tab
				driver.switchTo().window(actual); */
				
				//to close current tab 
				driver.close();
				//after this we need to swit to current tab or else we get nosuchwindow exception
				driver.switchTo().window(list.get(0));
				System.out.println("title of the current page after closing one tab -"+driver.getTitle());
				
				
				//now open multiple window and get all window title
				driver.findElement(By.id("multi")).click();
				driver.findElement(By.id("multi")).click();
				
				Set<String> multi_tab_windows = driver.getWindowHandles();
				String current_s_tab=driver.getWindowHandle();
				for (String currenttab : multi_tab_windows) {
					if(!currenttab.equalsIgnoreCase(current_s_tab)) {
						driver.switchTo().window(currenttab);
						System.out.println(driver.getTitle());
						System.out.println(driver.getCurrentUrl());
						current_s_tab=currenttab;
					}
					
				}

	}

}
