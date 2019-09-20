package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_HeldInDeepStore extends Wrapper_methods{
	@Test
	public void OD_HeldInDeepStore() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		enterTextById("ReaderTicket", "100");

		//enter the date
		SelectTomorrowsDate();

		//enter the documenet reference id
		enterTextById("DocumentReference1", "MAF 13/3");
		
		//enter full name
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");

		//enter phone number
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		 	    
	    String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("OD_HeldInDeepStore.java"+actual);
		   
		   Assert.assertEquals("Documents held offsite require three working days for delivery. Select a new date.", actual);
		   
		quitBrowser(); 
	    
		
	}

}
