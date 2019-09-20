package ad_Orderable;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OD_12Documents extends wrappers.Wrapper_methods{
	@Test
	public void OD_12Documents() throws IOException, InterruptedException{
		
		launchDriver("https://test.nationalarchives.gov.uk/order-documents-in-advance/", "chrome");
		//enter reader ticket number
		
		enterTextById("ReaderTicket", "100");
		
		//enter the date 
			
		
		SelectTheDate();
				
		
      /* LocalDate futureDate=LocalDate.now().plusDays(4);
		
		if(futureDate.getDayOfWeek() == DayOfWeek.SUNDAY || futureDate.getDayOfWeek() == DayOfWeek.MONDAY)
		{
			futureDate = futureDate.plusDays(2);
		}
		
			
		selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(futureDate.getDayOfMonth()));
		
		String month = futureDate.getMonth().toString();
				
		selectbyvisibletext_Byname("DateOfVisitMonth", String.format("%s%s", month.charAt(0), month.substring(1).toLowerCase()));
			
		selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));*/
			
			
			/*LocalDate futureDate=LocalDate.now().plusDays(4);

			if(futureDate.getDayOfWeek() == DayOfWeek.SUNDAY || futureDate.getDayOfWeek() == DayOfWeek.MONDAY)
			{
				futureDate = futureDate.plusDays(2);
			}
			
			selectbyvisibletext_Byname("DateOfVisitDay", Integer.toString(futureDate.getDayOfMonth()));
			selectbyvisibletext_Byname("DateOfVisitMonth", futureDate.getMonth().toString());
			selectbyvisibletext_Byname("DateOfVisitYear", Integer.toString(futureDate.getYear()));*/
		
		//enter the documenet reference id
		
		enterTextById("DocumentReference1", "adm 1/1");
		enterTextById("DocumentReference2", "WO 374/2264");
		enterTextById("DocumentReference3", "WO 339/59170");
		enterTextById("DocumentReference4", "WO 374/10464");
		enterTextById("DocumentReference5", "WO 374/10474");
		enterTextById("DocumentReference6", "WO 374/10482");
		enterTextById("DocumentReference7", "WO 339/98317");
		enterTextById("DocumentReference8", "WO 339/99948");
		enterTextById("DocumentReference9", "WO 339/106899");
		enterTextById("DocumentReference10", "WO 339/110570");
		enterTextById("DocumentReference11", "WO 339/72331");
		enterTextById("DocumentReference12", "WO 339/92801");
		
		//enter full name
		
		enterTextById("FullName", "Testing#TestingForAdvanceOrderForm");
		//enter phone number
		
		enterTextById("TelephoneNumber", "078012876");
		
		//click term and conditions
		//(Removed on 12 june 2018)
		//clickbyID("TermsAndConditions");
		
		//click to continue
		
	    clickbyXpath("//input[@value='Continue']");
		
	    //click complete order
	    
	    clickbyXpath("//input[@value='Complete order']");
	  
	    //get order complete text
	    
	    String actual =getTextByXpath("//div[@class='entry-content clearfix']/p[1]");
	   // String actual1 =getTextByXpath("//div[@class='entry-content clearfix']/p[2]");
	    
	    System.out.println("OD_12Documents.java"+actual);
	    //System.out.println(actual1);
	    
	    Assert.assertEquals(actual,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	   
	    //Assert.assertEquals(actual1,"If you have entered your email address, you will receive an email confirmation of your order. You can also print this page.");
	//quitBrowser();   
	
	    Thread.sleep(5000);
	    
	    driver.navigate().refresh();
	    
	    String actual1= getTextByXpath("//div[@class='entry-header']");
		  
		  System.out.println(actual1);
		  
		  Assert.assertEquals(actual1,"Order documents in advance");
		
	}

	private void toString(int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}

	private void selectbyvisibletext_Byname(String name, int monthValue) {
		// TODO Auto-generated method stub
		
	}

			

}
