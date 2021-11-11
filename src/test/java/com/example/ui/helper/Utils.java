package com.example.ui.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Utils {
    WebDriver driver;
    WaitHelper waitHelper;
    public Utils(){
        this.driver= BaseWeb.driver;
        waitHelper = new WaitHelper();
    }

    public void Assertion(WebElement ele, String value)throws Exception{
        waitHelper.waitForElement(driver,ele);
        Assert.assertEquals(ele.getText(),value);
    }
    public void ClickElement(WebElement ele)throws Exception{
        waitHelper.waitForElement(driver,ele);
        ele.click();
    }
    public void EnterText(WebElement ele,String value)throws Exception{
        waitHelper.waitForElement(driver,ele);
        ele.sendKeys(value);
    }
}
