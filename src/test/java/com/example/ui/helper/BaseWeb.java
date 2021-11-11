package com.example.ui.helper;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseWeb {
    public static WebDriver driver;
    static String browserName,websiteURL;
    public static String screenshotdir = System.getProperty("user.dir") + "/test-output/Screenshots/";

    public static WebDriver getDriver() {

        if (driver == null) {

            ConfigFileReader configFileReader = new ConfigFileReader();
            browserName = configFileReader.getPropertyValues("browser");
            websiteURL = configFileReader.getPropertyValues("url");

            if (browserName.contains("firefox") || browserName.contains("ff")) {
                driver = new FirefoxDriver();
            }
            if (browserName.contains("chrome") || browserName.contains("cr")) {
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        driver.get(websiteURL);
        return driver;

    }

    public static void closeBrowser() {
        if (driver != null)
            driver.quit();
    }


    public static void takeScreenshot(String name) {
        File screenshotdirectory = new File("test-output/Screenshots");

        if (!screenshotdirectory.exists()) {
            screenshotdirectory.mkdir();
        }
        try {
            String fileName = screenshotdirectory + "/" + name + System.currentTimeMillis() + ".png";
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File(fileName));

            System.out.println("Screenshot taken - " + fileName);
        } catch (Exception e) {

            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    public static String getBase64Screenshot() throws Exception
    {
        String Base64StringOfScreenshot="";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);
        FileUtils.copyFile(src, new File(screenshotdir + "image_" + sDate + ".png"));

        byte[] fileContent = FileUtils.readFileToByteArray(src);
        Base64StringOfScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
        return Base64StringOfScreenshot;
    }
    public static void captureScreeen()throws Exception{
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getBase64Screenshot());

    }


}
