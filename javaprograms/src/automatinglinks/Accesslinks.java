package automatinglinks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Accesslinks 
{	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 
	}
	//in access links we have 6 types of links 
	//these are the 6 test cases
	
	@Test(priority=0,enabled=false)
	public void Exactmatch() 
	{
		driver.get("http://demo.guru99.com/test/link.html");
	 	driver.findElement(By.linkText("click here")).click();
	 	System.out.println("Title of the page:"+driver.getTitle());
	}
	@Test(priority=1,enabled=false)
	public void partialmatch()
	{
		driver.get("http://demo.guru99.com/test/link.html");
		driver.findElement(By.partialLinkText("here")).click();
		System.out.println("url of that page:"+driver.getCurrentUrl());
	}
	
  @Test(priority=2,enabled=false)
  public void casesensitive()
  {
	  driver.get("http://demo.guru99.com/test/newtours/");
	  String element = driver.findElement(By.partialLinkText("EGIST")).getText();
	  element=driver.findElement(By.partialLinkText("egist")).getText();
	  System.out.println("I want text :"+element);
	  
	  
  }
  @Test(priority=3,enabled=false)
  public void alllinks()
  {
	  driver.get("http://demo.guru99.com/test/newtours/");
	  String underconstitle = "under construction:mercury tours";
	  List<WebElement> linkelements = driver.findElements(By.tagName("a"));
	 String[] linktext=new String[linkelements.size()];
	 int i=0;
	 for(WebElement e:linkelements)
	 {
		linktext[i]=e.getText();
		i++;
	 }
	 for(String t:linktext)
	 {
		driver.findElement(By.linkText(t)).click();
		if(driver.getTitle().equals("underconstitle"))
		{
			 System.out.println("\"" + t + "\"" + "under construction");
		}else
		{
			System.out.println("\"" + t + "\"" + "is working");
		
		}
		
	 }
	  
  }
  @Test(priority=4,enabled=false)
  public void outsideandinside()
  {	
	  driver.get("http://demo.guru99.com/test/block.html");
	  
	  driver.findElement(By.partialLinkText("Inside")).click();
	  System.out.println(driver.getTitle());
	  driver.navigate().back();
	  driver.findElement(By.partialLinkText("Outside")).click();
	  System.out.println(driver.getTitle());
	  
  }
  @Test(priority=5)
  public void accesingimglinks()
  {
	  driver.get("https://www.facebook.com/login/identify?ctx=recover");
	 driver.findElement(By.cssSelector("a[title='Go to Facebook home']")).click();
	 if(driver.getTitle().equals("Facebook - log in or sign up"))
	 {
		 System.out.println("u r in facebook page");
	 }
	 else
	 {
		 System.out.println("u r not in facebook page");
	 }
  }

	@AfterMethod
	public void afterMethod() 
	{
	  
	}

}
