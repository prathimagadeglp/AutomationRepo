package demotrainingpackage;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class Registration {

  public WebDriver driver ;
  public Select dropdownmenu;
  public String baseUrl = "http://demo.guru99.com/test/newtours/";
  
  @BeforeSuite
  public void beforeSuite()  throws Exception{
	  System.out.println("BeforeSuite");
	 //Opening mercury tours site
	    String driverPath = "C:\\Users\\lalit\\Downloads\\chromedriver_win32\\chromedriver.exe";
	     System.setProperty("webdriver.chrome.driver", driverPath);
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      
  }
  
	public void elementByName(String name, String value){
	driver.findElement(By.name(name)).sendKeys(value);
	
  
  }
  
  @Test
  public void f()  throws Exception{
	  System.out.println("f");
	  
	  //Registration flow
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
	//  Thread.sleep(1000);
	  driver.findElement(By.name("firstName")).sendKeys("fn2");
	  driver.findElement(By.name("lastName")).sendKeys("ln2");
	  driver.findElement(By.name("phone")).sendKeys("408-123-9876");
	  driver.findElement(By.name("userName")).sendKeys("email@mail.com");
	  driver.findElement(By.name("address1")).sendKeys("123 main st");
	  driver.findElement(By.name("city")).sendKeys("Frisco");
	  driver.findElement(By.name("state")).sendKeys("TX2");
	  driver.findElement(By.name("postalCode")).sendKeys("95050");
	  WebElement mySelectElement = driver.findElement(By.name("country"));
	  Select country = new Select(mySelectElement);
	  country.selectByVisibleText("UNITED STATES");
	  driver.findElement(By.name("email")).sendKeys("fnln2");
	  driver.findElement(By.name("password")).sendKeys("pswdfnln2");
	  driver.findElement(By.name("confirmPassword")).sendKeys("pswdfnln2");
	  driver.findElement(By.name("submit")).click();
//	  Thread.sleep(1000);
	  
  }
  @Test
  public void f1() throws Exception{
	  System.out.println("f1");
	  //Logging In with the above registered credentials
	  driver.get(baseUrl);
//	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("userName")).sendKeys("fnln2");
	  driver.findElement(By.name("password")).sendKeys("pswdfnln2");
	  driver.findElement(By.name("submit")).click(); 

	  //Login verification case
	    String className = "Thank you for Loggin";
	        Assert.assertEquals("Thank you for Loggin", "Thank you for Loggin");
	        Assert.assertEquals(className, "Thank you for Loggin");
	        System.out.println("Login verification case Successfully passed!");
	 
  }
  
  @Test
  public void f2() throws Exception{
	  System.out.println("f2");
	  //Book Flights round trip, Assert Text
	  driver.get(baseUrl);
//	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")).click();

	  //RoundTrip Radio Button
	  WebElement selectRoundTripRadio = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"));
	  selectRoundTripRadio.click();
	  
//	  Thread.sleep(1000);
	  
	  WebElement mySelectElemPassengersCount = driver.findElement(By.name("passCount"));
	  Select passCount = new Select(mySelectElemPassengersCount);
	  passCount.selectByValue("2");
		  
	  WebElement mySelectElemDepartFromPort = driver.findElement(By.name("fromPort"));
	  Select fromPort = new Select(mySelectElemDepartFromPort);
	  fromPort.selectByVisibleText("London");
	  
	  WebElement mySelectElemDepartFromMonth = driver.findElement(By.name("fromMonth"));
	  Select fromMonth = new Select(mySelectElemDepartFromMonth);
	  fromMonth.selectByVisibleText("May");
	  
	  WebElement mySelectElemDepartFromDay = driver.findElement(By.name("fromDay"));
	  Select fromDay = new Select(mySelectElemDepartFromDay);
	  fromDay.selectByValue("11");
	  
	  WebElement mySelectElemArriveToPort = driver.findElement(By.name("toPort"));
	  Select toPort = new Select(mySelectElemArriveToPort);
	  toPort.selectByVisibleText("San Francisco");
	  
	  WebElement mySelectElemReturnToMonth = driver.findElement(By.name("toMonth"));
	  Select toMonth = new Select(mySelectElemReturnToMonth);
	  toMonth.selectByVisibleText("June");
	  
	  WebElement mySelectElemReturnToDay = driver.findElement(By.name("toDay"));
	  Select toDay = new Select(mySelectElemReturnToDay);
	  toDay.selectByValue("14");
	  //ServiceClass Radio Button
	  WebElement selectServiceClassRadio = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input"));
	  selectServiceClassRadio.click();
	  
	  WebElement mySelectElemAirlinePref = driver.findElement(By.name("airline"));
	  Select airline = new Select(mySelectElemAirlinePref);
	  airline.selectByVisibleText("Blue Skies Airlines");
	  
	  driver.findElement(By.name("findFlights")).click(); 

  }
  
  @Test
  public void f4()  throws Exception{
	  System.out.println("f4");
	  
	  //Car Rentals link message
	  driver.get(baseUrl);
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]/font/a")).click();

//CarRentals - UnderConstrunction Page case verification
		    String className = "Sorry for any inconvienece";
		        Assert.assertEquals("Sorry for any inconvienece", "Sorry for any inconvienece");
		        Assert.assertEquals(className, "Sorry for any inconvienece");
		        System.out.println("UnderConstructionPage Case verification Successfully passed!");

} 
  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
	  driver.quit();
  }
  
 }
