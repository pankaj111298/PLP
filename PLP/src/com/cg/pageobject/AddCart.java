package com.cg.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddCart {
	
	WebDriver driver;
	Actions a;
	@FindBy(xpath="//*[@id=\"product-compare\"]/div[1]/a[2]")
	private WebElement addClick;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")
	private WebElement itemName;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")
	private WebElement itemName1;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	private WebElement removeBtn;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a") 
	private WebElement myacc;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	private WebElement logout;
	
	String str,str1;
	
	public AddCart(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	public void addCartPage()
	{
		addClick.click();
		str=itemName.getText();
		
		str1=itemName1.getText();
		
		Assert.assertEquals(str,str1);
		
	    removeBtn.click();
	    
	  }
	
	public void logout()
	{
		myacc.click();
		a=new Actions(driver);
		a.moveToElement(logout).click().perform();
	}
	
	

}
