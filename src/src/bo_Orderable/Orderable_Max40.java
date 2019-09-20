package bo_Orderable;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class Orderable_Max40 extends Wrapper_methods{
	@Test
	public void Orderable_Max40 () throws IOException{
		
		GetBulkOrderURL();
		
		enterTextById("ReaderTicket", "8173355");
		//enter the date 
		SelectTheDate();
		/*selectbyvisibletext_Byname("DateOfVisitDay", "19");
		selectbyvisibletext_Byname("DateOfVisitMonth", "July");
		selectbyvisibletext_Byname("DateOfVisitYear", "2018");*/
		
		//Enter series 
		
		enterTextById("Series", "CAB 120");
		
		//enter the documenet reference id
		
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
				enterTextById("DocumentReference22", "CAB 120/22");
				enterTextById("DocumentReference23", "CAB 120/23");
				enterTextById("DocumentReference24", "CAB 120/24");
				enterTextById("DocumentReference25", "CAB 120/25");
				enterTextById("DocumentReference26", "CAB 120/26");
				enterTextById("DocumentReference27", "CAB 120/27");
				enterTextById("DocumentReference28", "CAB 120/28");
				enterTextById("DocumentReference29", "CAB 120/29");
				enterTextById("DocumentReference30", "CAB 120/30");
				enterTextById("DocumentReference31", "CAB 120/31");
				enterTextById("DocumentReference32", "CAB 120/32");
				enterTextById("DocumentReference33", "CAB 120/33");
				enterTextById("DocumentReference34", "CAB 120/34");
				enterTextById("DocumentReference35", "CAB 120/35");
				enterTextById("DocumentReference36", "CAB 120/36");
				enterTextById("DocumentReference37", "CAB 120/37");
				enterTextById("DocumentReference38", "CAB 120/38");
				enterTextById("DocumentReference39", "CAB 120/39");
				enterTextById("DocumentReference40", "CAB 120/40");
				
				
				
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
			    
			    
			  String text =  getTextByXpath("//div[@class='emphasis-block success']");
			  
			  System.out.println(text);
			  
			  Assert.assertTrue(text.contains("Your bulk order has been successfully submitted."));
			  
			  
			  quitBrowser();
				
		
				
	}
	
	}
	
	


