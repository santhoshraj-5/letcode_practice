package TestNG_practice;

import org.testng.annotations.Test;

public class Groups_atr_practice {
	@Test(groups = "smoke testing")
	public void signup() {
		System.out.println("signup");
	}
	@Test(groups = "sanity testing")
	public void login() {
		System.out.println("login");
	}
	@Test(groups = "reg testing")
	public void search_product() {
		System.out.println("search_product");
	}
	@Test(groups = "smoke testing")
	public void add_to_cart() {
		System.out.println("add_to_cart");
	}
	@Test(groups = "sanity testing")
	public void logout() {
		System.out.println("logout");
	}

}
