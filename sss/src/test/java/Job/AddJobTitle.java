//import MercuryDemoTours;

package  Job;
import org.testng.annotations.Test;

import CommonUtil.*;
import HTMLReport.TestHTMLReporter6;
import ExcelUtil.ExcelApiTest3;
import Login.Login;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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

import java.io.File;
import java.io.*;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;
/*
 Openbrowser
 openurL
 login
 jobtitle addjobtitle
 logout
 */

 
public class AddJobTitle
{
	public String UserName,Password;
	public String newjobtitle,description,note;
	
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void AddJobTitle(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	@Test
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			// int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1");

				 for(int i=1;i<=3;i++)
				 {	
					 UserName="ADMIN";
					 Password="admin123";	 
					 //UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,0);
					 //Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,1);
					 
					 newjobtitle=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,2);
					 description=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,3);
					 note=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,4);
					 
					 
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 System.out.println(" newjobtitle is "+newjobtitle);
					 System.out.println(" description is "+description);
					 System.out.println(" note is "+note);
					
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 System.out.println("out of for loop in datadriventest");
	 
			 driver.quit();
	}

	
	public   void call_allmethods(int iRow )throws Exception
	{  
			
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_jobtitle_ADD" + str,"Chrome");
		 
		 			
		if (iRow==1)
		{
		
		driver=TestBrowser.OpenChromeBrowser();
		//HtmlOutputFileName= TH3.CretaeHTMLFile("TC01 Add Employee","Chrome");
		
		Login l1=new Login();
		l1.Login(driver ,HtmlOutputFileName,TH3);
	
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		
		 TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		l1.OrangeHRMSigninClick();

			}
				
		AddJobTitle AJE =new AddJobTitle();
		AJE.AddJobTitle(driver, HtmlOutputFileName, TH3);
		AJE.AddJobTitle(iRow,newjobtitle,description,note);
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		//driver.quit();
	}	
	
	public   void AddJobTitle(int iRow,String newjobtitle,String description,String note)throws Exception
	{  
		
		System.out.println("reached here");
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.Admin_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 
		 driver.findElement(By.xpath(OR.Job_focus)).click();
		 TH3.HTMLScreenShot("Job focus highlight","Job focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.Jobtitle_click)).click();
		 TH3.HTMLScreenShot("Jobtitle clicked","Jobtitle clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.Jobtitle_add)).click();
		 TH3.HTMLScreenShot("Jobtitle clicked","Jobtitle clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 System.out.println(" newjobtitle in add "+newjobtitle);
		 System.out.println(" description is add"+description);
		 System.out.println(" note is add "+note);
		
		 driver.findElement(By.xpath(OR.Jobtitle_new)).sendKeys(newjobtitle);
		 TH3.HTMLScreenShot("Enter newjobtitle","newjobtitle Succefully Entered","Pass", HtmlOutputFileName,driver);
		
		 driver.findElement(By.xpath(OR.Job_description)).sendKeys(description);
		 TH3.HTMLScreenShot("Enter description","description Succefully Entered","Pass", HtmlOutputFileName,driver);
		 		 
		 driver.findElement(By.xpath(OR.Job_note)).sendKeys(note);
		 TH3.HTMLScreenShot("Enter Comment","Comment Succefully Entered","Pass", HtmlOutputFileName,driver);
		
		 driver.findElement(By.xpath(OR.Job_savebtn)).click();
					 
	}
	
	@BeforeTest
    public void suiteSetup1() throws Exception {
		
		 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
		 String xlsFileSheet="Sheet1";
		 
		 ExcelApiTest3 eat = new ExcelApiTest3();
		 eat.clearsheetdata(xlsFile,xlsFileSheet);
		 	 
    }  	
	
	@AfterTest
  
    public void AftersuiteSetup2() throws Exception {
		 
		 TestHTMLReporter6 TH4 = new TestHTMLReporter6();	
		 TH4.Regression_CretaeHTMLFile();
		 
		 
		
		
    }
			
	
}