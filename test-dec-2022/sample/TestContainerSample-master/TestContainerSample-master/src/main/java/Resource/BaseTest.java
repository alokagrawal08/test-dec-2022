package Resource;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

import java.util.concurrent.TimeUnit;

 

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.io.FileHandler;

public class BaseTest {
		
		 public static WebDriver driver;

         public Properties prop;

         public static Logger log = LogManager.getLogger(BaseTest.class.getName());

        

         public WebDriver initializeDriver() throws IOException  {

                        

                         System.out.println(System.getProperty("user.dir"));

                        

                         prop = new Properties();

                        

                         FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//wipro//Resources//data.properties");

                         prop.load(fis);

                        

                         String browsername = prop.getProperty("browser");

                        

                         System.out.println("Browser for execution is: "+browsername);

                        

                         if(browsername.equals("chrome")) {

                                         System.setProperty("webdriver.chrome.driver", "//Users//samgladson//Thoughtworks//openbank//Selenium//chromedriver");

                                         driver = new ChromeDriver();

                         }

                        

                         if(browsername.equals("firefox")) {

                                         System.setProperty("webdriver.gecko.driver", "E://Workspace//geckodriver.exe");

                                         driver = new FirefoxDriver();

                         }

                        

                         if(browsername.equals("internetexplorer")) {

                                         System.setProperty("webdriver.ie.driver", "E://Workspace//IEDriverServer.exe");

                                         driver = new InternetExplorerDriver();

                         }

                        

                         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);                         

                        

                         return driver;

         }

        

         public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException {

                        

                         TakesScreenshot ts = (TakesScreenshot) driver;

                         File source = ts.getScreenshotAs(OutputType.FILE);

                         String destinationFile = System.getProperty("user.dir")+"//reports//"+testcasename+".png";

                         FileHandler.copy(source, new File(destinationFile));

                         return destinationFile;
		

	}
	
}
