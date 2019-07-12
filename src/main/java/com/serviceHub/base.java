package com.serviceHub;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class base {
	
	public static WebDriver driver;
	
	public WebDriver DriverIni()
	{
		try{
		
		FileInputStream file = new FileInputStream("./src/main/java/com/serviceHub/data.properties");
		Properties prop = new Properties();
		prop.load(file);
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
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
		return driver;
		
	}
	
	@BeforeClass
	public void precondtions()
	{
		DriverIni();
	}
	
	@AfterClass
	public void postcondtions()
	{
	 
		driver.quit();
	}
	
	/*private void generateEmailTemplate(int passed, int failed, int skipped) {
		 try
		  {
			  File reportTemplate=null;
				  reportTemplate = new File(".\\Email\\report.html");
				  
			
		
			String mailContent = FileUtils.readFileToString(reportTemplate);
			int totalCases = passed+failed+skipped;

			mailContent = mailContent.replace("${ReportHeader}", " - Service Hub | Daily Automation Test Case Report "+getDate());
			mailContent = mailContent.replace("${TotalTestCases}", String.valueOf(totalCases));
			mailContent = mailContent.replace("${PassedTestCases}", String.valueOf(passed));
			mailContent = mailContent.replace("${FailedTestCases}", String.valueOf(failed));
			mailContent = mailContent.replace("${SkippedTestCases}", String.valueOf(skipped));
			sendMail(mailContent);
			} catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		
	}

	
		private void sendMail(String mailContent) {
		// TODO Auto-generated method stub
			try
			  {
				HtmlEmail email = new HtmlEmail();
				email.setHostName("mail.tatvasoft.com");
				email.setSmtpPort(25);
				email.setAuthenticator(new DefaultAuthenticator("kirit.thakrar1992@gmail.com", "KT@thakrar1212"));
				email.setSSLOnConnect(true);
				
				email.addTo("kirit.thakrar1992@gmail.com", "Kirit Thakrar");
				//email.addTo("kirit.thakrar1992@gmail.com", "Sandip Thakkar");
				
				email.setFrom("kirit.thakrar1992@gmail.com", "kirit.thakrar1992@gmail.com");
				email.setSubject("Srvice Hub | Daily Automation Test Summary Report "+getDate());
				email.setHtmlMsg(mailContent);
				email.setTextMsg("Your email client does not support HTML messages");
				email.send();
			  }
			  catch(Exception ex)
			  {
				  System.out.println(ex.getMessage());
			  }
	}

		public String getDate() {
			Date date = new Date();
			DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
			//DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String output = outputFormatter.format(date);
			return output ;
		}
		
*/

	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20, 1000);
		wait.pollingEvery(2,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
