package testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositoryforPages.Dashboard;
import elementRepositoryforPages.LoginPage;
import excelRead.ExcelRead;

public class DashboardTestClass extends BaseClass
{
	
  @Test(priority=5)
  public void Logoutbutton() throws IOException
  {
	  Dashboard dashobj= new Dashboard(driver);
	  ExcelRead excelobj= new ExcelRead();
	  LoginPage loginobj= new LoginPage(driver);
	  
	  loginobj.typeusername(excelobj.readingStringData(2, 1));
	  loginobj.typepassword(excelobj.readingStringData(3, 1));
	  loginobj.clickloginbutton();
	 
	  dashobj.clickadminbutton();
	  dashobj.poweroffbutton();
	  
	  String loginpageurl=Constants.homeurl;
	  String actualurl= driver.getCurrentUrl();
	  
	  Assert.assertEquals(actualurl, loginpageurl);
	  
	  loginobj.typeusername(excelobj.readingStringData(2, 1));
	  loginobj.typepassword(excelobj.readingStringData(3, 1));
	  loginobj.clickloginbutton();
	  
  }
  
  @Test(priority=6)
  public void editaPage() throws IOException 
  {
	  Dashboard dashobj= new Dashboard(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  dashobj.clickManagePages();
	  dashobj.editpagebutton();
	  dashobj.typeDescriptionBox(excelobj.readingStringData(4, 1));
	  dashobj.uploadbuttonsend(Constants.uploadpath);
	  
	  dashobj.scroll();
	  
	  dashobj.clickupdatebutton();
	  
	  boolean tickiconstatus=dashobj.checkalerttickiconisdisplayed();
	  Assert.assertTrue(tickiconstatus);  
	  
   }
  
  
  
}
