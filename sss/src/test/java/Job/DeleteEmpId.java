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
 jobtitle delete
 logout
 */

 
public class DeleteEmpId
{
	public String UserName,Password,FirstName,LastName,Id;
	//public String FirstName,MiddleName,LastName,Id;
	
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void DeleteEmpId(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	public WebElement findElement(By by)throws Exception {
	    WebElement elem = driver.findElement(by);
	 
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    }
	    
	    
	    Thread.sleep(1000);
	    
	    return elem;
	}
	
	
	
	
	@Test
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_DELEMPID.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName="ADMIN";
					 Password="admin123";
					 FirstName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_DELEMPID.xls","Sheet1",i,0);
					 LastName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_DELEMPID.xls","Sheet1",i,2);
					 Id=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_DELEMPID.xls","Sheet1",i,1);

					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is"+Password);
					 System.out.println(" FirstName is"+FirstName);
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
			// quit();
	}

	
	public   void call_allmethods(int iRow )throws Exception
	{  
	
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_DELEMPID" + str,"Chrome");
	
		 			
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
		
		
		DeleteEmpId DEI =new DeleteEmpId();
		DEI.DeleteEmpId(driver, HtmlOutputFileName, TH3);
		
		DEI.EnterEmpDetails(FirstName,LastName,Id);
	
		
		Boolean r1=false;
		r1=DEI.EPPIDDELETE(Id);
		if(r1==true)	 
		{
			System.out.println("YES Id found");
			
		}
		 else
		  {
			 System.out.println("No-Id, Id not found");
		  }
			  
		 
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		driver.quit();
			}
	
	public void EnterEmpDetails(String FirstName,String LastName,String Id)throws Exception
	
	{
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.PIM_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 Actions actions1 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele1=findElement(By.xpath(OR.PIM_emplist_focus));
			 actions1.moveToElement(ele1).click().perform();
			 
			 findElement(By.xpath(OR.PIM_add_click)).click();
			 
			 findElement(By.xpath(OR.PIM_firstname_sendkeys)).sendKeys(FirstName);
			 
			 findElement(By.xpath(OR.PIM_lastname_sendkeys)).sendKeys(LastName);
			 
			 findElement(By.xpath(OR.PIM_empid_sendkeys)).clear();

			 findElement(By.xpath(OR.PIM_empid_sendkeys)).sendKeys(Id);
			 
			 findElement(By.xpath(OR.PIM_save_click)).click();
			 
			 
			 
 }
	
	
	
	public   Boolean EPPIDDELETE(String Id)throws Exception
	{  
		
		Boolean Record_Present=false;
		System.out.println("reached here");
				
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.PIM_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 Actions actions1 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele1=findElement(By.xpath(OR.PIM_emplist_focus));
			 actions1.moveToElement(ele1).click().perform();
		 
		 findElement(By.xpath(OR.PIM_empidserch_sendkeys)).sendKeys(Id);
		 TH3.HTMLScreenShot("Job focus highlight","Job focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 findElement(By.xpath(OR.PIM_serch_click)).click();
		 TH3.HTMLScreenShot("jobtitle","jobtitle clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		    List  columns = driver.findElements(By.xpath(OR.PIM_coloums)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(OR.PIM_rows)); 
	        System.out.println("No of rows are : " + rows.size());
	      
	     
	        
	        			ExcelApiTest3 eat = new ExcelApiTest3();
	         
	        			  for ( int i=1 ; i<=rows.size() ;i++)
	  				    {
	  				      	String pathdelete="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[2]";
	  				    
	  				        WebElement CellText1=findElement(By.xpath(pathdelete));
	  				    		   
	  				    	String EmpId = CellText1.getText();
	  				    	 //System.out.println("name in the application is " + nameinapp);
	  				        
	  					    	if ( Id.equals(EmpId) )
	  					    	{
	  					    	   Record_Present=true;
	  					    	   System.out.println("Empid found " + EmpId );
	  					    	   
	  					    	 String path_checkbox="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[1]";
	  					    	 
	  					    	 findElement(By.xpath(path_checkbox)).click();
	  							 TH3.HTMLScreenShot("Check box","jobtitle checkbox clicked","Pass", HtmlOutputFileName,driver);
	  							 
	  							 findElement(By.xpath(OR.PIM_delete_click)).click();
	  							 TH3.HTMLScreenShot("Delte clicked","Jobtitle deleted Succefully ","Pass", HtmlOutputFileName,driver);
	  							 
	  							findElement(By.xpath(OR.PIM_delete_conf_click)).click();
	  							 TH3.HTMLScreenShot("ConfirmDelte clicked","Jobtitle deleted Succefully ","Pass", HtmlOutputFileName,driver);	  					    	
	  					    	return Record_Present;
	  					    	}
	  					  		    	
	  					  					    	
	  				    } 
	        			  	return Record_Present;
	        			  /*if(Record_Present==true)	 
	        				System.out.println("YES jobtitle found");
	        			  else
	      					System.out.println("No-jobtitle, jobtitle not found");
	        				  
	        			  quit();*/
	}
	

	
	

	/*@BeforeTest
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
		 
		 
		
		
    }*/
			
	
}