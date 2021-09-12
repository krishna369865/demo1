package runner;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pageobject.fromtoplace;
import com.demo.pageobject.googlesignin;
import com.demo.pageobject.landui;
import com.demo.reusablecomponents.ReusableMethods;
import com.demo.reusablecomponents.reusablecomponents;

import utils.excelutils;







public class Testrunner extends reusablecomponents{
	public static Logger Log=LogManager.getLogger(reusablecomponents.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Log.info("loading");
		
	}
	@Test(priority=0,dataProvider="test1data")
	public void travel(String Fromplace,String Toplace) throws Exception {
		ReusableMethods.click(fromtoplace.fromplace, driver);
		Thread.sleep(200);
		ReusableMethods.sendKeys(fromtoplace.fromplace,Fromplace, driver);
		ReusableMethods.sendKeys(fromtoplace.toplace,Keys.ENTER, driver);
		ReusableMethods.click(fromtoplace.toplace, driver);
		ReusableMethods.sendKeys(fromtoplace.toplace,Toplace, driver);
		ReusableMethods.sendKeys(fromtoplace.toplace,Keys.ENTER, driver);
		ReusableMethods.click(fromtoplace.date, driver);
		ReusableMethods.click(fromtoplace.calender, driver);
		
		
		
		
		
	}
	@Test(priority=1)
	public void trains() throws Exception {
		Actions a=new Actions(driver);
		WebElement actels=driver.findElement(com.demo.pageobject.trains.more);
		a.moveToElement(actels).build().perform();
		ReusableMethods.click(com.demo.pageobject.trains.trains, driver);
		ReusableMethods.click(com.demo.pageobject.trains.alert, driver);
		ReusableMethods.click(com.demo.pageobject.trains.searching, driver);
		
		
		
		
	}
	@Test(priority=2)
	public void login() throws Exception {
		Actions a=new Actions(driver);
		WebElement actel=driver.findElement(landui.signin);
		a.moveToElement(actel).build().perform();
		ReusableMethods.click(landui.signup, driver);
		Log.info("signup page loading");
		ReusableMethods.sendKeys(googlesignin.login,"6374562393", driver);
		Log.info("");
		
	}

	
		
		
		
		
		
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
	@DataProvider(name="test1data")
	public static Object[][] getData() throws IOException {
		Object data[][]=testdata("C:\\Users\\Kumar\\eclipse-workspace\\demo1\\resorces1\\asig.xlsx","Sheet1");
		return data;
	}
	public static Object[][] testdata(String excelpath, String sheetname) throws IOException {
		excelutils excel=new excelutils(excelpath,sheetname);
		int rowcount=excel.getRowCount();
		int colcount=excel.getColCount();
		
		Object data[][]=new Object[rowcount-1][colcount];
		
		for(int i=1; i<rowcount; i++)
        {
            for(int j=0; j<colcount; j++)
            {
                String cellData = excel.getCellDataString(i, j);
                data[i-1][j]=cellData;
                
                
            }
             
        }
		return data;
	}

}


