package com.swtestacademy.springbootselenium.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import com.swtestacademy.springbootselenium.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@LazyComponent
public class LoginPage extends BasePage {

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "email")
    public WebElement userName;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    By loginButtonBy          = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");

    //*********Page Methods*********
    public LoginPage login(String userName, String password) {
        writeText(this.userName, userName);
        writeText(this.password, password);
        jsClick(loginButtonBy);
        return this;
    }

    public LoginPage verifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public LoginPage verifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public LoginPage verifyLogEntryFailMessage() {
        assertTrue(LogUtil.isLoginErrorLog(driver));
        return this;
    }

    @Override public boolean isAt() {
        return this.wait.until((d) -> this.userName.isDisplayed());
    }
}
