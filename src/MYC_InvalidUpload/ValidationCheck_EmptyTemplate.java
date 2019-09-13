package MYC_InvalidUpload;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ValidationCheck_EmptyTemplate extends Wrapper_methods{
	
	@Test
	
	public void EmptyTemplate() throws IOException, InterruptedException{
		
		launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
		
		SingleSignOn();
		
		clickbyXpath("//table[@id='tblActions']/tbody/tr[1]");
		
		clickbyLinkText("Add a collection");
		
		Thread.sleep(3000);
		
		clickbyLinkText("Upload file");
		Thread.sleep(3000);
		clickbyXpath("//div[@class='breather']/label/strong");
		Thread.sleep(3000);
		//Runtime.getRuntime().exec("Z:\\Svenkatesh\\TestCases\\MYC\\Data\\Empty file.exe");
		
		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\AutoIt_MYC\\Emptyfile.exe");
		Thread.sleep(3000);
		clickbyXpath("//input[@value='Upload']");
		Thread.sleep(3000);
		clickbyLinkText("View history");
		clickbyXpath("(//button[@class='discoveryPrimaryCallToActionLink'])[2]");
		Thread.sleep(3000);
		clickbyLinkText("See error report >");
		Thread.sleep(3000);
		String Actual_Error = getTextByXpath("(//div[@class='table table-responsive'])[2]");
		
		System.out.println("EmptyTemplate  "+Actual_Error);
		Assert.assertTrue(Actual_Error.contains("Your template is empty - it does not contain any catalogue information."));
		quitBrowser();
		
		
		
		
	}
	
	

}
