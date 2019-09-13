package DeleteRecord;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DeleteRecord extends Wrapper_methods{
	
	@Test
	
	public void DeleteRecord() throws IOException, InterruptedException{
		
		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
		
		SingleSignOn();
		
		Thread.sleep(3000);
		
		clickbyXpath("//div[@class='table table-responsive']/table/tbody/tr[1]/td[2]/a");
		Thread.sleep(3000);
		clickbyLinkText("Edit in Discovery");
		
		driver.executeScript("scroll(0,400)");
		 
		 clickbyLinkText("Delete this record");
		 Thread.sleep(3000);
		 driver.switchTo().alert().accept();
		 Thread.sleep(3000);
		 selectbyvisibletext_Byname("Reason", "Inaccurate catalogue information");
		 Thread.sleep(5000);
		 clickbyXpath("//button[@name='button']");
		 Thread.sleep(5000);
		 String Actual =getTextByXpath("//div[@class='breather holding-box']");
		 
		 System.out.println(Actual);
		 
		 //Assert.assertTrue("London Metropolitan Archives: City of LondonBrowse repositories", Actual);
		 
		 Assert.assertTrue(Actual.contains("London Metropolitan Archives: City of London"));
		 
	}
}
