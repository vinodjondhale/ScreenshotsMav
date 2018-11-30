package library;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

public class BaseTest implements Constants {
public WebDriver driver;
@BeforeMethod
public void before() 
{
		System.setProperty(CHROME_DRIVER, CHROME_PATH);
		driver= new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
}
@AfterMethod
public void closeBrowser(TestResult t) 
{
	if (t.getStatus()==2) {
		try {
			Photo.getScreenshot(driver, IMG_PATH);
		} catch (Exception e) {
			
		}
	}
driver.close();	
}
}
