//import MercuryDemoTours;

package  Leaves;
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

 
public class Leavelist
{
	public String UserName,Password;
	public String EmpName,LeaveType,FromDate,ToDate,Coment;
	
	public  int iRow;
	
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void Leavelist(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	
	@Test
	public  void Leavelist_Export( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1");

				 for(int i=1;i<2 ;i++)
				 {		 
					 UserName="Admin";
					 
					 Password="admin123";
				
					 EmpName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,0);
					 LeaveType=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,1);
					 FromDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,2);
					 ToDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,3);
					 Coment=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Sheet1",i,4);
					 
					 
					 System.out.println("EmpName is"+EmpName);
					 System.out.println(" FromDate is "+FromDate);
					 System.out.println(" ToDate is "+ToDate);
					 System.out.println(" Coment is "+Coment);
					  iRow=i;
					  
						call_allmethods(iRow);
						
						
						
					 
				 }
			
				 
				 driver.quit();
				 
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_LeaveAssign_Iteration_" + str,"Chrome");
		
		
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
		
		
		
		Leavelist LL =new Leavelist();
	    LL.Leavelist(driver, HtmlOutputFileName, TH3);
		LL.LeaveAssign(iRow, EmpName,LeaveType,FromDate,ToDate,Coment);
		LL.Export_LeaveList(iRow);
		TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();

		
	}	
	
	

	public   void LeaveAssign(int iRow,String EmpName,String LeaveType,String FromDate,String ToDate,String Coment )throws Exception
	{  
		
		System.out.println("reached here");
		try 
		{
		
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.LE_Leave_focus));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Leave focus highlight","Leave  clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 
		 Actions actions1 = new Actions(driver);   
		System.out.println("reached here2");
		 WebElement ele1=driver.findElement(By.xpath(OR.LE_Assignleave_focus));
		 actions1.moveToElement(ele1).click().perform();
		 TH3.HTMLScreenShot("AssignLeave focus highlight","AssignLeave  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		 
		 
		//EmpName,FromDate,ToDate,Coment;
		 
		 driver.findElement(By.xpath(OR.LE_Empnaqme_sendkey)).sendKeys(EmpName);
		 System.out.println("reached here3");

		 TH3.HTMLScreenShot("Ente EmpName","EmpName Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Select listbox =new Select(driver.findElement(By.xpath(OR.LE_Leavetype_listbox)));
		 System.out.println("reached here4");

		 listbox.selectByVisibleText(LeaveType);

	 
		// driver.findElement(By.xpath(OR.LE_Leavetype_listbox)).clear();
		 //driver.findElement(By.xpath(OR.LE_Leavetype_listbox)).click();
		 TH3.HTMLScreenShot("Enter leavetype","leavetype Succefully Entered","Pass", HtmlOutputFileName,driver);
		  
		 driver.findElement(By.xpath(OR.LE_Fromdate_sendkey)).clear();
		 
		driver.findElement(By.xpath(OR.LE_Fromdate_sendkey)).sendKeys(FromDate);
		 System.out.println("reached here5");

		 TH3.HTMLScreenShot("Enter FromDate","FromDate Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.LE_Todate_sendkey)).clear();
		 driver.findElement(By.xpath(OR.LE_Todate_sendkey)).sendKeys(ToDate);
		 System.out.println("reached here6");

		 TH3.HTMLScreenShot("Enter ToDate","ToDate Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 
		 driver.findElement(By.xpath(OR.LE_Comment_sendkey)).sendKeys(Coment);
		 System.out.println("reached here7");

		 TH3.HTMLScreenShot("Enter Coment","Coment Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 
		 driver.findElement(By.xpath(OR.LE_Assign_click)).click();
		 
		 driver.findElement(By.xpath(OR.LE_Confirm_click)).click();
		 
		
	
		} 
		catch(Exception e)
		{
			
		}
		 
		 
	}
	
	
	public   void Export_LeaveList(int iRow )throws Exception
	
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

			 driver.findElement(By.xpath(OR.LL_From_SendKey)).clear();

			// driver.findElement(By.xpath(OR.LL_From_SendKey)).sendKeys("20-01-2019");
			 System.out.println("reached here7");	
			 
			 driver.findElement(By.xpath(OR.Ll_Date_SendKey)).clear();

			// driver.findElement(By.xpath(OR.Ll_Date_SendKey)).sendKeys("31-12-2019");
			 System.out.println("reached here7");
			 
			 driver.findElement(By.xpath(OR.Ll_All_SearchFilter3)).click();

			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath(OR.Ll_All_Checkbox)).isSelected();
			 System.out.println("reached here8");
			 
			 
			 Select listbox =new Select(driver.findElement(By.xpath(OR.Ll_Subunit_Listbox)));
			 //listbox.selectByVisibleText("All");
			 listbox.selectByIndex(0);
			 
			 System.out.println("reached here9");
			 

			 driver.findElement(By.xpath(OR.Ll_Search)).click();	
			 
		 List  columns = driver.findElements(By.xpath(OR.Ll_colmns)); 
	     System.out.println("No of columns are : " + columns.size());
	     
	     //No.of rows 
	     List  rows = driver.findElements(By.xpath(OR.Ll_rows)); 
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
					    
					    
					    TH3.HTMLScreenShot("   Leave details exported C://HTML Report//OrangeHRM6//TC01_Leavelist.xls","Leavelist export success ","Pass", HtmlOutputFileName,driver);

					    

					    
			} 
	
	/*

	@BeforeTest
	   public void suiteSetup1() throws Exception {
			
			
			
			//TestNGXML tn1 = new TestNGXML();
			//tn1.TestNG_Generate();
			
			
			 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
			 String xlsFileSheet="Sheet1";
			 
			 ExcelApiTest3 eat = new ExcelApiTest3();
			 eat.clearsheetdata(xlsFile,xlsFileSheet);
	   }  	
		
		@AfterTest
	 
	   public void AftersuiteSetup2() throws Exception {
			 
			 TestHTMLReporter6 TH8 = new TestHTMLReporter6();	
			 TH8.Regression_CretaeHTMLFile();
			 
			 
			
			
	   }    
		
		


*/

	

	
}