package MYC_InvalidUpload;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ValidationCheck_XlsFormat extends Wrapper_methods{
	
	@Test
	
	public void XlsFormat() throws IOException, InterruptedException{
		
		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
		
		SingleSignOn();
		
		clickbyXpath("//table[@id='tblActions']/tbody/tr[1]");
		
		clickbyLinkText("Add a collection");
		
		Thread.sleep(3000);
		
		clickbyLinkText("Upload file");
		Thread.sleep(3000);
		clickbyXpath("//div[@class='breather']/label/strong");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\AutoIt_MYC\\DiscoveryFormsXlsFormat.exe");
		//Runtime.getRuntime().exec("./AUTOIT/ChangeColumName.exe");
		Thread.sleep(3000);
		clickbyXpath("//input[@value='Upload']");
		Thread.sleep(3000);
		clickbyLinkText("View history");
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		Thread.sleep(3000);
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		Thread.sleep(3000);
		
		String actual =getTextByXpath("(//span[@class='warning'])[1]");
		System.out.println(actual);
		
		Assert.assertTrue(actual.contains("There was a problem with our system; please try again later.(If you are seeing this error repeatedly, contact us)"));
		/*clickbyLinkText("See error report >");
		Thread.sleep(3000);
		String Actual_Error = getTextByXpath("(//div[@class='table table-responsive'])[2]");
		
		System.out.println("InvalidFile"+Actual_Error);
		
		String errorType =getTextByXpath("//*[@id='page_wrap']/div/div/div[2]/h3");
		
		System.out.println(errorType);
		
		
	
	    quitBrowser();*/
		
		
		
		
	}
	
	

}
