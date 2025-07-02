package org.codewithismail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage  {
    private WebDriver driver;

    private By boardNameInput = By.id("board_name");
    private By createBoardButton = By.cssSelector("form#new_board_form button");
    private By listNameInput = By.id("list_name");
    private By saveListButton = By.cssSelector("form#new_list_form button");
    private By addCardLink = By.linkText("Add a new card...");
    private By cardNameInput = By.id("card_name");
    private By addCardButton = By.cssSelector("form#new_card_form button");
    private By signOutButton = By.cssSelector("#crawler-sign-out > span");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createBoard(String boardName) {
        driver.findElement(boardNameInput).sendKeys(boardName);
        driver.findElement(createBoardButton).click();
    }

    public void createList(String listName) {
        driver.findElement(listNameInput).sendKeys(listName);
        driver.findElement(saveListButton).click();
    }

    public void addCard(String... cardItems) {
        driver.findElement(addCardLink).click();
        for (String item : cardItems) {
            driver.findElement(cardNameInput).sendKeys(item + "\n");
        }
        driver.findElement(addCardButton).click();
    }

    public void signOut() {
        driver.findElement(signOutButton).click();
    }

}
