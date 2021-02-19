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

public class MercuryToursTest1 {
	public WebDriver driver ;
	public Select dropdownmenu;
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
		
  @BeforeSuite
  public void beforeSuite() throws Exception{
	  System.out.println("Browser launched in BeforeSuite");
	 //Opening mercury tours site
	    String driverPath = "C:\\Users\\lalit\\Downloads\\chromedriver_win32\\chromedriver.exe";
	     System.setProperty("webdriver.chrome.driver", driverPath);
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      Properties envprop = readPropertiesFile("C:\\Users\\lalit\\workspace\\TestNGProject\\src\\resource\\Environment\\env.properties");
	    		  
	      switch(envprop.getProperty("Browser1")){
			case "CHROME": System.out.println("Chrome");
			break;
		
			case "FF": System.out.println("FF");
			break;
			
			default: System.out.println("supportable browsers are FF & Chrome only");
			break;
			}
	      
  }
  public  WebElement elementByName(String name){
	  return driver.findElement(By.name(name));
	  
  }
  public  WebElement elementByXpath(String xpath){
	  return driver.findElement(By.xpath(xpath));
	  
  }
  public Properties readPropertiesFile(String fileName) throws IOException {
      FileInputStream fis = null;
      Properties prop = null;
//      String fileName1 = "C:\\Users\\lalit\\workspace\\TestNGProject\\src\\resource\\Data\\data.properties";
//      String fileName2 = "C:\\Users\\lalit\\workspace\\TestNGProject\\src\\resource\\Environment\\env.properties";
      try {
          fis = new FileInputStream(fileName);
          // create Properties class object
          prop = new Properties();
          // load properties file into it
          prop.load(fis);

      } catch (FileNotFoundException e) {

          e.printStackTrace();
      } catch (IOException e) {

          e.printStackTrace();
      } finally {
          fis.close();
      }


      return prop;
  }

  @Test
  public void f1() throws Exception{
	  System.out.println("f1-Started");
	  Properties prop = readPropertiesFile("pathforpropfile");
	  prop.getProperty("Browser1");
//	  Thread.sleep(1000); 
}

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Browser closed in AfterSuite");
	  driver.quit();
  }

}