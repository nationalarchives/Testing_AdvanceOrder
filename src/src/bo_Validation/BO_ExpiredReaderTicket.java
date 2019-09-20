package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_ExpiredReaderTicket extends Wrapper_methods{
	@Test
	public void BO_ExpiredReaderTicket() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "8375191");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
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
		
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_ExpiredReaderTicket -"+actual);
		  // Assert.assertEquals("Your reader’s ticket has expired or does not exist. Re-register and enter a new ticket number.", actual);
		   
		   Assert.assertEquals("Your reader’s ticket number is not recognised. Check it has been entered correctly. If it has expired, please re-register and enter a new ticket number.", actual);
		   
		quitBrowser();   
	
		
	}

}
