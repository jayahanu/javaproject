package testngpgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		//Print title of a page
		String title = (String)js.executeScript("return document.title");
		System.out.println("title :"+title);
		
		js.executeScript("document.getElementById('email').value='jayalakshmi.kommi@gmail.com'");
		js.executeScript("document.getElementById('pass').value='hanujaya'");
		js.executeScript("document.getElementById('loginbutton').click();");
		
		String str = js.executeScript("return document.title").toString();
		System.out.println(str);
		
		WebElement frnd = driver.findElement(By.xpath(".//*[@id='navItem_1572366616371383']/a"));
		js.executeScript("arguments[0].click();",frnd);
		
		WebElement allfrnd = driver.findElement(By.xpath("//a[contains(text(),'All Friends')]"));
		js.executeScript("arguments[0].click();",allfrnd);
		
		  while(true)
		  {
			   List<WebElement> flBS = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
			  System.out.println("Total Friends :"+flBS.size());
			   
			  
			   List<WebElement> flAS = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
			   
			   

			   for(WebElement e:flAS) {
				   System.out.println(e.getText());
				   
			   }
			   if(flBS.size()==flAS.size())
			   {
				   //print names - all friends
				   
				   break;
				   
			   }
		  }


	}

}
