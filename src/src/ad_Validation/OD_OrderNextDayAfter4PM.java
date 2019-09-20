package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_OrderNextDayAfter4PM extends Wrapper_methods{
	@Test
	public void OD_OrderNextDayAfter4PM() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date
		selectbyvisibletext_Byname("DateOfVisitDay", "23");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2019");

		//SelectTheDate();
		SelectTomorrowsDate();

		//enter the documenet reference id
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");

		//enter phone number
		enterTextById("TelephoneNumber", "078012876");
		
		//enter by invalid id
		enterTextById("EmailAddress", "tnadiscovery100@gmail.com");
		
		//click term and conditions
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("OD_OrderNextDayAfter4PM.java"+actual);
		  Assert.assertEquals("Orders for next-day delivery must be placed before 16:00. Select a new date.", actual);
		   
		quitBrowser();     
	
		
	}

}
