package TestNG_practice;

import org.testng.annotations.Test;

public class Priority_dependson_practice {
	@Test(priority = -5)
	public void signup() {
		System.out.println("signup method");
	}
	
	@Test
	public void login() {
		System.out.println("login method");
	}
	
	@Test(priority = 1,dependsOnMethods = "login")//this method is will run after login because we gave dependsmethod
	//"depensonmethod" will in high priorty for testNG so "priority " will be in  
	public void searchproduct() {
		System.out.println("search product method");
	}
	
	@Test(priority = 2)
	public void add_to_cart() {
		System.out.println("add to cart method");
		throw new RuntimeException();//this will fail this method and throw error
	}
	
	@Test(priority = 3,invocationCount = 2)
	public void logout() {
		System.out.println("logout method");
	
	}

}
