package com.serviceHub;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class base {
	{
		System.setProperty("atu.reporter.config", "./src/main/java/com/serviceHub/atu.properties");
	}
	public WebDriver driver;
	public void DriverIni()
	{
		try{
			
		FileInputStream file = new FileInputStream("./src/main/java/com/serviceHub/data.properties");
		Properties prop = new Properties();
		prop.load(file);
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		ATUReports.setAuthorInfo("Kirit Thakrar",Utils.getCurrentTime() , "1");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			ATUReports.setWebDriver(driver);
			//System.out.println("chrome");
		}
		else if (browserName.equals("firefox"))
		{
			System.out.println("firefox");
		}
		else
		{
			System.out.println("none");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
	}
	
	@BeforeTest
	public void precondtions()
	{
		DriverIni();
	
		
	}
	
	@AfterTest
	public void postcondtions()
	{
		EmailTemplete();
		driver.quit();
	}
	
	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20, 1000);
		wait.pollingEvery(2,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void EmailTemplete()
	{
		try{
			ResultListener rl = new ResultListener();
			int passCount = rl.getPassCount();
			int failCount = rl.getFailCount();
			int skippedCount = rl.getSkippedCount();
			int totalCount = passCount + failCount + skippedCount;
			File emailFile = new File("./Email/report.html"); 
			String dataRead = FileUtils.readFileToString(emailFile);
			dataRead = dataRead.replace("${ReportHeader}", "Srvice Hub Automation");
			dataRead = dataRead.replace("${TotalTestCases}", String.valueOf(totalCount));
			dataRead = dataRead.replace("${PassedTestCases}", String.valueOf(passCount));
			dataRead = dataRead.replace("${FailedTestCases}", String.valueOf(failCount));
			dataRead = dataRead.replace("${SkippedTestCases}", String.valueOf(skippedCount));
		
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("kirit.thakrar1992@gmail.com", "ekta@1212"));
			email.setSSLOnConnect(true);
			
			email.addTo("kirit.thakrar1992@gmail.com");
			email.setFrom("kirit.thakrar1992@gmail.com");
			email.setSubject(" Daily Automation Test Summary Report ");
			email.setHtmlMsg(dataRead);
			email.setTextMsg("Your email client does not support HTML messages");
			email.send();
			System.out.println("Send Successfuly..");
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
