package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_ClosedDigitalRecord extends Wrapper_methods{
	@Test
	public void BO_ClosedDigitalRecord() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		
		enterTextById("Series", "WO 409");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "WO 409/27/19/810");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_ClosedDigitalRecord- "+actual);
		   
		   Assert.assertEquals("WO 409/27/19/810 - This document cannot be identified. Check catalogue reference has been entered correctly.", actual);
		   
		quitBrowser();
	    
		
	}

}
