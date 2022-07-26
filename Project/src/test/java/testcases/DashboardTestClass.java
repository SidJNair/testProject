package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositoryforPages.Dashboard;
import elementRepositoryforPages.LoginPage;
import excelRead.ExcelRead;

public class DashboardTestClass extends BaseClass
{
	
  @Test(priority=5, description="Checking Logout functionality")
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
  
  @Test(priority=6, description= "Editing a page under Manage Pages")
  public void editaPage() throws IOException 
  {
	  Dashboard dashobj= new Dashboard(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  dashobj.clickManagePages();
	  dashobj.editpagebutton();
	  
	  dashobj.clearTitle();
	  dashobj.clearDescriptionBox();
	  dashobj.clearPageBox();
	  
	  dashobj.typetitlebox(excelobj.readingStringData(5, 1));
	  dashobj.typeDescriptionBox(excelobj.readingStringData(4, 1));
	  dashobj.typepagebox(excelobj.readingStringData(6, 1));
      dashobj.uploadbuttonsend(Constants.uploadpath);
	  
	  
	  
	  
	  
	  dashobj.scroll();
	  dashobj.explicitWaitMethodupdatebutton();
	  
	  dashobj.scroll();
	  
	  dashobj.clickupdatebutton();
	  
	  boolean tickiconstatus=dashobj.checkalerttickiconisdisplayed();
	  Assert.assertTrue(tickiconstatus);
	  
	  dashobj.clickHome();
	  
   }
  
  @Test(priority=7, description=" Creating a new Page")
  public void addapage() throws Exception 
  {
	  Dashboard dashobj= new Dashboard(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  dashobj.clickManagePages();
	  dashobj.clicknewbutton();
	  dashobj.typetitlebox(excelobj.readingStringData(5, 1));
	  dashobj.typeDescriptionBox(excelobj.readingStringData(4, 1));
	  dashobj.typepagebox(excelobj.readingStringData(6, 1));
      dashobj.uploadbuttonsend(Constants.uploadpath);
	  
	  dashobj.scroll();
	//  dashobj.explicitWaitMethodsavebutton();
	  dashobj.scroll();
	  dashobj.clicksavebutton();
	  
	  dashobj.navigateBack();
	  
	  boolean tickiconstatus=dashobj.checkalerttickiconisdisplayed();
	  Assert.assertTrue(tickiconstatus);
	  
	  dashobj.clickHome();
	  
  }
  
  @Test(priority=8, description=" Deleting a page")
  public void deleteAPage() throws Exception 
  {
	  Dashboard dashobj= new Dashboard(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  dashobj.clickManagePages();
	  dashobj.clickDeleteButton();
	  dashobj.alertAccept();
	  
	  boolean tickiconstatus=dashobj.checkalerttickiconisdisplayed();
	  Assert.assertTrue(tickiconstatus);
	  
	  dashobj.clickHome();
	  
	  
  }
  
  
  
}
