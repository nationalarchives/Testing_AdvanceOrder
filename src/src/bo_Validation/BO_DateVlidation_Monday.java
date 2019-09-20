package bo_Validation;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_DateVlidation_Monday extends Wrapper_methods{
	@Test
	public void BO_DateVlidation_Monday() throws IOException{
		GetBulkOrderURL();
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date
		SelectMondaysDate();
		//SelectTheDate();

		enterTextById("Series", "adm 1");
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
		
	    
	   String actual = getTextByXpath("//*[@id=\"main\"]/article/div[2]/div[2]/div");
	   
	   System.out.println("BO_DateVlidation_Monday"+actual);
	   
	   Assert.assertEquals("The reading rooms are closed on this day. Check our opening times and select a new date.", actual);
	   
	quitBrowser();
	
		
	}

}
