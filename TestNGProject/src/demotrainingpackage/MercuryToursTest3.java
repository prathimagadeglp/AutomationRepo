package demotrainingpackage;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MercuryToursTest3 {
	public WebDriver driver ;
	public Select dropdownmenu;
	public String baseUrl = "http://amazon.com";
		
  @BeforeSuite
  public void beforeSuite() throws Exception{
	  System.out.println("Browser launched in BeforeSuite");
	 //Opening Amazon site
	    String driverPath = "C:\\Users\\lalit\\Downloads\\chromedriver_win32\\chromedriver.exe";
	     System.setProperty("webdriver.chrome.driver", driverPath);
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      
  }
//  public  WebElement elementByName(String name){
//	  return driver.findElement(By.name(name));
//  }
//  public WebElement elementByid(String id){
//	  return driver.findElement(By.id(id));
//  }
// 
//  public  WebElement elementByXpath(String xpath){
//	  return driver.findElement(By.xpath(xpath));
//	  
//  }

//  @Test
//  public void test1 () throws InterruptedException 
//  {
//	  try{
//	  // Store all link elements (anchor tag elements in html) in a list
//	  List<WebElement> links = driver.findElements(By.tagName("a"));
//
//	  // Print no. of links stored in list
//	  System.out.println(links.size());
//	  for (WebElement pagelink : links)
//	  {
//          String linktext = pagelink.getText();
//          String link = pagelink.getAttribute("href"); 
//          System.out.println(linktext+" ->");
//          System.out.println(link);
//	  }
//	  
//	  }catch (Exception e){
//		  System.out.println("error "+e);
//	  }
// }
  
  @Test
  public void imageverify()
  {
   
    WebElement ImageFile = driver.findElement(By.xpath("//*[@id='Profile1']/div/a[1]/img"));
           
           Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
           if (!ImagePresent)
           {
                System.out.println("Image not displayed.");
           }
           else
           {
               System.out.println("Image displayed.");
           }
    }
  
  @AfterSuite
  public void afterSuite() {
	  System.out.println("Browser closed in AfterSuite");
	  driver.quit();
  }

}