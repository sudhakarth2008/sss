//import MercuryDemoTours;

package  Leave;
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
 Addemp
 logout
 */

 
public class AddLeavelist
{
	public String UserName,Password;
	public String EmpName,LeaveType,FromDate,ToDate,Comment;
	
	public  int iRow;
	
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;


	
	public  void AddLeavelist(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	
	@Test
	public  void AddLeavelist_datadriventest( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1");

				 for(int i=1;i<numberowsInputdata;i++)
				 {		 
					 UserName="Admin";
					 
					 Password="admin123";
				
					 EmpName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,0);
					 LeaveType=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,1);
					 FromDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,2);
					 ToDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,3);
					 Comment=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,4);
					 
					 
					 System.out.println("EmpName is"+EmpName);
					 System.out.println("LeaveType is"+LeaveType);
					 System.out.println(" FromDate is "+FromDate);
					 System.out.println(" ToDate is "+ToDate);
					 System.out.println(" Coment is "+Comment);
					  iRow=i;
					  
						call_allmethods(iRow);
						
						
						
					 
				 }
			
				 
				// driver.quit();
				 
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_Add_Employee_Iteration_" + str,"Chrome");
		
		
		if (iRow==1)
		{
			
		driver=TestBrowser.OpenChromeBrowser();	
		
		Login l1=new Login();
		l1.Login(driver ,HtmlOutputFileName,TH3);
	
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		
		TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		l1.OrangeHRMSigninClick();

		
		}
		
		
		
		AddLeavelist ALL =new AddLeavelist();
	    ALL.AddLeavelist(driver, HtmlOutputFileName, TH3);
		ALL.LeaveAssign(iRow, EmpName,LeaveType,FromDate,ToDate,Comment);
		ALL.Export_AddLeavelist(iRow);
		TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();
		driver.quit();
		
	}	
		

	public   void LeaveAssign(int iRow,String EmpName,String LeaveType,String FromDate,String ToDate,String Coment )throws Exception
	{  
		
		System.out.println("reached here");
		//try 
		//{
		
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.LE_Leave_focus));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Leave focus highlight","Leave  clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 
		 System.out.println("reached here2");
		 Actions actions1 = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele1=driver.findElement(By.xpath(OR.LE_Assignleave_focus));
		 actions1.moveToElement(ele1).click().perform();
		 TH3.HTMLScreenShot("AssignLeave focus highlight","AssignLeave  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		 
		 
		//EmpName,FromDate,ToDate,Coment;
		 
		 driver.findElement(By.xpath(OR.LE_Empnaqme_sendkey)).sendKeys(EmpName);
		 TH3.HTMLScreenShot("Ente EmpName","EmpName Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Select listbox =new Select(driver.findElement(By.xpath(OR.LE_Leavetype_listbox)));
		 listbox.selectByVisibleText(LeaveType);

	 
		// driver.findElement(By.xpath(OR.LE_Leavetype_listbox)).clear();
		 //driver.findElement(By.xpath(OR.LE_Leavetype_listbox)).click();
		 TH3.HTMLScreenShot("Enter leavetype","leavetype Succefully Entered","Pass", HtmlOutputFileName,driver);
		  
		 driver.findElement(By.xpath(OR.LE_Fromdate_sendkey)).clear();
		 
		driver.findElement(By.xpath(OR.LE_Fromdate_sendkey)).sendKeys(FromDate);
		// Select listbox1 =new Select(driver.findElement(By.xpath(OR.LE_Fromdate_sendkey)));
		// listbox1.selectByVisibleText(FromDate);
		 TH3.HTMLScreenShot("Enter FromDate","FromDate Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.LE_Todate_sendkey)).clear();
		 driver.findElement(By.xpath(OR.LE_Todate_sendkey)).sendKeys(ToDate);
		 TH3.HTMLScreenShot("Enter ToDate","ToDate Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 
		 driver.findElement(By.xpath(OR.LE_Comment_sendkey)).sendKeys(Coment);
		 TH3.HTMLScreenShot("Enter Coment","Coment Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 
		 driver.findElement(By.xpath(OR.LE_Assign_click)).click();
		 
		 driver.findElement(By.xpath(OR.LE_Confirm_click)).click();
		 
		
	
//		} 
	//	catch(Exception e)
		//{
			
		//}
		 
		 
	}
	
	public   void Export_AddLeavelist(int iRow )throws Exception
	{  
		
		System.out.println("reached here");
		 
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.LE_Leave_focus));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Leave focus highlight","Leave  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		 Actions actions2 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele2=driver.findElement(By.xpath(OR.LE_Leavelist_focus));
			 actions2.moveToElement(ele2).click().perform();
			 TH3.HTMLScreenShot("Leavelist focus highlight","Leavelist  clicked Succefully ","Pass", HtmlOutputFileName,driver);

			 driver.findElement(By.xpath(OR.LE_All_checkbox)).click();	
			 
			 driver.findElement(By.xpath(OR.LE_search_click)).click();	
			 
		 List  columns = driver.findElements(By.xpath(OR.LE_No_coloumns)); 
	     System.out.println("No of columns are : " + columns.size());
	     
	     //No.of rows 
	     List  rows = driver.findElements(By.xpath(OR.LE_No_Rows)); 
	     System.out.println("No of rows are : " + rows.size());
	     
	    
	   
	     			ExcelApiTest3 eat = new ExcelApiTest3();
	      
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					    	  for ( int j=2 ,k=0; j<=6;j++,k++)
					    	   {
					    		  
					    		  System.out.println("hai....112");
					      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
					      		
					      		   	System.out.println("hai....113");
					      		    WebElement CellText1=driver.findElement(By.xpath(str1));
					    		    
					    		    System.out.println("hai....114");
					    		   
					    	        String valueIneed1 = CellText1.getText();
					    	        System.out.println("Cell Text Value is: " + valueIneed1);
					    	        
					    	        if (valueIneed1 !=null)
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet5",i,k,valueIneed1);
					    	        else
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet5",i,k,"Blank Data");
					    	       
					    	        
					    	   }
					    	  
					    	 
					    }
					    

					    
			} 


}
		