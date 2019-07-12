package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how=How.NAME,using ="login_user_id")
	public WebElement id_txt;
	
	@FindBy(how=How.NAME,using ="password")
	public WebElement password_txt;
	
	@FindBy(how=How.XPATH,using ="//*[@class='btn btn-primary']")
	public WebElement login_btn;
	
	@FindBy(how=How.CLASS_NAME,using ="hidden-xs ng-binding")
	public WebElement user_lbl;
	
	
}
