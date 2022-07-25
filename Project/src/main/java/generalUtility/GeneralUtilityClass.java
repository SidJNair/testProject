package generalUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilityClass 
{
WebDriver driver;
	
	public WebDriver browserlaunch(String url, String browsername) 
	{
		if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
		
		
		}
	 public void utilclickcommand(By Property) 
	 {
		 driver.findElement(Property).click();
	 }
	 
	 public void utiltypecommand (By Property, String text) 
	 {
		 driver.findElement(Property).sendKeys(text);
	 }
	 
	 public void utilityclearcommand(By property)
	{
		
			driver.findElement(property).clear();
			
			
	} 
	 
	 public void alertAccept() 
		{
			Alert objectalert = driver.switchTo().alert();
			objectalert.accept();
		}
	 
	 public void alertDismiss() 
	 {
		 Alert objectalert = driver.switchTo().alert();
		 objectalert.dismiss();
	 }
	 
	 public String alertGetText() 
	 {
		 Alert objectalert = driver.switchTo().alert();
		 String alerttext= objectalert.getText();
		 return alerttext;		 
		 
	 }
	 
	 public void closeBrowser() 
	 {
		 driver.close();
	 }
	 
	 public void quitbrowser() 
	 {
		 driver.quit();
	 }

}
