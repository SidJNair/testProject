package elementRepositoryforPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashboardAdminUsers 
{
	WebDriver driver;
	
	@FindBy(xpath="(//a[text()='More info '])[2]")
	WebElement adminusers;
	
	@FindBy(xpath="(//i[@class='fa fa-unlock'])[1]")
	WebElement unlockicon;
	
	@FindBy(xpath="(//span[text()='Inactive'])[1]")
	WebElement inactivestatus;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	WebElement newicon;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement adminusername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement adminpassword;
	
	@FindBy(xpath="//select[@name='user_type']")
	WebElement dropdown;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement savebutton;
	
	@FindBy(xpath="//i[@class='icon fas fa-check']")
	WebElement alertmessagetickicon;
	
	
	
    public void clickAdminUsers() 
    {
    	adminusers.click();
    }
    
    public void clickUnlockIcon() 
    {
    	unlockicon.click();
    }
    
    public boolean checkInactiveStatus() 
    {
    	boolean statusvalue=inactivestatus.isDisplayed();
    	return statusvalue;
    }
    
    public void clickHome() 
	{
		home.click();
	}
    
    public void clicknewicon() 
    {
    	newicon.click();
    }
    
    public void typeAdminUsername(String text) 
    {
    	adminusername.sendKeys(text);
    }
    
    public void typeAdminPassword(String text) 
    {
    	adminpassword.sendKeys(text);
    }
    
    public void selectFromDropdown(String text) 
    {
    	Select selectobj= new Select(dropdown);
		selectobj.selectByValue(text);
    	
    }
    
    public void clicksavebutton() 
    {
    	savebutton.click();
    }
    
    public boolean checkalerttickiconisdisplayed()
	{
		boolean alerticontickvalue= alertmessagetickicon.isDisplayed();
		return alerticontickvalue;
	}
    
	public DashboardAdminUsers(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
