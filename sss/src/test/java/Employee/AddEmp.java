

package  Employee;
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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
 1. Open Chrome browser
 2. open Orange Application urL
 3. login
 4. Add employee details
 5. logout and Quit
 */

 
public class AddEmp
{
	public String UserName,Password;
	public String FirstName,MiddleName,LastName,Id;
	public String PhotoPath;
	
	public  int iRow;
	public  String sRow;
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void AddEmp(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	// Draws a red border around the found element. Does not set it back anyhow.
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
	public  void AddEmp_datadriventest( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,0);
					 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,1);
					 
					 FirstName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,2);
					 MiddleName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,3);
					 LastName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,4);
					 Id=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,5);
					 
					 PhotoPath=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_AddEmp.xls","Sheet1",i,6);
					 
					
					 iRow=i;
					  
					call_allmethods(iRow);
					 
				 }
			
	
				 driver.quit();
				 
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
		l1.OrangeHRMSigninClick();
		
		}
		
		
		
		AddEmp AE =new AddEmp();
		AE.AddEmp(driver,HtmlOutputFileName,TH3 );
		AE.addEmp1(iRow, FirstName, MiddleName, LastName, Id);
		AE.PhotoUpload(iRow,PhotoPath);
		
	    TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();

		
	}	
	
	
	
	public   void PhotoUpload(int iRow , String PhotoPath)throws Exception
	{
		

		
	findElement(By.xpath("//*[@id='photofile']")).click();

	
		Thread.sleep(1000);
		 
		// Specify the file location with extension
		// StringSelection sel = new StringSelection("C:\\Users\\Sudhakar\\Desktop\\download1.jpg");
		 
		StringSelection sel = new StringSelection(PhotoPath);
		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 
		 // Create object of Robot class
		 Robot robot = new Robot();
		 Thread.sleep(2000);
		      
		  // Press Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(2000);
		        
		       //  Press Enter 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(8000);
	
		findElement(By.xpath(OR.Emp_save_click)).click();
		
		TH3.HTMLScreenShot("Add Employee Page -  Select Photo to Photo  ","Upload photo selected","Pass", HtmlOutputFileName,driver);
		Thread.sleep(8000);
		 
		 TH3.HTMLScreenShot("Add Employee Page -  Upload Photo  ","Photo Uploaded","Pass", HtmlOutputFileName,driver);
		 
		
		
	}
	
	
	


	public   void addEmp1(int iRow,String FirstName,String MiddleName,String LastName,String Id )throws Exception
	{  
		

		try 
		{
		

		
		 Actions actions = new Actions(driver);   
		 System.out.println("reached here1");

		 
		 WebElement ele=findElement(By.xpath(OR.Emp_Pim_focus1));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Add Employee Page -  Highlight PIM Navigation  ","Pim Navigation clicked ","Pass", HtmlOutputFileName,driver);
		 
		 
		 findElement(By.xpath(OR.Emp_list_focus)).click();
		 TH3.HTMLScreenShot("Add Employee Page - Highlight Employee Navigation","Employee Navigation Clicked ","Pass", HtmlOutputFileName,driver);
		 
		 
		
		findElement(By.xpath(OR.Emp_pimadd_click)).click();
		TH3.HTMLScreenShot("Add Employee Page - Click on Add Employee button ","Add Employee button clicked","Pass", HtmlOutputFileName,driver);
		 
		 
		
		 findElement(By.xpath(OR.Emp_firstname_sendkey)).sendKeys(FirstName);
		 TH3.HTMLScreenShot("Add Employee Page - Enter FirstName","FirstName Entered","Pass", HtmlOutputFileName,driver);
		
		 
		
		 findElement(By.xpath(OR.Emp_middlename_sendkey)).sendKeys(MiddleName);
		 TH3.HTMLScreenShot("Add Employee Page - Enter MiddleName","MiddleName Entered","Pass", HtmlOutputFileName,driver);
		 
		
		 findElement(By.xpath(OR.Emp_lastname_sendkey)).sendKeys(LastName);
		 TH3.HTMLScreenShot("Add Employee Page - Enter LastName","LastName Entered","Pass", HtmlOutputFileName,driver);
		 
		
		 findElement(By.xpath(OR.Emp_id_sendkey)).sendKeys(Id);
		 TH3.HTMLScreenShot("Add Employee Page - Enter Employee Id"," Employee Id Entered","Pass", HtmlOutputFileName,driver);
		 

		
	
		} 
		catch(Exception e)
		{
			
		}
		 
		 
	}
	

	/*

	@BeforeTest
    public void suiteSetup1() throws Exception {
		
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