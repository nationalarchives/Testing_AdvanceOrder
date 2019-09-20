package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_UnKnownDepartment extends Wrapper_methods{
	@Test
	public void BO_UnKnownDepartment() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "BT 394");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "BT 394/30");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_UnKnownDepartment - "+actual);
		   
		   Assert.assertEquals("BT 394/30 - This document is closed and cannot be ordered. Check the catalogue for more information.", actual);
		   
		quitBrowser(); 
	    
		
	}

}
