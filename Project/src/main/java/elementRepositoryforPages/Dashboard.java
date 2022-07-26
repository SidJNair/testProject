package elementRepositoryforPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard
{
	
	WebDriver driver;
	
	@FindBy (xpath="(//li[@class='nav-item has-treeview'])[4]")
	WebElement settingsbutton;
	
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[12]")
	WebElement logoutbutton;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement adminbutton;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	WebElement poweroffbutton;
	
	@FindBy(xpath="(//a[text()='More info '])[1]")
	WebElement managepages;
	
	@FindBy(xpath="(//i[@class='fas fa-edit'])[2]")
	WebElement editpagebutton;
	
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement descriptionbox;
	
	@FindBy(xpath="//input[@name='main_img']")
	WebElement uploadbutton;
	
	@FindBy(xpath="//button[@name='update']")
	WebElement updatebutton;
	
	@FindBy(xpath="//i[@class='icon fas fa-check']")
	WebElement alertmessagetickicon;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement titlebox;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="//input[@id='page']")
	WebElement pagebox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;
	
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")
	WebElement deletebutton;
	
	public void clicksettingsbutton() 
	{
		settingsbutton.click();
	}
	
	public void clicklogoutbutton() 
	{
		logoutbutton.click();
	}
	
	public void clickadminbutton() 
	{
		adminbutton.click();
	}
	
	public void poweroffbutton() 
	{
		poweroffbutton.click();
	}
	
	public void clickManagePages() 
	{
		managepages.click();
	}
	
	public void editpagebutton() 
	{
		editpagebutton.click();
	}
	
	public void clicknewbutton() 
	{
	    newbutton.click();	
	}
	
	public void typeDescriptionBox(String text) 
	{
		descriptionbox.sendKeys(text);
	}
	
	public void uploadbuttonsend(String text) 
	{
		uploadbutton.sendKeys(text);
	}
	
	public void clickupdatebutton() 
	{
		updatebutton.click();
	}
	
	public boolean checkalerttickiconisdisplayed()
	{
		boolean alerticontickvalue= alertmessagetickicon.isDisplayed();
		return alerticontickvalue;
	}
	
	public void scroll() 
	{
		 JavascriptExecutor js =(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void clickHome() 
	{
		home.click();
	}
	
	public void typetitlebox(String text) 
	{
		titlebox.sendKeys(text);
	}
	
	public void typepagebox(String text) 
	{
		pagebox.sendKeys(text);
	}
	
	public void clicksavebutton() 
	{
		savebutton.click();
	}
	
	public void navigateBack() 
	{
		driver.navigate().back();
	}
	
	public void explicitWaitMethodupdatebutton() 
	{
		WebDriverWait explicitwait= new WebDriverWait(driver,Duration.ofSeconds(10));
		explicitwait.until(ExpectedConditions.elementToBeClickable(updatebutton));
	}
	
	public void explicitWaitMethodsavebutton() 
	{
		WebDriverWait explicitwait= new WebDriverWait(driver,Duration.ofSeconds(10));
		explicitwait.until(ExpectedConditions.elementToBeClickable(savebutton));
		
	}
	
	public void clickDeleteButton() 
	{
		deletebutton.click();
	}
	
	public void alertAccept() 
	{
		  Alert alertobj= driver.switchTo().alert();
		  alertobj.accept();
	}
	
	public void clearTitle() 
	{
		titlebox.clear();
	}
	
	public void clearDescriptionBox() 
	{
		descriptionbox.clear();
	}
	
	public void clearPageBox() 
	{
		pagebox.clear();
	}
	public Dashboard(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
