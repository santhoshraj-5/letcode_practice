package letcode_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Elements_practice {

	public static void main(String[] args) {
		System.setProperty("webdrive.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get("https://letcode.in/elements");
		 driver.findElement(By.name("username")).sendKeys("santhoshraj-5",Keys.ENTER);
		 System.out.println(driver.findElement(By.xpath("//p[@class='title is-4']")).getText());
		// System.out.println(driver.findElement(By.className("title.is-4")).getText());
		 
		 
		/*
		 * String
		 * public_repo=driver.findElement(By.xpath("//span[text()='Public Repos']")).
		 * getText(); String public_repo_count=driver.findElement(By.
		 * xpath("//span[text()='Public Repos']/following-sibling::span")).getText();
		 * System.out.println(public_repo+"-"+public_repo_count);
		 */
		 System.out.println(user_repo_details( driver.findElements(By.xpath(("//div[@class='field is-grouped is-grouped-multiline']//div[1]//div[1]")))));
		user_repo_details( driver.findElements(By.xpath(("//div[@class='field is-grouped is-grouped-multiline']//div[1]//div[1]"))));
		
		user_repo_details(driver.findElements(By.xpath("//div[@class='field is-grouped is-grouped-multiline']")));
		
		//user_repo_details(driver.findElements(By.xpath("//div[@class='block']//ol[@type='1']")));
		//
		List<WebElement> repo_url=driver.findElements(By.tagName("li"));
		System.out.println(repo_url.size());

	}
public static String user_repo_details(List<WebElement> repo) {
	String last=null;
	 for(WebElement l_repo:repo) {
			last=l_repo.getText();
		 }
	 return last;
}
}
