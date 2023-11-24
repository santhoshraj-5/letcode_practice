package letcode_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownWithSelect_practice {

	public static void main(String[] args) throws InterruptedException {
		//setup chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setBinary("C:\\automation\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(co);
		driver.manage().window().maximize();
		
		//open letcode website
		driver.get("https://letcode.in/");
		
		//click workspace
		driver.findElement(By.linkText("Work-Space")).click();
		Thread.sleep(1000);
		
		//click dropdown button
		driver.findElement(By.linkText("Drop-Down")).click();
		
		//we can select a drop down with 3 methpod
		//by value
		//by index
		//by visible text
		
		//take webelement for dropdown
		WebElement fruit_dd= driver.findElement(By.id("fruits"));
		
		//create selection object
		Select select_fruit=new Select(fruit_dd);
		
		//Select the apple using visible text
		select_fruit.selectByVisibleText("Apple");
		//Select the apple using index text
		//select_fruit.selectByIndex(0);
		//Select the apple using value
		//select_fruit.selectByValue("0");
		
		//select hero ,first check it is multiple select
		WebElement superhero_dd=driver.findElement(By.id("superheros"));
		Select select_superhero= new Select(superhero_dd);
		
		//check for multi select
		boolean superhero_dd_ismult=select_superhero.isMultiple();
		System.out.println(superhero_dd_ismult);
		
		if(superhero_dd_ismult) {
			select_superhero.selectByVisibleText("Captain America");
			select_superhero.selectByIndex(2);
			select_superhero.selectByValue("am");
		}
		else {
			select_superhero.selectByVisibleText("Iron Man");
		}

		//Select the last programming language and print all the options
		//first cerate a select for this
		WebElement program_dd=driver.findElement(By.id("lang"));
		Select select_program= new Select(program_dd);
		
		//first get that detail so we get count also to select the last
		List<WebElement> list=select_program.getOptions();
		int count=list.size();
		
		//chose the last language with out seeing
		select_program.selectByIndex(count-1);
		
		//print all language
		for(int l = 0; l < count; l++)
		{
		    System.out.println(list.get(l).getText());
		}
		
		//Select India using value & print the selected value
		Select select_country=new Select(driver.findElement(By.id("country")));
		select_country.selectByValue("India");
		System.out.println(select_country.getFirstSelectedOption().getText()); 
	}

	}
