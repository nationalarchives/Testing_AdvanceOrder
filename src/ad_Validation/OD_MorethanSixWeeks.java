package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_MorethanSixWeeks extends Wrapper_methods{
	@Test
	public void OD_MorethanSixWeeks() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		//SelectTheDate();
		selectbyvisibletext_Byname("DateOfVisitDay", "7");
		selectbyvisibletext_Byname("DateOfVisitMonth", "September");
		selectbyvisibletext_Byname("DateOfVisitYear", "2020");
		
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
		   
		   System.out.println("OD_MorethanSixWeeks.java"+actual);
		   Assert.assertEquals("Orders cannot be placed more than six weeks in advance. Amend visit date.", actual);
		   
		//quitBrowser();
	
		
	}

}
