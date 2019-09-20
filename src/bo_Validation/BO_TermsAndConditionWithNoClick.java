package bo_Validation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BO_TermsAndConditionWithNoClick extends Wrapper_methods{
	@Test
	public void BO_TermsAndConditionWithNoClick() throws IOException{
		
		GetBulkOrderURL();
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "17");
		selectbyvisibletext_Byname("DateOfVisitMonth", "August");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		enterTextById("Series", "CAB 120");
		//enter the documenet reference id
		
		//enterTextById("DocumentReference1", "adm 1/1");
		enterTextById("DocumentReference1", "CAB 120/1");
		enterTextById("DocumentReference2", "CAB 120/2");
		enterTextById("DocumentReference3", "CAB 120/3");
		enterTextById("DocumentReference4", "CAB 120/4");
		enterTextById("DocumentReference5", "CAB 120/5");
		enterTextById("DocumentReference6", "CAB 120/6");
		enterTextById("DocumentReference7", "CAB 120/7");
		enterTextById("DocumentReference8", "CAB 120/8");
		enterTextById("DocumentReference9", "CAB 120/9");
		enterTextById("DocumentReference10", "CAB 120/10");
		enterTextById("DocumentReference11", "CAB 120/11");
		enterTextById("DocumentReference12", "CAB 120/12");
		enterTextById("DocumentReference13", "CAB 120/13");
		enterTextById("DocumentReference14", "CAB 120/14");
		enterTextById("DocumentReference15", "CAB 120/15");
		enterTextById("DocumentReference16", "CAB 120/16");
		enterTextById("DocumentReference17", "CAB 120/17");
		enterTextById("DocumentReference18", "CAB 120/18");
		enterTextById("DocumentReference19", "CAB 120/19");
		enterTextById("DocumentReference20", "CAB 120/20");
		enterTextById("DocumentReference21", "CAB 120/21");
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//enter by invalid id
		
		enterTextById("EmailAddress", "tnadiscovery100@gmail.com");
		
		//click term and conditions
		
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    
		   String actual = getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		   
		   System.out.println("BO_TermsAndConditionWithNoClick - "+actual);
		  Assert.assertEquals("Read and tick privacy statement box.", actual);
		   
		//quitBrowser();
	
		
	}

}
