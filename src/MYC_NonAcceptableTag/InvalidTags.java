package MYC_NonAcceptableTag;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class InvalidTags extends Wrapper_methods{
	
	public Object[][]readExcel(String dataSheetName) throws InvalidFormatException, IOException {


		File src = new File("C:\\Users\\hparupalli\\MYCTestcases\\Data\\MYCinvalidTags.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();

		Object[][]obj = new Object[rowcount][cellcount];

		for(int i=1; i<=rowcount; i++)

		{
		XSSFRow row = sheet.getRow(i);

		for(int j=0; j<cellcount; j++)

		{

		XSSFCell cell = row.getCell(j);
		obj[i-1][j]=cell.getStringCellValue();
		System.out.println(cell.getStringCellValue());
		}
		}


		return obj;
		}

		@Test(dataProvider = "Des")

		
		public void invalidtag(String Description,String Title ,String Note, String Arrangement, String ConditionsGoverningAccess,String Accruals, String BiographicalHistory, String Expected) throws IOException, InterruptedException{
			
			launchDriver("http://test.manage-collections.nationalarchives.gov.uk/", "chrome");
			
			SingleSignOn();
			
			Thread.sleep(3000);
			
			clickbyXpath("//div[@class='table table-responsive']/table/tbody/tr[1]/td[2]/a");
			Thread.sleep(3000);
			clickbyLinkText("Edit in Discovery");
			
			 ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
			 
			 clickbyLinkText("Edit this record");
			 
			 enterTextById("ScopeAndContent",Description );
			 
			 enterTextById("Accruals", Accruals);
			 
			 enterTextById("Note", Note);
			 
			 enterByTextXpath("//input[@id ='Title']", Title);
			 
			 enterTextById("Arrangement", Arrangement);
			 
			 enterTextById("ConditionsGoverningAccess", ConditionsGoverningAccess);
			 
			 enterTextById("BiographicalHistory", BiographicalHistory);
			 
			 
					 
		
		 ((JavascriptExecutor) driver).executeScript("scroll(0,3000)");
		 
		 clickbyXpath("//input[@value='Publish changes'][1]");
		 
		//System.out.println(getTextByXpath("//div[@class='emph-block error-message']"));
		
		String actual = getTextByXpath("//div[@class='field-validation-error form-error']");
		
		System.out.println(actual);
		
		Assert.assertEquals(Expected, actual);
			driver.close();
			
		}

		@DataProvider(name="Des")
		public Object[][] Des() throws Exception{

		return readExcel("MYCInvalidTags");
		}


		}



