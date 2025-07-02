package org.codewithismail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By signOutButton = By.cssSelector("#crawler-sign-out > span");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignOutButtonVisible() {
        return !driver.findElements(signOutButton).isEmpty();
    }

    public void signOutIfPresent() {
        if (isSignOutButtonVisible()) {
            driver.findElement(signOutButton).click();
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickAddNewBoard() {
        driver.findElement(By.id("add_new_board")).click();
    }

    public void enterBoardName(String name) {
        driver.findElement(By.id("board_name")).sendKeys(name);
    }

    public void submitBoard() {
        driver.findElement(By.cssSelector("button")).click();
    }
}
