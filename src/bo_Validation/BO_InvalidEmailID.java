package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_InvalidEmailID extends Wrapper_methods{
	@Test
	public void BO_InvalidEmailID() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "20");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "adm 1");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//enter by invalid id
		
		enterTextById("EmailAddress", "tnadgmail.com");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_InvalidEmailID -  "+actual);
		   Assert.assertEquals("Enter a valid email address.", actual);
		   
		quitBrowser();     
	
		
	}

}
