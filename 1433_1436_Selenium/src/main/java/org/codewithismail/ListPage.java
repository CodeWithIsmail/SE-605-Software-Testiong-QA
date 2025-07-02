package org.codewithismail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListPage {
    private WebDriver driver;

    // Locator for add new card button on list with id 3
    private By addNewCardButton = By.cssSelector("#list_6 .add-new");
    private By cardNameInput = By.id("card_name");
    private By submitButton = By.cssSelector("button");

    public ListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewCard() {
        driver.findElement(addNewCardButton).click();
    }

    public void enterCardName(String cardName) {
        driver.findElement(cardNameInput).click();
        driver.findElement(cardNameInput).sendKeys(cardName);
    }

    public void submitCard() {
        driver.findElement(submitButton).click();
    }
}
