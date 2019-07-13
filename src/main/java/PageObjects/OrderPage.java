package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPage {

	@FindBy(how = How.XPATH,using="//*[@class='ng-binding' and text()='Order Management']")
	public WebElement order_mnu;
	
	@FindBy(how = How.XPATH,using="//*[text()='Create Order']")
	public WebElement CreateOrder_link;
	
	@FindBy(how = How.NAME,using="client_origin")
	public WebElement client_drp;
	
	@FindBy(how = How.NAME,using="client_billto")
	public WebElement client1_drp;
	
	
	@FindBy(how = How.CSS,using="div.form-horizontal.mobilegap.ng-scope > div > div > div > button")
	public WebElement date1_btn;
	
	/*@FindBy(how = How.XPATH,using="(//table[@role='grid'])[1]")
	public WebElement cal1_tbl;
	*/
	
	@FindBy(how = How.XPATH,using="(//*[@class='btn btn-default btn-sm' and @aria-live='assertive'])[1]")
	public WebElement monthYear_btn;
	
	@FindBy(how = How.XPATH,using="(//*[@class='glyphicon glyphicon-chevron-left'])[1]")
	public WebElement backYear_btn;
	
	@FindBy(how = How.XPATH,using="(//*[@class='glyphicon glyphicon-chevron-right'])[1]")
	public WebElement forwadYear_btn;
	
	@FindBy(how = How.XPATH,using="(//table[@role='grid'])[1]//th[2]/button/strong")
	public WebElement Year_btn;
	
	@FindBy(how = How.NAME,using="first_name")
	public WebElement FName_txt;
	
	@FindBy(how = How.NAME,using="last_name")
	public WebElement Lname_txt;
	
	@FindBy(how = How.NAME,using="address1")
	public WebElement address1_txt;
	
	@FindBy(how = How.NAME,using="address2")
	public WebElement address2_txt;
	
	@FindBy(how = How.NAME,using="zipcode")
	public WebElement zipcode_txt;
	
	@FindBy(how = How.NAME,using="email")
	public WebElement email_txt;
	
	@FindBy(how = How.CSS,using="#main_inputgroup > div > div > form > fieldset > div:nth-child(1) > div:nth-child(8) > div:nth-child(2) > div > div > div > button")
	public WebElement DDate_btn;
	
	@FindBy(how = How.NAME,using="service_instrcn")
	public WebElement service_txt;
		
	@FindBy(how = How.NAME,using="mobile")
	public WebElement mobile_txt;
	
	@FindBy(how = How.NAME,using="claim_type")
	public WebElement claim_select;

	@FindBy(how = How.NAME,using="service_type")
	public WebElement typeService_select;
	
	@FindBy(how = How.NAME,using="assign_admin_staff")
	public WebElement admin_select;
	
	
	@FindBy(how = How.ID,using="order_submit")
	public WebElement order_submit_btn;
	
	@FindBy(how = How.XPATH,using="//*[@class='btn-primary btn' and text()='Yes']")
	public WebElement Yes_btn;
	

	@FindBy(how = How.XPATH,using="//*[@ng-bind='option.city_name']")
	public WebElement City_select;
	

	@FindBy(how = How.NAME,using="state")
	public WebElement State_select;
	
	@FindBy(how = How.NAME,using="client_order_no")
	public WebElement client_order_no_vrfy;
	
	
}
