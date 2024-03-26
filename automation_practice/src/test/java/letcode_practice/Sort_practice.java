package letcode_practice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sort_practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/sortable");
		Actions builder=new Actions(driver);
		WebElement get_to_work=driver.findElement(By.xpath("//div[text()=' Get to work']"));
		WebElement right_side=driver.findElement(By.xpath("//div[@id='cdk-drop-list-1']"));
		
		WebElement pick_up_gro=driver.findElement(By.xpath("//div[text()=' Pick up groceries']"));
		/*
		 * List<WebElement>list=driver.findElements(By.xpath(
		 * "//div[@id='cdk-drop-list-2']")); System.out.println(list.size());
		 */
		//System.out.println(get_to_work.getLocation());
		//builder.doubleClick(get_to_work).perform();
		builder.dragAndDrop(get_to_work, right_side).release().perform();
		//builder.doubleClick(pick_up_gro).perform();
		Thread.sleep(1000);
		builder.moveToElement(pick_up_gro).dragAndDrop(pick_up_gro, right_side).build().perform();
		
		

	}

}
