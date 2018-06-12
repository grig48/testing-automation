package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;

public class CategoriesAdminPage {

    //      "Добавить категорию" button
    private static By addCategoryBtn = By.id("page-header-desc-category-new_category");


    public static By getAddCategoryBtn() {
        return addCategoryBtn;
    }
}
