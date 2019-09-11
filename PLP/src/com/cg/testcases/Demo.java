package com.cg.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.pageobject.AddCart;
import com.cg.pageobject.CompareProduct;
import com.cg.pageobject.HomePageObject;
import com.cg.utilities.ExcelReader;
import com.cg.utilities.propRead;

public class Demo {

	WebDriver driver;
	HomePageObject obj;
    CompareProduct obj1;
    AddCart obj2;
	@BeforeClass
	public void browser() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\VnV\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(propRead.getprop("url"));
		obj = new HomePageObject(driver);

	}

/*	@Test(priority=0)
	public void basicflow() {
		obj.flow();
	}
	@Test(priority=1,dataProvider="getperformData")
	public void login(Hashtable<String,String> h)
	{
		obj.log(h.get("Username"),h.get("Password"));
	}
*/	
	

	@DataProvider
	public Object[][] getperformData() throws IOException {

		String filename = "Details.xlsx";
		String filepath = System.getProperty("user.dir")
				+ "/src/com/cg/testdata";
		String sheetname = "perDetails";
		// ExcelReader.ReadExeclData(filepath, filename, sheetname);
		return ExcelReader.ReadExeclDataToObject(filepath, filename, sheetname);

	}
	
/*	@Test(priority=2)
	public void compare() throws InterruptedException
	{
		obj1=new CompareProduct(driver);
		obj1.getProduct();
		
		//Thread.sleep(5000);
		obj1.secondProduct();
		obj1.firstProduct();
		 obj1.compareLink();
	}
*/	
	@Test(dataProvider="getperformData")
	public void compareProductTest(Hashtable<String,String> h) throws InterruptedException
	{
		obj.flow();
		obj.log(h.get("Username"),h.get("Password")); 
		obj1=new CompareProduct(driver);
		Thread.sleep(2000);
		obj1.getProduct();
		obj1.secondProduct();
		Thread.sleep(2000);
		obj1.firstProduct();
		Thread.sleep(2000);
		 obj1.compareLink();
		 obj2=new AddCart(driver);
		 Thread.sleep(2000);
		 obj2.addCartPage();
		 Thread.sleep(2000);
		 obj2.logout();
	}
}