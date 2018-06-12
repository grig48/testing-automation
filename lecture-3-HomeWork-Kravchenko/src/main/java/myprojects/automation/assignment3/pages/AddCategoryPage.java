package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;

public class AddCategoryPage {

    //      "Имя" field for entering category name
    private static By categoryNameField = By.id("name_1");
    //      "Сохранить" button
    private static By saveCategoryBtn = By.id("category_form_submit_btn");
    //       Add category message field
    private static By messageAddCategory = By.xpath("//*[@id=\"content\"]/div[3]/div");
    //       The button sorting categories by name in ascending order in table
    private static By sortUpNameCategory = By.xpath("//*[@id=\"table-category\"]//tr[1]/th[3]/span/a[2]");
    //       The button sorting the categories by name in descending order in the table
    private static By sortDownNameCategory = By.xpath("//*[@id=\"table-category\"]//tr[1]/th[3]/span/a[1]");
    //       The name of the category field in the table
    private static By categoryInTable = By.xpath("//*[contains(text(),categoryName)]");
    //       The name of the category being created
    private static String categoryName = "Teenagers(Test)";


    public static By getCategoryNameField() {
        return categoryNameField;
    }

    public static By getSaveCategoryBtn() {
        return saveCategoryBtn;
    }

    public static By getMessageAddCategory() {
        return messageAddCategory;
    }

    public static By getSortUpNameCategory() {
        return sortUpNameCategory;
    }

    public static By getSortDownNameCategory() {
        return sortDownNameCategory;
    }

    public static By getCategoryInTable() {
        return categoryInTable;
    }

    public static String getCategoryName() {
        return categoryName;
    }
}
