package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_EnterReferenceForSecond extends Wrapper_methods{
	@Test
	public void BO_EnterReferenceForSecond() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "ADM 1");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference2", "ADM 1/1");
		
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
		   
		   System.out.println(actual);
		  Assert.assertTrue(actual.contains("Enter a minimum of 20 catalogue references to submit a bulk order."));
		  
			   
		quitBrowser();     
	
		
	}

}
