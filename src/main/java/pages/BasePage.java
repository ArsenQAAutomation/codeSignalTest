package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public BasePage() {
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    // this method will used for clicking on element which is visible
    public void clickOnelement(WebElement element) {
        this.waitElementToBeVisible(element);
        this.waitElementTobeClickable(element);
        element.click();
    }

    public void waitElementToBeVisible(WebElement element){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementTobeClickable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fillTextToElement(WebElement element, String text)  {
        waitElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToWebElement(WebElement element) {
        waitElementToBeVisible(element);
        String javascript = "arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"nearest\"})";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, element);
    }

    public String generateRandomEmail() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + "@gmail.com";
        return randomEmail;
    }

    /**
     * Select element from select menu (drop-down) by visible text.
     *
     * @param element select menu element
     * @param text    visible text to be selected
     */
    public void selectElementByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    /**
     * Select item in drop down by item name.
     *
     * @param element WebElement of drop down
     * @param name    name of item
     */
    public void selectDropDownItemByName(WebElement element, String name) {
        new Select(element).selectByVisibleText(name);
    }

    /**
     * Select drop down list item by text.
     *
     * @param text text to be selected by
     */

    public void selectDropDownListItemByText(String text) {
        List<WebElement> options = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));
        int index = options.size() - 1;
        options.get(index).click();
    }

    /**
     * Select drop down list item by title.
     *
     * @param title title to be selected by
     */

    public void selectDropDownListItemByTitle(String title) {
        List<WebElement> options = driver.findElements(By.xpath("//*[contains(@title, '" + title + "')]"));
        int index = options.size() - 1;
        options.get(index).click();
    }

    /**
     * Select item from drop down by index.
     *
     * @param element drop down WebElement
     * @param index   index to be selected
     */
    public void selectDropDownItemByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    /**
     * Select item from drop down by value.
     *
     * @param element drop down WebElement
     * @param value   value to be selected
     */
    public void selectDropDownItemByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public void sendTextOnElement(WebElement element, String text) {
        waitElementToBeVisible(element);
        getElement(element).clear();
        element.sendKeys(text);
    }

    public WebElement getElement(WebElement element) {
        waitElementToBeVisible(element);
        return element;
    }

    public void click(WebElement element) {
        scrollToWebElement(element);
        waitElementToBeVisible(element);
        waitElementTobeClickable(element);
        element.click();
    }

    public String getElementtext(WebElement element) {

        return element.getAttribute("value");
    }

    public String getText(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

}
