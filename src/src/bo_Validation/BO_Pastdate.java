package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_Pastdate extends Wrapper_methods{
	@Test
	public void BO_Pastdate() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		//SelectTheDate();
		selectbyvisibletext_Byname("DateOfVisitDay", "30");
		selectbyvisibletext_Byname("DateOfVisitMonth", "March");
		selectbyvisibletext_Byname("DateOfVisitYear", "2019");
		/*selectbyvisibletext_Byname("DateOfVisitDay", "9");
		selectbyvisibletext_Byname("DateOfVisitMonth", "January");
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
		   
		   System.out.println("BO_Pastdate - "+actual);
		  Assert.assertEquals("Order date must be in the future. Select a new date.", actual);
		   
		quitBrowser();     
	
		
	}

}
