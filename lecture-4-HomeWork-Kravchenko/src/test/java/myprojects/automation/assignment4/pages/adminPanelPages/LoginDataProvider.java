package myprojects.automation.assignment4.pages.adminPanelPages;

import org.testng.annotations.DataProvider;


public class LoginDataProvider {
    @DataProvider(name = "log-in")
    public static Object[][] getLoginData() {
        return new String[][]{
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }
}
