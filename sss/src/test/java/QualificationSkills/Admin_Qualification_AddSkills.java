//import MercuryDemoTours;

package  QualificationSkills;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import CommonUtil.*;

import ExcelUtil.ExcelApiTest3;
import HTMLReport.TestHTMLReporter6;
import Login.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;

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


 
public class Admin_Qualification_AddSkills
{
	public String UserName,Password;
	public String Skill_Name,Skill_Description,AddSkill_Name,AddSkill_Description;
	
	public  int iRow;

	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void Admin_Qualification_AddSkills(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	@Test(priority=1)
	public  void Skills_Add( )throws Exception
	{  
		ExcelApiTest3 eat = new ExcelApiTest3();
	
		 
		 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC03_skills.xls","Sheet1");
		 System.out.println("numberowsInputdata..." + numberowsInputdata);
		 


			 for(int i=1;i<numberowsInputdata;i++)
			 {		 
				
				 UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_skills.xls","Sheet1",i,0);
				 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_skills.xls","Sheet1",i,1);
				 System.out.println("User name is"+UserName);
				 System.out.println(" Password is "+Password);
				 
				 Skill_Name=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_skills.xls","Sheet1",i,2);
				 Skill_Description=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_skills.xls","Sheet1",i,3);

				 iRow=i;
				SkillAdd_allmethods(iRow,Skill_Name,Skill_Description); 
				 
			 } 
			 
			 
			 
			
			 
			 driver.quit();
			 
			
	}
			 
			 
			 public   void SkillAdd_allmethods(int iRow,String Skill_Name,String Skill_Description )throws Exception
				{  
					
				 System.out.println(" 123 ");
				 String str=String.valueOf(iRow);
					TH3= new TestHTMLReporter6();

					HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_Skills_Iteration_" + str,"Chrome");
					
				
				
				
				 
					if (iRow==1)
					{
		
						 driver=TestBrowser.OpenChromeBrowser();
						
					      
						    Login l1=new Login();
							l1.Login(driver ,HtmlOutputFileName,TH3);
							l1.openOrangeHRM();
							
							
							Actions actions1 = new Actions(driver);  
							actions1.contextClick();
							
							
							
							
							l1.OrangeHRMlogin(UserName,Password);
							TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);

							l1.OrangeHRMSigninClick();
				
						 driver.findElement(By.xpath(OR.Admin)).click();	
						 
					     Actions actions = new Actions(driver);   
						 WebElement ele=driver.findElement(By.xpath(OR.Qualification_Focus));
						 actions.moveToElement(ele).click().perform();
				
						 driver.findElement(By.xpath(OR.Qualification_skills_click)).click();
								  
					}
						
				
						 
						 driver.findElement(By.xpath(OR.Skills_Add)).click();
			 
						 /*SimpleDateFormat sdfDate1 = new SimpleDateFormat("dd-MMM-yyyy h:mm:ss a"); 
						 Date now1 = new Date();
						 String strDate1 = sdfDate1.format(now1);
						 String s3=Skill_Name.concat(strDate1); */
						 
						driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(Skill_Name);
						System.out.println("Skill_Name is"+Skill_Name);
						
						TH3.HTMLScreenShot("Enter Skills","Skill Entered ","Pass", HtmlOutputFileName,driver);
						
						driver.findElement(By.xpath(OR.AddSkill_Description)).sendKeys(Skill_Description);
						System.out.println("Skill_Description is"+Skill_Description);
						
						TH3.HTMLScreenShot("Enter Skills  Description","Skill  Description Entered ","Pass", HtmlOutputFileName,driver);
						

						TH3.HTMLScreenShot("Skill detailed added succesfully","Skill details added succesfully to web table","Pass", HtmlOutputFileName,driver);

						
						driver.findElement(By.xpath(OR.AddSkill_Save)).click();
						
						//TH3.HTMLScreenShot("Skill detailed added succesfully","Skill details added succesfully to web table","Pass", HtmlOutputFileName,driver);

						TH3.HTMLCloser(HtmlOutputFileName);
						TH3=null;
						System.gc();
					
		
				}

			/* @BeforeTest
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