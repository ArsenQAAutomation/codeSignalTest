package dataProviders;

import org.testng.annotations.DataProvider;

public class PostAndCommentDataProvider {

    @DataProvider(name = "postAndComment-dataProvider")
    public Object[][] dpMethod(){
        return new Object[][] {{"text post", "comment"}};
    }
}
