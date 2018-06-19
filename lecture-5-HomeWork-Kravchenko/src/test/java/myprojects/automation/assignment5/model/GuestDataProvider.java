package myprojects.automation.assignment5.model;

import org.testng.annotations.DataProvider;


public class GuestDataProvider {

    @DataProvider(name = "Guest")
    public static Object[][] getGuestData() {
        return new String[][]{
                {"Григорій", "Кравченко", "grig48+1@gmail.com", "вул.Вереснева буд.76, кв.333", "20706", "Сміла"}
        };
    }
}
