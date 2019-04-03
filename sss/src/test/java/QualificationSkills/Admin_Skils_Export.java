//import MercuryDemoTours;

package  QualificationSkills;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.*;

import ExcelUtil.ExcelApiTest3;
import HTMLReport.TestHTMLReporter6;
import Login.Login;


 
public class Admin_Skils_Export
{
	public String UserName,Password;
	public String Skill_Name,Skill_Description,AddSkill_Name,AddSkill_Description;
	
	public  int iRow;
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;
	public  void Admin_Skils_Export(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	
	@Test
	public  void Export_Admin_Qualification( )throws Exception
	{  
		
		     ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet4");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet4",i,0);
					 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet4",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 Skill_Name=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet4",i,2);
					 System.out.println(" Skill_Name is "+Skill_Name);
					 
					 Skill_Description=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet4",i,3);
					 System.out.println(" Skill_Description is "+Skill_Description);
					
					
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
				 driver.quit();
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		 System.out.println(" 123 ");
		 String str=String.valueOf(iRow);
		 TH3= new TestHTMLReporter6();

		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_Skills_export","Chrome");
		driver=TestBrowser.OpenChromeBrowser();
		
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 

	    Login l1=new Login();
		l1.Login(driver ,HtmlOutputFileName,TH3);
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		l1.OrangeHRMSigninClick();
		
		Admin_Skils_Export AE = new Admin_Skils_Export();
		//AE.Admin_Skils_Export(driver, AddSkill_Description, TH3);
		AE.Admin_Skils_Export(driver, HtmlOutputFileName, TH3);
		
		
		AE.Admin_Skils_Export1();
		
	   TH3.HTMLScreenShot("Enter Skills Export ","Skills Succefully Exported","Pass", HtmlOutputFileName,driver);
	   TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();
	
	}
				
			// Ends method for  VacancySearch
				
				public  void Admin_Skils_Export1()throws Exception
				{ 
					
					
					driver.findElement(By.xpath(OR.Admin)).click();
					
					 Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.Qualification_Focus));
					 
					 TH3.HTMLScreenShot("Qualifications Focus ","Qualifications Focus","Pass", HtmlOutputFileName,driver);
					 actions.moveToElement(ele).click().perform();
					 
					 driver.findElement(By.xpath(OR.Qualification_skills_click)).click();
				
					 //driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(Skill_Name);
						//System.out.println("AddSkill_Name is"+Skill_Name);
	               TH3.HTMLScreenShot("Enter Skills Export1 ","Skills Succefully Exported1","Pass", HtmlOutputFileName,driver);
				
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.skillcoloumns)); 
			        System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.SkillRows)); 
			        System.out.println("No of rows are : " + rows.size());
			        
			       
			      
			        			ExcelApiTest3 eat = new ExcelApiTest3();
			         
							    for ( int i=1 ; i<=rows.size() ;i++)
							    {
							    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
							    	   {
							    		  
							    		  System.out.println("hai....112");
							      		   String str1="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
							      		
							      		 System.out.println("hai....113");
							      		   //*[@id="recordsListTable"]/tbody/tr[2]/td[2]
							      		   
							      		   //*[@id="recordsListTable"]/tbody/tr[2]/td[2]

							      		//*[@id='recordsListTable']/thead/tr/th
							    		    WebElement CellText1=driver.findElement(By.xpath(str1));
							    		    
							    		    System.out.println("hai....114");
							    		   
							    	        String valueIneed1 = CellText1.getText();
							    	        System.out.println("Cell Text Value is: " + valueIneed1);
							    	        
							    	        if (valueIneed1 !=null)
							    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet5",i,k,valueIneed1);
							    	        else
							    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet5",i,k,"Blank Data");
							    	       
							    	        
							    	   }
							    	  
							    	 
							    }
							    

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
		
				
				
			 
				
