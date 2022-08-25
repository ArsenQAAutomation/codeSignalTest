package pages.homePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ViewPostComponent extends BasePage {
    BasePage basePage = new BasePage();
    WebDriver driver;

    public ViewPostComponent(WebDriver driver){
        super(driver);
        basePage = new BasePage(driver);
    }

    //region <ElementsRegion>
    @FindBy(xpath = "//*[Contains(@class, 'post')]")
    WebElement firstPost;

    @FindBy(className = "post__caption")
    WebElement firstPostTextElement;
    //endregion

    //region <ActionsRegion>

    public ViewPostComponent checkPostelementIsVisible()  {
        basePage.waitElementToBeVisible(firstPostTextElement);
        return this;
    }

    public String getFirstPostText(){
        return basePage.getText(firstPostTextElement);
    }
    //endregion



}
