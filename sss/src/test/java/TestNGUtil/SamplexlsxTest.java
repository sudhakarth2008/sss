package TestNGUtil;
//import MercuryDemoTours;

import HTMLReport.TestHTMLReporter7;
import ExcelUtil.ExcelApiTest4;
import CommonUtil.*;
import Employee.*;
import Job.*;
import Leave.*;

import QualificationSkills.Admin_Qualification_AddSkills;


import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;


import java.awt.Desktop;
import java.io.*;


public class SamplexlsxTest {
	
	 WebDriver driver;

	 String HtmlOutputFileName,error;
	 TestHTMLReporter7 TH3;
	 public  void SamplexlsxTest(WebDriver driver,String HtmlOutputFileName, TestHTMLReporter7 TH3 )throws Exception
	 {  
		 this.driver=driver;
		 this.HtmlOutputFileName=HtmlOutputFileName;
		 this.TH3=TH3;

	 }

	


	@Test
	public  void TC01() throws Exception {
		
		   WebDriver driver=null;
			String	Browser="Chrome";
		
		   TestHTMLReporter7 TH3 = new TestHTMLReporter7();	  
		   String HtmlOutputFileName3= TH3.CretaeHTMLFile("TC01_Mercury","Chrome");	
		   
		 //  Test8 T1= new Test8();
			  
	     //Choose Browser Tyoe as per TestNG.xml
		  if(Browser.equalsIgnoreCase("Chrome"))
		  driver=TestBrowser.OpenChromeBrowser();
	      if(Browser.equalsIgnoreCase("IE"))
		  driver=TestBrowser.OpenIEBrowser();
	      if(Browser.equalsIgnoreCase("FIreFox"))
		  driver=TestBrowser.OpenFirefoxBrowser();
	      
		  
		  driver.get("http://www.newtours.demoaut.com/");
		  TH3.HTMLScreenShot("Open Mercury Demo tours","	Succefully Opened","Pass", HtmlOutputFileName3,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH3.HTMLScreenShot("Enter user Name","User Name Succefully Entered","Pass", HtmlOutputFileName3,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH3.HTMLScreenShot("Enter Password","	Password Succefully passed ","Pass", HtmlOutputFileName3,driver);

		  TH3.HTMLCloser(HtmlOutputFileName3);
		  driver.quit();
	
	}
	
	
	@Test

	public  void TC02() throws Exception {
		
		 WebDriver driver=null;
			String	Browser="Chrome";
		  
		   TestHTMLReporter7 TH4 = new TestHTMLReporter7();	  
		   String HtmlOutputFileName2= TH4.CretaeHTMLFile("TC02_Mercury","Chrome");	
			  
		    //Choose Browser Tyoe as per TestNG.xml
			  if(Browser.equalsIgnoreCase("Chrome"))
			  driver=TestBrowser.OpenChromeBrowser();
		      if(Browser.equalsIgnoreCase("IE"))
			  driver=TestBrowser.OpenIEBrowser();
		      if(Browser.equalsIgnoreCase("FIreFox"))
			  driver=TestBrowser.OpenFirefoxBrowser();
		  
		  driver.get("http://www.newtours.demoaut.com/");
		  TH4.HTMLScreenShot("Open Mercury Demo tours","	Succefully Opened","Pass", HtmlOutputFileName2,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH4.HTMLScreenShot("Enter user Name","User Name Succefully Entered","Pass", HtmlOutputFileName2,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH4.HTMLScreenShot("Enter Password","	Password Succefully passed ","Pass", HtmlOutputFileName2,driver);

		  TH4.HTMLCloser(HtmlOutputFileName2);
		  driver.quit();
	
	}
	
	
	

	@Test

	public  void TC03() throws Exception {
		
	String	Browser="Chrome";
		
			WebDriver driver=null;
		
		   TestHTMLReporter7 TH5 = new TestHTMLReporter7();	  
		   String HtmlOutputFileName1= TH5.CretaeHTMLFile("TC03_Mercury","Chrome");	
			  
		    //Choose Browser Tyoe as per TestNG.xml
			  if(Browser.equalsIgnoreCase("Chrome"))
			  driver=TestBrowser.OpenChromeBrowser();
		      if(Browser.equalsIgnoreCase("IE"))
			  driver=TestBrowser.OpenIEBrowser();
		      if(Browser.equalsIgnoreCase("FIreFox"))
			  driver=TestBrowser.OpenFirefoxBrowser();
		  
		  driver.get("http://www.newtours.demoaut.com/");
		  TH5.HTMLScreenShot("Open Mercury Demo tours","	Succefully Opened","Pass", HtmlOutputFileName1,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH5.HTMLScreenShot("Enter user Name","User Name Succefully Entered","Pass", HtmlOutputFileName1,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH5.HTMLScreenShot("Enter Password","	Password Succefully passed ","Pass", HtmlOutputFileName1,driver);

		  TH5.HTMLCloser(HtmlOutputFileName1);
		  driver.quit();
	
	}

	
	
	

	@BeforeSuite
    public void suiteSetup1() throws Exception {
		
		 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xlsx";
		 String xlsFileSheet="Sheet1";
		 
		 ExcelApiTest4 eat = new ExcelApiTest4();
		 eat.clearsheetdata(xlsFile,xlsFileSheet);
    }  	

	 
	 

	 
	// @Test
	@AfterSuite
    public void AftersuiteSetup2() throws Exception {
		 
		 TestHTMLReporter7 TH9 = new TestHTMLReporter7();	
		 TH9.Regression_CretaeHTMLFile();
		
		
    }  
    

		
	
	
	
	
	
}

	
	