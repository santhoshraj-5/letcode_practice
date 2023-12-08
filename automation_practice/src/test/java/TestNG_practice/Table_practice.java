package TestNG_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Table_practice {
@Test
	public void main() {
		System.setProperty("Webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://letcode.in/table");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Shopping List add list amount
		//first need to store the particular table
		WebElement shoping_table=driver.findElement(By.id("shopping"));
		//inside that table we get what data we want so we user table. not driver......now i need header
		List<WebElement>shop_table_head=shoping_table.findElements(By.tagName("th"));
		//we canot user get text directly in list so run a loop and get the list one by one
		for (WebElement header : shop_table_head) {
			System.out.println(header.getText());
		}
		//getting table rows
		List<WebElement>allrow_shop=shoping_table.findElements(By.cssSelector("tbody tr"));
		System.out.println(allrow_shop.size());
		//we need to get the price so here initialize the variable
		int price = 0;
		//runing loop for getting single single rows
		for (WebElement shop_row : allrow_shop) {
			//for single row we have multiple column so that is "td"
			List<WebElement> colum=shop_row.findElements(By.tagName("td"));
			//we nee data of second column so use get index ,because list will give in sequence
			WebElement web_price=colum.get(1);
			//need to get the text of that column
			String string_price=web_price.getText();
			//in above method we get it in string but we need it in int for addition so type casting
			int int_price=Integer.parseInt(string_price);
			//adding price amount with old price amount
			price+=int_price;
		}
		System.out.println(price);
		//in ui we get string so iam again converting the price to string
		String expected_price=Integer.toString(price);
		//getting the actual displayed price amount and type casting it
		String actual_price=driver.findElement(By.cssSelector("table[id='shopping'] tfoot td b")).getText();
		System.out.println(actual_price);
		if(expected_price.equalsIgnoreCase(actual_price)) {System.out.println("shoplist test case passed");
	}
		else System.out.println("shoplist test case failed");
	}
}
