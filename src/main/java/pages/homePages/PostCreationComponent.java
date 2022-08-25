package pages.homePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;


public class PostCreationComponent extends BasePage {
    private final BasePage basePage;
    public PostCreationComponent(WebDriver driver) {
        super(driver);
        basePage = new BasePage(driver);
    }
    //region <ElementsRegion>
    @FindBy(xpath = "//*[@placeholder = \"What's on your mind?\"]")
    private List<WebElement> postInputelemnt;

    @FindBy(xpath = "//*[@alt = 'send' ]" )
    private List<WebElement> addPostButton;
    //endregion

    //region <ActionsRegion>
    public PostCreationComponent fillInPostInput(String postText) {
       basePage.fillTextToElement(postInputelemnt.get(1), postText);
        return this;
    }

    public  PostCreationComponent clickOnAddPostButton(){
        basePage.click(addPostButton.get(1));
        return this;
    }

    public PostCreationComponent addPost(String posText){
        fillInPostInput(posText);
        clickOnAddPostButton();
        return this;
    }

    //endregion


}