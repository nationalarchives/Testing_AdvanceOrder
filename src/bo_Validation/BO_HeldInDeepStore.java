package bo_Validation;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_HeldInDeepStore extends Wrapper_methods{
	@Test
	public void BO_HeldInDeepStore() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date
		SelectTomorrowsDate();
		/*LocalDate futureDate= LocalDate.now().plusDays(2);

		if(futureDate.getDayOfWeek() == DayOfWeek.SUNDAY || futureDate.getDayOfWeek() == DayOfWeek.MONDAY)
		{
			futureDate = futureDate.plusDays(2);
		}

		selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(futureDate.getDayOfMonth()));
		selectbyvisibletext_Byname("DateOfVisitMonth", futureDate.getMonth().toString());
		selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));*/
		//SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "14");
		selectbyvisibletext_Byname("DateOfVisitMonth", "July");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "MAF 13");
		//enter the documenet reference id

		enterTextById("DocumentReference1", "MAF 13/3");

		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		 	    
	    String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_HeldInDeepStore - "+actual);
		   
		   Assert.assertEquals("Documents held offsite require three working days for delivery. Select a new date.", actual);
		   
		//quitBrowser();
	    
		
	}

}
