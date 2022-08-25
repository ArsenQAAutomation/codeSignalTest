package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class DriverFactory {
    public WebDriver driver;



    public DriverFactory() {

    }

    public void initDriver(String siteUrl, Boolean remote) {
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        //driver = WebDriverManager.getInstance(ChromeDriver.class).create();
        driver.manage().window().maximize();
        driver.get(siteUrl);
    }

}

