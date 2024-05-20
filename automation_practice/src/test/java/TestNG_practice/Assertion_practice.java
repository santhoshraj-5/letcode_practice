package TestNG_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_practice {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	String Actual="Santhosh";
	String Expected="santhosh";
		@Test(priority=1)
		public void Hard_assertion() {
               Assert.assertTrue(false);
			//Assert.assertFalse(false);
			System.out.println("after hard asser false-pass");//if hard assert fail next line wont be running
               //Assert.assertEquals(Actual, Expected);
               //Assert.assertEquals(true, false, "this is error from boolean assertion");
		}
		@Test(priority=2)
		public void soft_assertion() {
			SoftAssert sf_assert=new SoftAssert();
			sf_assert.assertTrue(false);
			sf_assert.assertEquals(true, false);
			System.out.println("after soft asser true-fail");//if soft assert fail also it will run next line
			sf_assert.assertAll();//with out this the soft assert will not run
		}
		
		
	}

