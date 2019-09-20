package ad_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class OD_Microfiche_film extends Wrapper_methods{
	@Test
	public void OD_Microfiche_film() throws IOException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "20");
		selectbyvisibletext_Byname("DateOfVisitMonth", "June");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "IR 26/1");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
	   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
	   
	   System.out.println("OD_Microfiche_film.java"+actual);
	   
	   Assert.assertEquals("IR 26/1 - Microfiche or microfilm documents do not need to be ordered. Check the catalogue for more information.", actual);
	   
	quitBrowser();   
	
		
	}

}
