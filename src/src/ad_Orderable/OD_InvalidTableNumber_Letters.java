package ad_Orderable;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

public class OD_InvalidTableNumber_Letters extends Wrapper_methods{
	@Test
	public void OD_InvalidTableNumber_Letters() throws IOException, InterruptedException{

		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number

		enterTextById("ReaderTicket", "100");

		//enter the date
		SelectTheDate();
		//enter the date 
       /* Select Day = new Select(driver.findElementByName("DateOfVisitDay"));
		List<WebElement> alloptions = Day.getOptions();
		Day.selectByVisibleText("20");
		
		Thread.sleep(3000);
		 Select Month = new Select(driver.findElementByName("DateOfVisitMonth"));
			List<WebElement> alloptions1 = Month.getOptions();
			Month.selectByVisibleText("June");
			Thread.sleep(3000);
			 Select DateOfVisitYear = new Select(driver.findElementByName("DateOfVisitYear"));
				List<WebElement> alloptions2 = DateOfVisitYear.getOptions();
				DateOfVisitYear.selectByVisibleText("2018");*/

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");



		SelectTheDate();
		Thread.sleep(1000);


		//enter the documenet reference id
		
		driver.findElementById("DocumentReference1").sendKeys("adm 1/1");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		
		driver.findElementById("SeatNumber").sendKeys("fdfdf2323dff");
		
		
		
		driver.findElementByLinkText("floor plan").click();
		
		//driver.findElement(By.linkText("floor plan")).click();
		
		String parentwindow = driver.getWindowHandle();
		for(String Subwindow :driver.getWindowHandles())
		{
			driver.switchTo().window(Subwindow);
		}
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.close();
		
		driver.switchTo().window(parentwindow);
		
		
		
		//enter full name
		
				driver.findElementById("FullName").sendKeys("Testing#TestingForAdvanceOrderForm");
				//enter phone number
				driver.findElementById("TelephoneNumber").sendKeys("078012876");
				driver.findElementById("EmailAddress").sendKeys("tnadiscovery100@gmail.com");
				
				
				//click term and conditions
				//driver.findElementById("TermsAndConditions").click();
				//(Removed on 12 june 2018)
				//clickbyID("TermsAndConditions");
				//driver.findElementByXPath("//input[@name='TermsAndConditions'][1]").click();
				
				//click to continue
				driver.findElementByXPath("//input[@value='Continue']").click();
			   
				
				 //click complete order
			    
			    driver.findElementByXPath("//input[@value='Complete order']").click();
			  
			    //get order complete text
			    
			    String actual =driver.findElementByXPath("//div[@class='entry-content clearfix']/p[1]").getText();
			   // String actual1 =driver.findElementByXPath("//div[@class='entry-content clearfix']/p[2]").getText();
			    
			    System.out.println("OD_InvalidTableNumber_Letters.java"+actual);
			    //System.out.println(actual1);
			    
			   // Assert.assertEquals(actual,"Your document order has been successfully submitted.");
			   
			    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
			driver.quit();    
	}

}
