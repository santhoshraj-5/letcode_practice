package letcode_practice;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Radio_checkbox_practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(co);
		driver.manage().window().maximize();
		//launch the site
		driver.get("https://letcode.in/");

		//click workspace header
		driver.findElement(By.linkText("Work-Space")).click();
		Thread.sleep(1000);
		//click frame button
		driver.findElement(By.linkText("Toggle")).click();

		//select any one radio button
		driver.findElement(By.id("yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("no")).click(); 

		//Confirm you can select only one radio button
		WebElement yes_button=driver.findElement(By.id("one"));
		WebElement no_button=driver.findElement(By.id("two"));
		/*no_button.click();
			yes_button.click();
			boolean yes_selected=yes_button.isSelected();
			boolean no_selected=no_button.isSelected();
			if(yes_selected!=no_selected) {
				System.out.println("only one is selected");
			}
			else{System.out.println("both is selected");
			}*/
		check_both_selected("check only one selected",yes_button, no_button);

		//find the bug
		WebElement b_yesbutton=driver.findElement(By.id("nobug"));
		WebElement b_nobutton=driver.findElement(By.id("bug"));

		check_both_selected("find bug",b_yesbutton, b_nobutton);

		//find which one is seleceted 
		WhichOneIsSelected(driver.findElements(By.cssSelector("input[name='foobar']")));
		//find which one is disabled
		WhichOneIsSelected(driver.findElements(By.cssSelector("input[name='plan']")));
		//Find if the checkbox is selected?
        System.out.println(driver.findElement(By.xpath("//label[contains(text(), ' Remember me')]//child::input")).isSelected());
        //Accept the T&C
        driver.findElement(By.xpath("//label[contains(text(),' I agree to the ')]")).click();
	}
	public static void check_both_selected(String taskname, WebElement yes,WebElement no){
		no.click();
		yes.click();

		/*
		 * boolean yes_selected=yes.isSelected(); boolean no_selected=no.isSelected();
		 */
		if(yes.isSelected()!=no.isSelected()) {
			System.out.println(taskname+" -only one is selected");
		}
		else{System.out.println(taskname+"- both is selected");
		}
	}
	public static void WhichOneIsSelected(List<WebElement> ele) {
		for(WebElement sgele:ele){
			if(sgele.isSelected()) {
				WebElement parent_select=sgele.findElement(By.xpath("./parent::label"));
				System.out.println(parent_select.getText()+"- is selected");
			}
			else if(!sgele.isEnabled()) {
				WebElement parent_enabled=sgele.findElement(By.xpath("./parent::label"));
				System.out.println(parent_enabled.getText()+"- is disabled");
			}
		}
	}
}



