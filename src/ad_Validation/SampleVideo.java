package ad_Validation;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class SampleVideo extends Wrapper_methods {
	@Test
	public void SampleVideo() throws IOException, InterruptedException {

		launchDriver(
				"https://www.w3.org/2010/05/video/mediaevents.html",	"chrome");
	
		JavascriptExecutor js =	(JavascriptExecutor)driver;
		
		js.executeScript("document.getElementById(\"video\").play()");

		
		// quitBrowser();

	}

}
