package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_InvalidDateMonth extends Wrapper_methods{
	@Test
	public void OD_InvalidDateMonth() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date
		selectbyvisibletext_Byname("DateOfVisitDay", "31");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2020");


		//SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "31");
		selectbyvisibletext_Byname("DateOfVisitMonth", "April");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		*/
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
	    
		String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul");

		System.out.println("OD_InvalidDateMonth.java"+actual);
		
		Assert.assertEquals("Invalid date entered. Amend to proceed.", actual);
		
	    	quitBrowser(); 
	
		
	}

}
