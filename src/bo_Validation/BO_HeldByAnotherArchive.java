package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_HeldByAnotherArchive extends Wrapper_methods{
	@Test
	public void BO_HeldByAnotherArchive() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "BT 100");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "BT 100/34");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_HeldByAnotherArchive - "+actual);
		   
		   Assert.assertEquals("BT 100/34 - This document is held by another archive and cannot be viewed at The National Archives. Check the catalogue for more information.", actual);
		   
		quitBrowser();
	    
		
	}

}
