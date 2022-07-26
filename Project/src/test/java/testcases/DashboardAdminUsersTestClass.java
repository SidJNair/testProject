package testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepositoryforPages.DashboardAdminUsers;
import elementRepositoryforPages.LoginPage;
import excelRead.ExcelRead;

public class DashboardAdminUsersTestClass extends BaseClass
{
  @Test(priority=9, description="To change the status of an active admin user to inactive")
  public void changeStatusAdminUser() throws Exception 
  {   
	  LoginPage loginobj= new LoginPage(driver);
	  ExcelRead excelobj= new ExcelRead();
	  DashboardAdminUsers dashadminobj= new DashboardAdminUsers(driver);
	  
	  loginobj.typeusername(excelobj.readingStringData(2, 1));
	  loginobj.typepassword(excelobj.readingStringData(3, 1));
	  loginobj.clickloginbutton();
	  
	  dashadminobj.clickAdminUsers();
	  dashadminobj.clickUnlockIcon();
	  
	  boolean inactivestatusvalue= dashadminobj.checkInactiveStatus();
	  Assert.assertTrue(inactivestatusvalue);
	  
	  dashadminobj.clickHome();
	  
  }
  
  @Test(priority=10, description="To create a new user")
  public void createANewUser() throws Exception 
  {
	  DashboardAdminUsers dashadminobj= new DashboardAdminUsers(driver);
	  ExcelRead excelobj= new ExcelRead();
	  
	  dashadminobj.clickAdminUsers();
	  dashadminobj.clicknewicon();
	  dashadminobj.typeAdminUsername(excelobj.readingStringData(7, 1));
	  dashadminobj.typeAdminPassword(excelobj.readingStringData(8, 1));
	  dashadminobj.selectFromDropdown(excelobj.readingStringData(9, 1));
	  dashadminobj.clicksavebutton();
	  
	  boolean tickiconstatus=dashadminobj.checkalerttickiconisdisplayed();
	  Assert.assertTrue(tickiconstatus);
	  
  }
  
  
}
