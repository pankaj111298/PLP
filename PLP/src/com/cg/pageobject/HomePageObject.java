package com.cg.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;
	Actions a;

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a") 
	private WebElement myacc;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement loginclick;
	@FindBy(id="input-email")
	private WebElement emailid;
	@FindBy(id="input-password")
	private WebElement psswd;	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement button;
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[6]/a")
	private WebElement link;
	
	
	public HomePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void flow()
	{
		myacc.click();
		a=new Actions(driver);
		a.moveToElement(loginclick).click().perform();
		//loginclick.click();
	}
	public void log(String uname,String pass)
	{
		emailid.sendKeys(uname);
		psswd.sendKeys(pass);
		button.click();
		link.click();
	}
}
