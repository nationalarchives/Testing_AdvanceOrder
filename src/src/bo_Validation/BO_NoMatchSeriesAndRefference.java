package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_NoMatchSeriesAndRefference extends Wrapper_methods{
	@Test
	public void BO_NoMatchSeriesAndRefference() throws IOException{
		
		GetBulkOrderURL();
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		//enter series number
		enterTextById("Series", "CAB 120");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "IR 26/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
	   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
	   
	   System.out.println("BO_NoMatchSeriesAndRefference  -  "+actual);
	   
	   Assert.assertTrue(actual.contains("IR 26/1 - Check that all catalogue references are from the same document series to submit a bulk order."));
	   
	quitBrowser();   
	
		
	}

}
