package TestNG_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class checkbox_table_practice {
@Test
//dont give function name same as class name 
	public void checkbox_table() {
		System.setProperty("Webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://letcode.in/table");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//track the table
		WebElement table=driver.findElement(By.id("simpletable"));
		//select the rows in the body of the table
		List<WebElement>table_allrows=table.findElements(By.cssSelector("tbody tr"));
		//we get list of rows 0 1 2 in 0 we have 4 column 
		for (WebElement rows_s : table_allrows) {
			System.out.println(rows_s.getText());
		}
		
		//how many rows 
		int size=table_allrows.size();
		System.out.println(size);
		//in foreach we cant user get method
		for(int i=0;i<size;i++) {
			//the size is 3 we go one by one in 0 we go td 1 2 3
			List<WebElement> rows=table_allrows.get(i). findElements(By.tagName("td"));
			//now we are in the table i row so we need lastname which index is 1 so used get method
			String last_name=rows.get(1).getText();
			System.out.println(last_name);
			//we know if the lastname is raj we need to click present check box
			if(last_name.equalsIgnoreCase("raj")) {
				//curent we will be in i row so in that we go our condition so in same row we need to jump 3rd index
				rows.get(3).findElement(By.tagName("input")).click();
				break;
			}
		}
	}

}
