package dataProviders;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "user-dataProvider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Uname","Pass"}};
    }
}
