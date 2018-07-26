package testngpgm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Firsttestng 
{	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--default-argument-");
		driver=new ChromeDriver(co);
		{
		driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://accounts.google.com/signin/v2/sl/pwd?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
  }
  }
  @Test
  public void f() throws Exception
  {
	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("jayalakshmi.kommi@gmail.com");
	driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("hanujaya");
	driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
  }

  @AfterMethod
  public void afterMethod()
  {
	  
  }

}
