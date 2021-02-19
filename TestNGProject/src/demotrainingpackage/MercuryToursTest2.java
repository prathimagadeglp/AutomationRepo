package demotrainingpackage;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import org.openqa.selenium.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MercuryToursTest2 {
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
  public  WebElement elementByName(String name){
	  return driver.findElement(By.name(name));
  }
  public WebElement elementByid(String id){
	  return driver.findElement(By.id(id));
  }
 
  public  WebElement elementByXpath(String xpath){
	  return driver.findElement(By.xpath(xpath));
	  
  }

  @Test
  public void f1() throws Exception{
	  System.out.println("f1-Started");
	  elementByid("twotabsearchtextbox").sendKeys("mouse"); 
	  //emailField.clear();
	  elementByXpath("//*[@id='nav-search-submit-button']").click();
//	  Thread.sleep(3000);
//      elementByXpath("//*[@id='B013WC0P2A-best-seller-label']/span/span")
	   
}

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Browser closed in AfterSuite");
	  driver.quit();
  }

}