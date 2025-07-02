package org.codewithismail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private By emailInput = By.id("user_email");
    private By passwordInput = By.id("user_password");
    private By loginButton = By.cssSelector("button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(By.cssSelector(".error")).getText(); // Adjust selector
    }


    public void loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
