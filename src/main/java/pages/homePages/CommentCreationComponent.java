package pages.homePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CommentCreationComponent extends BasePage {
    private final BasePage basePage;
    public CommentCreationComponent(WebDriver driver) {
        super(driver);
        basePage = new BasePage(driver);
    }
    //region <ElementsRegion>
    @FindBy(xpath = "//*[@placeholder = \"Write a comment...\"]")
    private WebElement commentInputElement;

    @FindBy(xpath = "//*[@alt = 'send' ]" )
    private List<WebElement> addCommentButton;
    //endregion

    //region <ActionsRegion>
    public CommentCreationComponent fillInCommentInput(String CommentText) {
        basePage.fillTextToElement(commentInputElement, CommentText);
        return this;
    }

    public  CommentCreationComponent clickOnAddFirstCommentButton(){
        basePage.click(addCommentButton.get(2));
        return this;
    }

    public CommentCreationComponent addComment(String CommentText){
        fillInCommentInput(CommentText);
        clickOnAddFirstCommentButton();
        return this;
    }
    //endregion

}
