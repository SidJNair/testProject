package elementRepositoryforPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//i[@class='icon fas fa-ban']")
	WebElement alerticon;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement closebutton;
	
	public void typeusername(String text) 
	{
		username.sendKeys(text);
		
	}
	
	public void typepassword(String text) 
	{
		password.sendKeys(text);
	}
	
	public void clickloginbutton() 
	{
		loginbutton.click();
	}
	
	public boolean usernamedisplayed() 
	{
		boolean usernamevalue=username.isDisplayed();
		return usernamevalue;
	}
	
	public boolean passwordisDisplayed() 
	{
		boolean passwordvalue=password.isDisplayed();
		return passwordvalue;
	}
	
	public boolean alertIconIsDisplayed() 
	{
		boolean alerticonvalue=alerticon.isDisplayed();
		return alerticonvalue;
				
	}
	
	public void clickclosebutton() 
	{
		closebutton.click();
	}
	
	public void clearloginpage() 
	{
		closebutton.click();
		username.clear();
		password.clear();
	}
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
	

}
