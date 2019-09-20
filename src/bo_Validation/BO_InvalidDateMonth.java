package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_InvalidDateMonth extends Wrapper_methods{
	@Test
	public void BO_InvalidDateMonth() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date
		selectbyvisibletext_Byname("DateOfVisitDay", "31");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2019");



		//SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "31");
		selectbyvisibletext_Byname("DateOfVisitMonth", "September");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "HO 405");
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

		System.out.println("BO_InvalidDateMonth - "+actual);
		
		Assert.assertEquals("Invalid date entered. Amend to proceed.", actual);
		
	    	quitBrowser(); 
	
		
	}

}
