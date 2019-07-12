package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPage {

	@FindBy(how = How.XPATH,using="//*[@class='ng-binding' and text()='Order Management']")
	public WebElement order_mnu;
	
}
