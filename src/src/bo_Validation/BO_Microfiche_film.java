package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_Microfiche_film extends Wrapper_methods{
	@Test
	public void BO_Microfiche_film() throws IOException, InterruptedException {
		
		GetBulkOrderURL();
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		//enter series number
		enterTextById("Series", "SP 36");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "SP 36/27");

		Thread.sleep(4000);
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");


		Thread.sleep(4000);

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
