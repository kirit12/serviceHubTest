package serviceHub.OrderManagement;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.serviceHub.ReadExcel;
import com.serviceHub.base;

import PageObjects.OrderPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import serviceHub.Test.Login;
@Listeners(com.serviceHub.ResultListener.class)
public class CreateOrder extends base {
	
	
	public OrderPage order_obj = new OrderPage();
	public ReadExcel data = new ReadExcel();
	public Login login = new Login();
 	Logger log = LogManager.getLogger(CreateOrder.class.getName());
	@Test
	public void createOrderTest()
	{
		try {
			
			//login.LoginTest(driver);
			
			data.addOrderData();
			log.info("Add order test case started");
			order_obj = PageFactory.initElements(driver, OrderPage.class);
			waitForElement(driver, order_obj.order_mnu);
			order_obj.order_mnu.click();
			
			waitForElement(driver, order_obj.CreateOrder_link);
			order_obj.CreateOrder_link.click();
			
			// click on Create order page.
			waitForElement(driver, order_obj.client_drp);
			Select sel = new Select(order_obj.client_drp);
			sel.selectByValue(data.client);
			
			// First Name
			waitForElement(driver, order_obj.FName_txt);
			order_obj.FName_txt.sendKeys(data.Fname);
			
			waitForElement(driver, order_obj.Lname_txt);
			order_obj.Lname_txt.sendKeys(data.Lname);
			
			waitForElement(driver, order_obj.address1_txt);
			order_obj.address1_txt.sendKeys(data.add1);	
			
			waitForElement(driver, order_obj.address2_txt);
			order_obj.address2_txt.sendKeys(data.add2);	
			
			waitForElement(driver, order_obj.zipcode_txt);
			log.info(data.zip);	
			
			order_obj.zipcode_txt.sendKeys(data.zip);	
			order_obj.email_txt.click();
			
			Thread.sleep(7000);
			waitForElement(driver, order_obj.City_select);
			String city = order_obj.City_select.getText().toString();
			ATUReports.add("Create Order", "-", "Ahmedabad", city, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			waitForElement(driver, order_obj.State_select);
			Select stateAll = new Select(order_obj.State_select);
			String state = stateAll.getFirstSelectedOption().getText().toString();
			
			
			ATUReports.add("Create Order", "-", "Gujarat", state, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			
			waitForElement(driver, order_obj.email_txt);
			order_obj.email_txt.sendKeys(data.email);	
			
			waitForElement(driver, order_obj.date1_btn);
			order_obj.date1_btn.click();
			calenderControl(data.Pdate,1);
			
			Thread.sleep(2000);
			waitForElement(driver, order_obj.DDate_btn);
			order_obj.DDate_btn.click();
			calenderControl(data.DDate,2);
			
			
			waitForElement(driver, order_obj.service_txt);
			order_obj.service_txt.sendKeys(data.service);
			
			waitForElement(driver, order_obj.mobile_txt);
			order_obj.mobile_txt.sendKeys(data.mobile);
			
			waitForElement(driver, order_obj.claim_select);
			Select selClaim = new Select(order_obj.claim_select);
			selClaim.selectByVisibleText(data.claimType);
			
			waitForElement(driver, order_obj.typeService_select);
			Select selService = new Select(order_obj.typeService_select);
			selService.selectByVisibleText(data.serviceType);
			
			waitForElement(driver, order_obj.admin_select);
			Select seladmin = new Select(order_obj.admin_select);
			seladmin.selectByVisibleText("ADMS-013");
			
			waitForElement(driver, order_obj.order_submit_btn);
			order_obj.order_submit_btn.click();
			
			waitForElement(driver, order_obj.Yes_btn);
			order_obj.Yes_btn.click();
			
			log.info("Successfully Add Order");
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
			ATUReports.add("Create Order Test", e.getMessage(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	public void calenderControl(String date, int position) {
		try{
			String[] datearr = date.split("-");
			String getDay = datearr[0];
			String getMon = datearr[1];
			String getYear = datearr[2];
			
			
			//waitForElement(driver, order_obj.monthYear_btn);
			driver.findElement(By.xpath("(//*[@class='btn btn-default btn-sm' and @aria-live='assertive'])["+position+"]")).click();
			//order_obj.monthYear_btn.click();
			//order_obj.monthYear_btn.click();
			System.out.println();
			System.out.println();
			//waitForElement(driver, order_obj.cal1_tbl);
			String date1 = driver.findElement(By.xpath("(//table[@role='grid'])["+position+"]//th[2]/button/strong")).getText().toString();
			int yearInt = Integer.parseInt(date1);
			getTwoDigYear(yearInt,getYear,position);
			
			
			// For Month....
			List<WebElement> month=driver.findElements(By.xpath("(//table[@role='grid'])["+position+"]//td//button//span"));
			for(WebElement ele:month)
			{
				String mon = ele.getText().toString();
			
				if (mon.equalsIgnoreCase(getMon))
				{
					log.info(mon);
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);
			// For Day....
			List<WebElement> day=driver.findElements(By.xpath("(//table[@role='grid'])["+position+"]//td//button//span"));
			for(WebElement ele:day)
			{
				String d = ele.getText().toString();
				
				if (d.equalsIgnoreCase(getDay))
				{
					log.info(d);
					ele.click();
					break;
				}	
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	public void getTwoDigYear(int currentYear,String ReqYear,int position)
	{
		try {
				int reYear = Integer.parseInt(ReqYear);
				int totalYear;
				if(reYear<currentYear)
				{
					totalYear = currentYear - reYear;
					for (int i = 0; i < totalYear; i++) {
						driver.findElement(By.xpath("(//*[@class='glyphicon glyphicon-chevron-left'])["+position+"]")).click();
						//order_obj.backYear_btn.click();
				
					}
				}
				
				else if(reYear>currentYear)
					
				{
					totalYear = reYear - currentYear;
					for (int i = 0; i < totalYear; i++) {
						driver.findElement(By.xpath("(//*[@class='glyphicon glyphicon-chevron-right'])["+position+"]")).click();
						//order_obj.forwadYear_btn.click();
				
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
