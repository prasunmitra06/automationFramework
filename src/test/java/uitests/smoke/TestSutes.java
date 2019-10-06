package uitests.smoke;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.WebElementsUtils;

public class TestSutes extends BaseTest
{
    private WebElement element;

    @Parameters({ "expected_text" })
    @Test(groups = { "Smoke", "TestModule" })
    public void testMethod(String expected_text)
    {
    	WebElementsUtils we = new WebElementsUtils();
    	
    	try {
			System.out.println("Hi: "+we.readXLSXFile(1, 1).getStringCellValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	try {
			we.TextBoxOrTextArea(driver, we.locatorParser(we.readXLSXFile(1, 0).getStringCellValue()), we.readXLSXFile(1, 1).getStringCellValue());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
 
        try {
			we.buttonElement(driver, we.locatorParser(we.readXLSXFile(2, 0).getStringCellValue()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
			we.readXLSXFile(1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Assert.assertTrue(driver.getPageSource().contains(expected_text), "Expected text not found on page!");
    }
}
