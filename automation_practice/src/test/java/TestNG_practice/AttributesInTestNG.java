package TestNG_practice;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class AttributesInTestNG {
	//this is just for practice but in actual case we give for big test code
	
	@Test(priority = -1)
	public void method_1() {
		System.out.println("method 1");
		throw new NoSuchElementException();
	}
	@Test(dependsOnMethods = "method_1")
	public void method_2() {
		System.out.println("method 2");
	}
	@Test(dependsOnMethods = "method_2",alwaysRun = true)//even the dependency failed this will always run
	public void method_3() {
		System.out.println("method 3");
	}
	@Test(enabled = false)//as we give enable is false this test wont run
	public void method_4() {
		System.out.println("method 4");
	}
	@Test(description = "this is method 5")
	public void method_5() {
		System.out.println("method 5");
	}
	@Test(threadPoolSize = 2,invocationCount = 2)//used for parallel testing
	public void method_6() {
		System.out.println("method 6");
	}
	@Test(invocationCount = 2,invocationTimeOut = 100)//the count should be completed with in given time ms
	public void method_7() {
		System.out.println("method 7");
	}
	@Test(expectedExceptions = {NoSuchElementException.class})
	public void method_8() {
		System.out.println("method 8");
		throw new NoSuchElementException();
	}
	@Test
	public void method_9() {
		System.out.println("method 9");
	}

}
