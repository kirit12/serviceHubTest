package serviceHub.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.serviceHub.ReadExcel;
import com.serviceHub.base;

import PageObjects.LoginPage;

public class Login extends base{

	public LoginPage loginpage = new LoginPage();
	ReadExcel readexcel = new ReadExcel();
	@Test
	public void LoginTest()
	{
		try{
			readexcel.readLoginData();
			//loginpage = PageFactory.initElements(driver, LoginPage.class);
			waitForElement(driver, loginpage.id_txt);
			loginpage.id_txt.sendKeys(readexcel.userName);
			loginpage.password_txt.sendKeys(readexcel.password);
			
			loginpage.login_btn.click();
			waitForElement(driver, loginpage.user_lbl);
			String user = loginpage.user_lbl.getText().toString();
			System.out.println(user);
			//Thread.sleep(7000);
			Assert.assertEquals(user,"Welcome Albert");
			
		}catch(Exception e)
		{
			
		}
	}
}
