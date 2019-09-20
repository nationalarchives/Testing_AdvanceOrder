package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_DigitalRecord extends Wrapper_methods{
	@Test
	public void BO_DigitalRecord() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");
		enterTextById("Series", "hw 25");*/
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "hw 25/37");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
	    
	    String actual = getTextByXpath("//*[@id=\"main\"]/article/div[2]/div[2]/div/ul/li");

		System.out.println("BO_DigitalRecord - "+actual);
		
		Assert.assertEquals("Enter a series number.", actual);
		
	    	quitBrowser(); 
	    
		
	}

}
