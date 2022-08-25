package codeSignal.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.homePages.CommentCreationComponent;
import pages.homePages.PostCreationComponent;

import pages.homePages.ViewPostComponent;
import utils.DriverFactory;

public class BaseTest extends DriverFactory {
    //region <Page Class Instance Declaration>
    public ViewPostComponent viewPostComponent;
    public PostCreationComponent postCreationComponent;
    public CommentCreationComponent commentCreationComponent;

    //endregion


    public static final String ENVIRONMENT_URL = "https://cs-qa-task-frontend.vercel.app/";
    private final boolean REMOTE = false;

    public BaseTest() {
    }


    @BeforeMethod
    public void setup() {
        try {
            super.initDriver(ENVIRONMENT_URL, REMOTE);
        } catch (org.openqa.selenium.TimeoutException exception) {
            super.initDriver(ENVIRONMENT_URL, REMOTE);
        }
        //region <Page Class Instance Initialization >
        postCreationComponent = PageFactory.initElements(driver, PostCreationComponent.class);
        viewPostComponent = PageFactory.initElements(driver,ViewPostComponent.class);
        commentCreationComponent = PageFactory.initElements(driver, CommentCreationComponent.class);
        //endregion
    }

    @AfterMethod
    public void afterMethod() {
        try {
             this.driver.quit();
        } catch (Exception exception) {

        }
    }

}