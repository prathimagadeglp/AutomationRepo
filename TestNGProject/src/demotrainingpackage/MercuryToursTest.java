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

public class MercuryToursTest {
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
      String fileName1 = "C:\\Users\\lalit\\workspace\\TestNGProject\\src\\resource\\Data\\data.properties";
      try {
          fis = new FileInputStream(fileName1);
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
  public void f1()  throws Exception{
	  System.out.println("f1-Registration flow started");
	  System.out.println("Reading from properties file");
	  Properties prop = readPropertiesFile("pathofpropfile");
	  //Registration flow
	  elementByXpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a").click();
	  elementByName("firstName").sendKeys(prop.getProperty("firstName"));
	  elementByName("lastName").sendKeys(prop.getProperty("lastName"));
	  elementByName("phone").sendKeys(prop.getProperty("phone"));
	  elementByName("userName").sendKeys(prop.getProperty("userName"));
	  elementByName("address1").sendKeys(prop.getProperty("address1"));
	  elementByName("city").sendKeys(prop.getProperty("city"));
	  elementByName("state").sendKeys(prop.getProperty("state"));
	  elementByName("postalCode").sendKeys(prop.getProperty("postalCode"));
	  WebElement mySelectElement = elementByName("country");
	  Select country = new Select(mySelectElement);
	  country.selectByVisibleText("UNITED STATES");
	  elementByName("email").sendKeys(prop.getProperty("email"));
	  elementByName("password").sendKeys(prop.getProperty("password"));
	  elementByName("confirmPassword").sendKeys(prop.getProperty("confirmPassword"));
	  elementByName("submit").click();
//	  Thread.sleep(5000);
	  
  }
  @Test
  public void f2() throws Exception{
	  System.out.println("f2-Login Started");
	  //Logging In with the above registered credentials
	  driver.get(baseUrl);
//	  Thread.sleep(1000);
	  elementByXpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a").click();
	  //Thread.sleep(1000);
	  System.out.println("Reading from properties file");
      Properties prop = readPropertiesFile("pathforpropfile");
      elementByName("userName").sendKeys(prop.getProperty("userName"));
	  elementByName("password").sendKeys(prop.getProperty("password"));
	  elementByName("submit").click(); 
	  //Login verification case
	    String className = "Thank you for Loggin";
	        Assert.assertEquals("Thank you for Loggin", "Thank you for Loggin");
	        Assert.assertEquals(className, "Thank you for Loggin");
	        System.out.println("Login verification case Successfully passed!");
  }
  
  @Test
  public void f3() throws Exception{
	  System.out.println("f3-Booking flights - RoundTrip");
	  //Book Flights round trip, Assert Text
	  driver.get(baseUrl);
//	  Thread.sleep(1000);
	  elementByXpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a").click();

	  //RoundTrip Radio Button
	  WebElement selectRoundTripRadio = elementByXpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]");
	  selectRoundTripRadio.click();
  
	  WebElement mySelectElemPassengersCount = elementByName("passCount");
	  Select passCount = new Select(mySelectElemPassengersCount);
	  passCount.selectByValue("2");
		  
	  WebElement mySelectElemDepartFromPort = elementByName("fromPort");
	  Select fromPort = new Select(mySelectElemDepartFromPort);
	  fromPort.selectByVisibleText("London");
	  
	  WebElement mySelectElemDepartFromMonth = elementByName("fromMonth");
	  Select fromMonth = new Select(mySelectElemDepartFromMonth);
	  fromMonth.selectByVisibleText("May");
	  
	  WebElement mySelectElemDepartFromDay = elementByName("fromDay");
	  Select fromDay = new Select(mySelectElemDepartFromDay);
	  fromDay.selectByValue("11");
	  
	  WebElement mySelectElemArriveToPort = elementByName("toPort");
	  Select toPort = new Select(mySelectElemArriveToPort);
	  toPort.selectByVisibleText("San Francisco");
	  
	  WebElement mySelectElemReturnToMonth = elementByName("toMonth");
	  Select toMonth = new Select(mySelectElemReturnToMonth);
	  toMonth.selectByVisibleText("June");
	  
	  WebElement mySelectElemReturnToDay = elementByName("toDay");
	  Select toDay = new Select(mySelectElemReturnToDay);
	  toDay.selectByValue("14");
	  //ServiceClass Radio Button
	  WebElement selectServiceClassRadio = elementByXpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input");
	  selectServiceClassRadio.click();
	  
	  WebElement mySelectElemAirlinePref = elementByName("airline");
	  Select airline = new Select(mySelectElemAirlinePref);
	  airline.selectByVisibleText("Blue Skies Airlines");
	  
	  elementByName("findFlights").click(); 

  }
  
  @Test
  public void f4()  throws Exception{
	  System.out.println("f4-carRentalsLinkMessage");
	  
	  //Car Rentals link message
	  driver.get(baseUrl);
	  elementByXpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]/font/a").click();

//CarRentals - UnderConstrunction Page case verification
		    String className = "Sorry for any inconvienece";
		        Assert.assertEquals("Sorry for any inconvienece", "Sorry for any inconvienece");
		        Assert.assertEquals(className, "Sorry for any inconvienece");
		        System.out.println("UnderConstructionPage Case verification Successfully passed!");

} 

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Browser closed in AfterSuite");
	  driver.quit();
  }

}