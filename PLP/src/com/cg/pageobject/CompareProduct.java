package com.cg.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class CompareProduct {
	WebDriver driver;
	
	String str,str1;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[6]/a")
	private WebElement link;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[1]/h4/a")
	private WebElement mobName;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[1]/h4/a")
	private WebElement mobName2;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[3]")
	private WebElement comBtn;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[3]")
	private WebElement comBtn1;
	@FindBy(xpath="//*[@id=\"compare-total\"]")
	private WebElement compareLink;
	@FindBy(xpath="//*[@id=\"content\"]/table/tbody[1]/tr[3]/td[2]")
	private WebElement price1;
	@FindBy(xpath="//*[@id=\"content\"]/table/tbody[1]/tr[3]/td[3]")
	private WebElement price2;
	@FindBy(xpath="//*[@id=\"content\"]/table/tbody[2]/tr/td[2]/input")
	private WebElement addcart;
	@FindBy(xpath="//*[@id=\"content\"]/table/tbody[2]/tr/td[3]/input")
	private WebElement addcart2;
	
	
	public CompareProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void getProduct()
	{
		link.click();
	}
	
	public void firstProduct()
	{
		str=mobName.getText();
		comBtn.click();
	}
	
	public void secondProduct()
	{
		str1=mobName2.getText();
		comBtn1.click();
	}
	public void compareLink() throws InterruptedException
	{
		compareLink.click();
		Thread.sleep(2000);
		String p=price1.getText();
		String a1=p.substring(1,(p.length()-1));
		double price=Double.parseDouble(a1);
		String p1=price2.getText();
		String a=p1.substring(1,(p1.length()-1));
		double price1=Double.parseDouble(a);
		if(price<price1)
		{
			addcart.click();
		}
		else
		{
			addcart2.click();
		}
		
	}
	
	public void addCart(){
		
	}

}
