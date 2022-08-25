package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class Delay {

    WebDriver driver;

    public Delay(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilWebElementWillBeVisible_Click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitUntilWebElementWillBeVisible_SendKeys(WebElement element,String text) {
        WebDriverWait wait = new WebDriverWait(this.driver, ofSeconds(10));
        WebElement delayElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        delayElement.clear();
        delayElement.sendKeys(text);
    }
}
