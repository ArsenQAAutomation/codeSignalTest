package codeSignal.tests.simpleTest;

import codeSignal.tests.BaseTest;
import dataProviders.PostAndCommentDataProvider;
import dataProviders.PostDataPorvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    @Description("Add post and verift that text is correct")
    @Test(dataProvider = "post-dataProvider", dataProviderClass = PostDataPorvider.class)
    public void addPostTest(String post) {
        postCreationComponent.fillInPostInput(post)
                .clickOnAddPostButton();
        viewPostComponent.checkPostelementIsVisible();
        Assert.assertEquals(viewPostComponent.getFirstPostText(), post, "Post text do  not match");
    }

    @Description("Add comment and verift that text is correct")
    @Test(dataProvider = "postAndComment-dataProvider", dataProviderClass = PostAndCommentDataProvider.class)
    public void addCommentTest(String post, String comment) throws InterruptedException {
        postCreationComponent.fillInPostInput(post)
                .clickOnAddPostButton();
        viewPostComponent.checkPostelementIsVisible();
        Assert.assertEquals(viewPostComponent.getFirstPostText(), post, "Post text do  not match");
        commentCreationComponent.fillInCommentInput(comment)
                .clickOnAddFirstCommentButton();
    }
}
