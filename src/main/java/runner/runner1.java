package runner;


import com.demo.pageobject.searching;
import com.demo.reusablecomponents.ReusableMethods;
import com.demo.reusablecomponents.reusablecomponents;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class runner1 extends reusablecomponents{
	public static Logger Log=LogManager.getLogger(reusablecomponents.class.getName());
	@Test
	public void home() throws Exception {
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		ReusableMethods.sendKeys(searching.search, "Refrigerator", driver);
		ReusableMethods.click(searching.searche, driver);
		
		
		

	
	}
}
