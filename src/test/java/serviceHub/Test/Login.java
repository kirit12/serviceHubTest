package serviceHub.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.serviceHub.ReadExcel;
import com.serviceHub.base;

import PageObjects.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Login extends base{

	public base baseObj = new base();
	public LoginPage loginpage = new LoginPage();
	ReadExcel readexcel = new ReadExcel();
	Logger log = LogManager.getLogger(Login.class.getName());
	
	@Test
	public void LoginTest()
	{
		try{
			log.info("Login test started....");
			ATUReports.add("Login test", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			readexcel.readLoginData();
			loginpage = PageFactory.initElements(driver, LoginPage.class);
			baseObj.waitForElement(driver, loginpage.id_txt);
			loginpage.id_txt.sendKeys(readexcel.userName);
			loginpage.password_txt.sendKeys(readexcel.password);
			log.info("Login successfully....");
						loginpage.login_btn.click();
						
			baseObj.waitForElement(driver, loginpage.user_lbl);
			String user = loginpage.user_lbl.getText().toString();
			
			//System.out.println(user);
			//Thread.sleep(7000);
			Assert.assertEquals(user,"Welcome Bryan 9999 S.A");
			ATUReports.add("Login Test", "null", "Welcome Albert", user, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}catch(Exception e)
		{
			ATUReports.add("Login Test", e.getMessage(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	
}
