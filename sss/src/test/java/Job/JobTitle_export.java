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
 jobtitle export
 logout
 */

 
public class JobTitle_export
{
	public String UserName,Password;
	//public String FirstName,MiddleName,LastName,Id;
	
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void JobTitle_export(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	@Test
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,0);
					 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
			 driver.quit();
	}

	
	public   void call_allmethods(int iRow )throws Exception
	{  
		//try {
			
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_jobtitle_Export" + str,"Chrome");
		
		//TH3.CretaeHTMLFile(str1,"Chrome");
	  
		 			
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
		
		
		JobTitle_export JE =new JobTitle_export();
		JE.JobTitle_export(driver, HtmlOutputFileName, TH3);
		JE.Job_Title_export();
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		//} 
		//catch(Exception e)
		//{
			
		//}
	}	
	
	public   void Job_Title_export()throws Exception
	{  
		
		System.out.println("reached here");
		//try 
		//{
		
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.Admin_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 
		 driver.findElement(By.xpath(OR.Job_focus)).click();
		 TH3.HTMLScreenShot("Job focus highlight","Job focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.Jobtitle_click)).click();
		 TH3.HTMLScreenShot("Leavelist highlight","Leavelist highlight Succefully ","Pass", HtmlOutputFileName,driver);
		 
		    List  columns = driver.findElements(By.xpath(OR.Jobtitle_columns)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(OR.Jobtitle_rows)); 
	        System.out.println("No of rows are : " + rows.size());
	        int temp=1;
	        //call_allmethods(temp);
	      
	        			ExcelApiTest3 eat = new ExcelApiTest3();
	         
	        		    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
					    	   {
					      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
					      		   
					      		//*[@id="resultTable"]/tbody/tr[1]/td[2]
					    		    WebElement CellText1=driver.findElement(By.xpath(str1));
					    		   
					    	        String valueIneed1 = CellText1.getText();
					    	      //  System.out.println("Cell Text Value is: " + valueIneed1);
					    	        
					    	      
					    	        if (valueIneed1 !=null)
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet5",i,k,valueIneed1);
					    	        else
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet5",i,k,"Blank Data");
					    	        	
					    	   }
					    }
	   
		
	//	} 
	//	catch(Exception e)
	//	{
			
	//	}
		 
		 
	}
	

	
	

	@BeforeTest
    public void suiteSetup1() throws Exception {
		
		 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
		 String xlsFileSheet="Sheet1";
		 
		 ExcelApiTest3 eat = new ExcelApiTest3();
		 eat.clearsheetdata(xlsFile,xlsFileSheet);
		 
		// xlsFile="E://OrangeHrm//TC05_Leavelist.xls";
		 //xlsFileSheet="Sheet3";
		 
		 //ExcelApiTest3 eat1 = new ExcelApiTest3();
		 //eat1.clearsheetdata(xlsFile,xlsFileSheet);
		 
    }  	
	
	@AfterTest
  
    public void AftersuiteSetup2() throws Exception {
		 
		 TestHTMLReporter6 TH4 = new TestHTMLReporter6();	
		 TH4.Regression_CretaeHTMLFile();
		 
		 
		
		
    }
			
	
}