package dataProviders;

import org.testng.annotations.DataProvider;

public class PostDataPorvider {

    @DataProvider(name = "post-dataProvider")
    public Object[][] dpMethod(){
        return new Object[][] {{"text for post"},{"test"}};
    }
}
