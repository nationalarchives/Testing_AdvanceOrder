package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DateVlidation_Monday extends Wrapper_methods{
	@Test
	public void DateVlidation_Monday() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date

		SelectMondaysDate();

		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");

	    
	   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
	   
	   System.out.println("DateVlidation_Monday"+actual);
	   
	   Assert.assertEquals("The reading rooms are closed on this day. Check our opening times and select a new date.", actual);
	   
	quitBrowser();   
	
		
	}

}
