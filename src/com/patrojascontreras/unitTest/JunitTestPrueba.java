package com.patrojascontreras.unitTest;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JunitTestPrueba {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		String chromeDriverLocation = "SeleniumIDE/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
		
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJunitTestPrueba() throws Exception {
		driver.get("https://www.google.cl/");
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("tottus");
	    driver.findElement(By.id("tsf")).submit();
	    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/div/a/h3")).click();
	    driver.findElement(By.id("storeFormdesktop")).click();
	    new Select(driver.findElement(By.id("storeFormdesktop"))).selectByVisibleText("TOTTUS NATANIEL");
	    driver.findElement(By.id("storeFormdesktop")).click();
	    driver.findElement(By.xpath("//div[@id='new_tottus_ubicacion']/div[4]")).click();
	    driver.findElement(By.xpath("//li[@id='new_tottus_nav_cliente_recetas']/a")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
	    driver.findElement(By.xpath("//div[@id='myDIV']/button[4]/img")).click();
	    driver.findElement(By.xpath("//div[@id='divRecipes']/section/div/div[2]/div[2]/div/div[2]/h3")).click();
	    driver.findElement(By.xpath("//div[@id='hero']/div/div/div[3]/div[2]/div[2]/p[4]")).click();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    	fail(verificationErrorString);
	    }
	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }
	}
	
	private boolean isAlertPresent() {
	    try {
	    	driver.switchTo().alert();
	    	return true;
	    } catch (NoAlertPresentException e) {
	    	return false;
	    }
	}
	
	private String closeAlertAndGetItsText() {
	    try {
	    	Alert alert = driver.switchTo().alert();
	    	String alertText = alert.getText();
	    	if (acceptNextAlert) {
	    		alert.accept();
	    	} else {
	    		alert.dismiss();
	    	}
	    	return alertText;
	    } finally {
	    	acceptNextAlert = true;
	    }
	}
}
