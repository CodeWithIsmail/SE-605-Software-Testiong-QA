package org.codewithismail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage {

    private WebDriver driver;

    // Locators
    private By firstBoard = By.cssSelector("#\\31 -first > .inner h4");
    private By addNewListButton = By.cssSelector(".add-new > .inner");
    private By listNameInput = By.id("list_name");
    private By submitButton = By.cssSelector("button");

    public BoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstBoard() {
        driver.findElement(firstBoard).click();
    }

    public void clickAddNewList() {
        driver.findElement(addNewListButton).click();
    }

    public void enterListName(String name) {
        driver.findElement(listNameInput).click();
        driver.findElement(listNameInput).sendKeys(name);
    }

    public void submitList() {
        driver.findElement(submitButton).click();
    }
}
