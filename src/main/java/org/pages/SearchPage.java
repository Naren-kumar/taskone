package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass {
	
	public SearchPage() {
      PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Mobiles & More')]")
	private WebElement mveToMobilesAndMore;

	public WebElement getMveToMobilesAndMore() {
		return mveToMobilesAndMore;
	}
	
	public WebElement getClickOppo() {
		return clickOppo;
	}

	@FindBy(xpath = "//a[contains(text(),'Oppo')]")
	private WebElement clickOppo;
}
