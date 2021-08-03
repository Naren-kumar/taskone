package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppoPage extends BaseClass {
	
	public OppoPage() {
     PageFactory.initElements(driver, this);  
	}

	@FindBy(xpath = "//div[@id='product_list']")
	private WebElement oppoProducts;

	public WebElement getOppoProducts() {
		return oppoProducts;
	}
}
