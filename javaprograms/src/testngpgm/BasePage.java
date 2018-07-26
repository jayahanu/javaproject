package testngpgm;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{

	    public static WebDriver driver;
		public static final String path="./Config.properties";
		
		public static String getData(String Key) throws Exception
		{
		   File f=new File(path);
		   FileInputStream fis=new FileInputStream(f);
		   Properties p= new Properties();
		   p.load(fis);
		   return p.getProperty(Key);
		}
		
		
		public static void browserLaunch(String browser,String url)
		{
			if(browser.equalsIgnoreCase("CHROME"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.navigate().to(url);
			
			

	}
		
		
		
		public void elementVisible(int time,WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public void selectOption(WebElement element, int option)
		{
			Select sel=new Select(element);
			sel.selectByIndex(option);
		}

}