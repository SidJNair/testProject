package testcases;

import org.testng.annotations.Test;

import constants.Constants;
import elementRepositoryforPages.LoginPage;
import excelRead.ExcelRead;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginPageTestClass extends BaseClass
{  
	
	
  @Test( priority=1)
  public void websiteisdisplayed() 
  {
	  LoginPage loginobj= new LoginPage(driver);
	  boolean usernamestatus= loginobj.usernamedisplayed();
	  Assert.assertTrue(usernamestatus);
	  
	  boolean passwordstatus= loginobj.passwordisDisplayed();
	  Assert.assertTrue(passwordstatus);		
	  
	  
  }  
  
  @Test( priority=2)
  public void loginPageInvalidUsernameCorrectPassword() throws Exception 
  {
	  LoginPage loginobj= new LoginPage(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  loginobj.typeusername(excelobj.readingStringData(0, 1));
	  loginobj.typepassword(excelobj.readingStringData(3, 1));
	  loginobj.clickloginbutton();
	  
	  boolean alerticonstatus= loginobj.alertIconIsDisplayed();
	  Assert.assertTrue(alerticonstatus);
	  
	  loginobj.clearloginpage();
	  
  }
  
  
  @Test( priority=3)
  public void loginPageCorrectUsernameInvalidPassword() throws IOException 
  {
	  LoginPage loginobj= new LoginPage(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  loginobj.typeusername(excelobj.readingStringData(2, 1));
	  loginobj.typepassword(excelobj.readingStringData(1, 1));
	  loginobj.clickloginbutton();
	  
	  boolean alerticonstatus= loginobj.alertIconIsDisplayed();
	  Assert.assertTrue(alerticonstatus);
	  
	  loginobj.clearloginpage();   	  
	  
	  
  }
  
  @Test( priority=4)
  public void loginPageCorrectUsernamePassword() throws Exception 
  {
	  LoginPage loginobj= new LoginPage(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  loginobj.typeusername(excelobj.readingStringData(2, 1));
	  loginobj.typepassword(excelobj.readingStringData(3, 1));
	  loginobj.clickloginbutton();
	  
	  System.out.println(driver.getTitle());
	  System.out.println(Constants.title);
	  
	  String actualtitle=driver.getTitle();
	  String expectedtitle=Constants.title;
	  
	  Assert.assertEquals(actualtitle, expectedtitle);
	  
	  
  }
  
 
  
  
  


}
