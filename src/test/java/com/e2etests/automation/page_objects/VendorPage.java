package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class VendorPage {
	
	
	

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
	public static WebElement btnCustmor;

	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Vendors']")
	public static WebElement btnVendor;

	
	@FindBy(how = How.ID, using = "SearchName")
	public static WebElement SearchName;

	@FindBy(how = How.ID, using = "search-vendors")
	public static WebElement btnsearchvendors;

	@FindBy(how = How.XPATH, using = "//td[normalize-space()='Vendor 2']")
	public static WebElement assertElemntTab;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-default']")
	public static WebElement btnEdit;
	
	
	@FindBy(how = How.ID, using = "Name")
	public static WebElement nameEditer;

	@FindBy(how = How.NAME, using = "save")
	public static WebElement btnsave;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success alert-dismissable']")
	public static WebElement assertAjout;

	
	

	
	public VendorPage() {
		PageFactory.initElements(Setup.driver, this);
	}
}
