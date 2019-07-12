package serviceHub.OrderManagement;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.serviceHub.base;

import PageObjects.OrderPage;
import serviceHub.Test.Login;

public class CreateOrder extends base {
	//static Logger log = Logger.getLogger(CreateOrder.class.getName());
	public Login login = new Login();
	public OrderPage order_obj = new OrderPage(); 
	@Test
	public void createOrderTest()
	{
		try {
			login.LoginTest();
			System.out.println("hhsk");
			order_obj = PageFactory.initElements(driver, OrderPage.class);
			waitForElement(driver, order_obj.order_mnu);
			order_obj.order_mnu.click();
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
