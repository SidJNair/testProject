package testcases;

import org.testng.annotations.Test;

import generalUtility.GeneralUtilityClass;
import generalUtility.Screenshot;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	WebDriver driver;
	GeneralUtilityClass utilobj = new GeneralUtilityClass();
	Screenshot sh= new Screenshot();
	
	public static Properties po;
	  
	
	public static void testBasic() throws Exception  
	  {
		po = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\propertyFiles\\Confuguration.properties");
		po.load(file);
	}

		
		
	  
	

  @BeforeMethod
  public void beforeMethod() 
  {
	  
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws Exception
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
	  
		//  String resultName=result.getName();
	//	  sh.screenshotMethod(resultName, driver);
		  
		  
		  
		  Date d = new Date();
		  String date = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source, new File("F:\\Workspace-Automation\\Project\\src\\test\\resources\\Screenshots"+result.getName()+date));
		  System.out.println("Screenshot taken");
		  
		  
			 
	  }
	  
	  
  }
  
  @Parameters({"browser"}) 
  @BeforeClass
  public void beforeclass(String browser) throws Exception
  {
		 testBasic();
	     System.out.println(po.getProperty("URL"));
		 driver= utilobj.browserlaunch(po.getProperty("URL"),browser);
  }

  
  @BeforeTest
  public void beforeTest()
  {   
	  
	 
	   
  }
  
  

  @AfterTest
  public void afterTest() 
  {
	  utilobj.quitbrowser();
  }
  
  @AfterClass
  public void afterclass() 
  {
	  utilobj.closeBrowser();
  }

}
