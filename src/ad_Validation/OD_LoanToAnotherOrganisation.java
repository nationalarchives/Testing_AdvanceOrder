package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_LoanToAnotherOrganisation extends Wrapper_methods{
	@Test
	public void OD_LoanToAnotherOrganisation() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "July");
		selectbyvisibletext_Byname("DateOfVisitYear", "2019");
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "DL 25/2890");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("OD_LoanToAnotherOrganisation.java"+actual);
		   
		   Assert.assertEquals("DL 25/2890 - This document cannot be ordered. Check the catalogue for more information.", actual);
		   
		//quitBrowser(); 
	    
		
	}

}
