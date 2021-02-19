package demotrainingpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

//  @BeforeMethod
//  public void beforeMethod() {
//	  System.out.println("beforeMethod");
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  System.out.println("AfterMethod");
//  }
//
//  @BeforeClass
//  public void beforeClass() {
//	  System.out.println("BeforeClass");
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  System.out.println("AfterClass");
//  }
//
//  @BeforeTest
//  public void beforeTest() {
//	  System.out.println("BeforeTest");
//  }
//
//  @AfterTest
//  public void afterTest() {
//	  System.out.println("AfterTest");
//  }
	 public WebDriver driver ; 
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");
	 String baseUrl = "http://demo.guru99.com/test/newtours/";
	    String driverPath = "C:\\Users\\lalit\\Downloads\\chromedriver_win32\\chromedriver.exe";
	    
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	   
  }
  @Test
  public void f() {
	  System.out.println("f");
	  //System.out.println("launching Chrome browser"); 
	  //driver.findElement(By.name("userName")).sendKeys("testusername");
      
  }
  @Test
  public void f1() {
	  System.out.println("f1");
	  //System.out.println("launching Chrome browser"); 
	  //driver.findElement(By.name("userName")).sendKeys("testusername");
      
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfetrSuite");
	  driver.quit();
  }

}
