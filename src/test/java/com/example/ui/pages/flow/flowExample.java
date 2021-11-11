package com.example.ui.pages.flow;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.example.ui.helper.BaseWeb;
import com.example.ui.helper.Utils;
import com.example.ui.pages.objects.ExampleObject;
import org.openqa.selenium.WebDriver;

public class flowExample {
    WebDriver driver;
    ExampleObject exampleObject;
    Utils utils;

    public flowExample(){
        this.driver= BaseWeb.driver;
        exampleObject=new ExampleObject(driver);
        utils= new Utils();
    }


    public void EnterCredentials(String username,String password)throws Exception{
            BaseWeb.captureScreeen();
            utils.EnterText(exampleObject.username,username);
            utils.EnterText(exampleObject.password,password);

    }
    public void ClickLogin()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.loginbutton);

    }
    public void AddToCart()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.addcartbag);

    }
    public void Viewcart()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.viewcart);

    }
    public void CheckOut()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.checkout);
    }
    public void EnterCustomerDetails(String firstname,String lastname,String postalcode)throws Exception{
            BaseWeb.captureScreeen();
            utils.EnterText(exampleObject.firstname,firstname);
            utils.EnterText(exampleObject.lastName,lastname);
            utils.EnterText(exampleObject.postalCode,postalcode);

    }
    public void ClickContinue()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.Continue);

    }
    public void ClickFinish()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.finish);
    }
    public void Asserting(String value)throws Exception{
            BaseWeb.captureScreeen();
            utils.Assertion(exampleObject.Assert,value);
    }
    public void logout()throws Exception{
            BaseWeb.captureScreeen();
            utils.ClickElement(exampleObject.react);
            utils.ClickElement(exampleObject.logout);

    }
}
