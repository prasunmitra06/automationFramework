package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsUtils {
	
	
	//Text box/Text areas
	
	public void TextBoxOrTextArea(WebDriver driver, By locator, String value)
	{
		WebElement field = new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOfElementLocated(locator));
		field.clear();
		field.sendKeys(value);
	}
	
	public void buttonElement(WebDriver driver, By locator)
	{
		WebElement element = driver.findElement(locator); 
        element.submit();
	}
	
	//Radio Button
	
	public void RadioButton(WebDriver driver, By locator,String attributeVal, String value)
	{
		List<WebElement> select = driver.findElements(locator);

		for (WebElement radio : select){
		if (radio.getAttribute(value).equalsIgnoreCase(value))
		radio.click();
		}
	}
	
	//Checkboxes
	public void CheckBoxes(WebDriver driver, By locator,String attributeVal, String value)
	{
		 List <WebElement> li= driver.findElements(locator);
	        System.out.println(li.size());
	                for(int i=0;i<=li.size()-1;i++)
	                {
	                    li.get(i).click();
	                }

	}
	
	//Drop-down
	public void DropDown(WebDriver driver, By locator,String value)
	{
		Select select= new Select (driver.findElement(locator));
		select.selectByVisibleText(value);
	}
	
	//Auto-suggest Search Drop Down
	public void AutoSuggestSearchDropDown(WebDriver driver, By locator,String value)
	{
		driver.findElement(locator).click();
		driver.findElement(locator).sendKeys(value);
		driver.findElement(locator).sendKeys(Keys.TAB);
	}
	
	//File Upload
	public void FileUpload(WebDriver driver, By locator,String value)
	{
		driver.findElement(locator).sendKeys(value);
	}
	
	
	//Read file from excel 
	public static XSSFCell readXLSXFile(int rowNo, int colNo) throws IOException
    {
        InputStream ExcelFileToRead = new FileInputStream("C:\\Automation\\custom-testng-reporter-master\\dataSources.xlsx");
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook(); 
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row; 
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();
        return wb.getSheetAt(0).getRow(rowNo).getCell(colNo);
    } 
	
	
	
	public static By locatorParser(String locator) {

		By loc = By.id(locator);

		if (locator.contains("id"))
		    loc = By.id(locator.substring(locator.indexOf("\"") + 1,
		        locator.length() - 2));

		else if (locator.contains("name"))
		    loc = By.name(locator.substring(locator.indexOf("\"") + 1,
		        locator.length() - 2));

		if (locator.contains("xpath"))
		    loc = By.xpath(locator.substring(locator.indexOf("\"") + 1,
		        locator.length() - 2));

		return loc;

		}
	
	
	
}
