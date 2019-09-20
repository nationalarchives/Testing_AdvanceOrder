package bo_Validation;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_InputIncorrect extends Wrapper_methods{
	@Test
	public void BO_InputIncorrect() throws IOException, InterruptedException {
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date


		//SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "nhgukjnhklgy");
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "nhgukjnhklgygulop");

		((JavascriptExecutor) driver).executeScript("scroll(0,1400)");


		//Thread.sleep(4000);
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");

		//Thread.sleep(4000);
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
        //click to continue

	    //clickbyXpath("//input[@name='submit']");

		((JavascriptExecutor) driver).executeScript("scroll(0,3000)");



		driver.findElementByXPath("//form[@id='bulk-order-form']/div/input").click();
		//input[@name='submit']
		String actual = getTextByXpath("//*[@id=\"main\"]/article/div[2]/div[2]/div/ul/li[1]");

		System.out.println("BO_InputIncorrect -"+actual);
		
		//Assert.assertTrue(actual.contains("nhgukjnhklgy - This reference is not recognised. Check the catalogue for more information."));
		Assert.assertTrue(actual.contains("nhgukjnhklgygulop - Check that all catalogue references are from the same document series to submit a bulk order"));

		//nhgukjnhklgygulop - Check that all catalogue references are from the same document series to submit a bulk order.
		
	    	quitBrowser();
	
		
	}

}
