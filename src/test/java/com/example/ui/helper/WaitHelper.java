package com.example.ui.helper;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class WaitHelper {
	Logger logger = Logger.getLogger(WaitHelper.class);

	public void waitForElement(WebDriver driver, WebElement element)throws Exception {
		try{
			logger.debug("Waitting for elelment");
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.debug("Element is visible now");
		}catch (Exception e){
			Assert.fail("Element not visible");
		}
	}
}
