package wrappers;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrapper_methods {
	public RemoteWebDriver driver;
	
	int sCount = 1;
	public void launchDriver(String url,String browser){
		if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Softwares\\Selenium\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
					}
		else if (browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
			
			       		}
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
		public void quitBrowser() throws IOException
		{
			try {
				driver.quit();

			} catch (WebDriverException e) {
				System.out.println("Unable to close the browser...");
			}
			finally{
				
			}
		}

		
		
		public void enterTextById(String id, String idValue) 
		{
			try {
				driver.findElementById(id).clear();
				driver.findElementById(id).sendKeys(idValue);
			} catch (NoSuchElementException e) {
				System.out.println("The Element with id : "+id+" is not available");
			}
			finally {
				
			}
		}
		
		public void clickbyXpath(String xpath) throws IOException
		{
			try {
				driver.findElementByXPath(xpath).click();
			} catch (NoSuchElementException e) {
				System.out.println("Element with xpath:" + xpath +"is not found");
			}
			finally{
				
			}
		}
		
		public String getTextById(String id) throws IOException{
			String str=null;
			try {
				str = driver.findElementById(id).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The Element with Id : "+id+" is not available");
			}
			finally
			{
			
				}
			return str;
		}
		
		public void clickbyID(String id) throws IOException
		{
			try {
				driver.findElementById(id).click();
			} catch (NoSuchElementException e) {
				System.out.println("Element with id" + id +"is not found");
			}
			finally{
							}
		}
		
		
		public void enterByTextXpath(String xPath, String xPathvalue) 
		{
			try {
				driver.findElementByXPath(xPath).clear();
				driver.findElementByXPath(xPath).sendKeys(xPathvalue);
			} catch (NoSuchElementException e) {

				System.out.println("The Element with Xpath : "+xPath+" is not available");
			}
			finally {
				
			}
		}
		
		public boolean selectbyvisibletext_Byname(String name, String value) throws IOException{
			boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementByName(name));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();

				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					//System.out.println("Dropdowns 'options' are :" +text);
				}
				//System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {

				System.out.println("The Element with id :"+name+"is not available");
			}
			finally{
				/*//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;*/
			}
			return flag;

		}
		
		public boolean selectbyvisibletext_Byxpath(String xpath, String value) throws IOException{
			boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementByXPath(xpath));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();

				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					//System.out.println("Dropdowns 'options' are :" +text);
				}
				System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {

				//System.out.println("The Element with id :"+xpath+"is not available");
			}
			finally{
				//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;
			}
			return flag;

		}
		
		

		//Click on webelement using LinkText

		public void clickbyLinkText(String linktext) throws IOException
		{
			try {
				driver.findElementByLinkText(linktext).click();
			} catch (NoSuchElementException e) {
				System.out.println("Element with linktext:" + linktext +"is not found");

			}
			finally{
				//Screenshot();
			}
		}
		
		//Wrapper for getTextBy Xpath
		
		public String getTextByXpath(String xpath) throws IOException{
			String str=null;
			try {
				str = driver.findElementByXPath(xpath).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The Element with Xpath : "+xpath+" is not available");
			}
			finally
			{
				
			}
			return str;
		}
		
		
		public boolean clickByClassName(String classVal) {
			boolean bReturn = false;
			try{
				driver.findElement(By.className(classVal)).click();
				//Reporter.reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");

				bReturn = true;

			} catch (Exception e) {
				//Reporter.reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
			}
			return bReturn;
		}
		
		

		//Screenshot Method

		public void Screenshot() throws IOException{

			//Take snapshot
			File ScreenShot = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ScreenShot, new File("./Snapshots/snap"+ System.currentTimeMillis() +".jpeg"));
			System.out.println("Counter count - "+sCount);
			sCount = sCount + 1;
	}
		
		
		public void SingleSignOn(){
						
			try {
				driver.findElementById("UserName").sendKeys("tnadiscovery100@gmail.com");
				
				driver.findElementById("Password").sendKeys("Discovery12345");
				//click sign in
				
				driver.findElementByClassName("singleColumnSubmit").click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void selectByValue_UsingId(String id, String Value) throws IOException{

			try {
				Select dropdown = new Select(driver.findElementById(id));
				List<WebElement> allOptions = dropdown.getOptions();
				dropdown.selectByValue(Value);
			} catch (NoSuchElementException e) {
				System.err.println("The dropdown with id - "+id+ " not found.");	
			}
			finally
			{
				Screenshot();		
			}
		
		}

		public void GetBulkOrderURL(){
			
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","Z:\\Svenkatesh\\BatchDiscovery01\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 //driver.get("https://dev.bulkorders.nationalarchives.gov.uk/");
		 driver.get("https://test.nationalarchives.gov.uk/bulk-order-documents");
}
		
		
		public void SelectTheDate(){
			
			
			 LocalDate futureDate=LocalDate.now().plusDays(4);
				
				if(futureDate.getDayOfWeek() == DayOfWeek.SUNDAY || futureDate.getDayOfWeek() == DayOfWeek.MONDAY)
				{
					futureDate = futureDate.plusDays(2);
				}
				
					
				try {
					selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(futureDate.getDayOfMonth()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String month = futureDate.getMonth().toString();
						
				try {
					selectbyvisibletext_Byname("DateOfVisitMonth", String.format("%s%s", month.charAt(0), month.substring(1).toLowerCase()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				try {
					selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	public void SelectTomorrowsDate(){
		LocalDate futureDate=LocalDate.now().plusDays(1);
		if(futureDate.getDayOfWeek() == DayOfWeek.SUNDAY || futureDate.getDayOfWeek() == DayOfWeek.MONDAY)
		{
			futureDate = futureDate.plusDays(2);
		}
		try {
			selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(futureDate.getDayOfMonth()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String month = futureDate.getMonth().toString();

		try {
			selectbyvisibletext_Byname("DateOfVisitMonth", String.format("%s%s", month.charAt(0), month.substring(1).toLowerCase()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	public void SelectTodaysDate(){
			LocalDate futureDate=LocalDate.now().plusDays(0);
			if(futureDate.getDayOfWeek() == DayOfWeek.SUNDAY || futureDate.getDayOfWeek() == DayOfWeek.MONDAY)
			{
				futureDate = futureDate.plusDays(1);
			}
			try {
				selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(futureDate.getDayOfMonth()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String month = futureDate.getMonth().toString();

			try {
				selectbyvisibletext_Byname("DateOfVisitMonth", String.format("%s%s", month.charAt(0), month.substring(1).toLowerCase()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



	}
	public void SelectMondaysDate() {
		int hour      = 10; // 10 AM
		int minute    = 0;
		int dayOfWeek = Calendar.MONDAY;
		LocalDate futureDate = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		//if (futureDate.getDayOfWeek() !=dayOfWeek)
		if (cal.get(Calendar.DAY_OF_WEEK) != dayOfWeek){
			//futureDate = futureDate.plusDays(7);
			//futureDate.plusMonths(futureDate.getDayOfMonth(),(DayOfWeek.MONDAY.plus(7)-futureDate.getDayOfWeek()))%7;
			cal.add(Calendar.DAY_OF_MONTH,(dayOfWeek + 7 -  cal.get(Calendar.DAY_OF_WEEK))%7);
		}
		else{
			int minOfDay = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
			if (minOfDay >= hour * 60 + minute)
				cal.add(Calendar.DAY_OF_MONTH, 7); // Bump to next week
		}
		try {
			selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String month = futureDate.getMonth().toString();

		try {
			selectbyvisibletext_Byname("DateOfVisitMonth", String.format("%s%s", month.charAt(0), month.substring(1).toLowerCase()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}

