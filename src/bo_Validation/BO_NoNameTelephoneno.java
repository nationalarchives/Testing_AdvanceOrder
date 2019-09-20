package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_NoNameTelephoneno extends Wrapper_methods {
	@Test
	public void BO_NoNameTelephoneno() throws IOException, InterruptedException {

		GetBulkOrderURL();
		//enter reader ticket number
		
				enterTextById("ReaderTicket", "100");

		// enter the date
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		Thread.sleep(3000);
		
		enterTextById("Series", "WO 374");
		//Enter document 
		Thread.sleep(3000);
		enterTextById("DocumentReference1", "WO 374/2264");

		// No name

		// No phone number

		// click term and conditions
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		
          enterTextById("EmailAddress", "tnadiscovery100@gmail.com");
		//clickbyID("TermsAndConditions");

		//clickbyXpath("//input[@name='TermsAndConditions'][1]");

		// click to continue

		clickbyXpath("//input[@value='Continue']");

		String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul");

		System.out.println("BO_NoNameTelephoneno - "+actual);

		
		 Assert.assertTrue(actual.contains("Enter name."));
		 Assert.assertTrue(actual.contains("Enter telephone number."));
		 
		  quitBrowser();
		 

	}

}
