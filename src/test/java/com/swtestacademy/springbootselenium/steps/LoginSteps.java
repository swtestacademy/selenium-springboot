package com.swtestacademy.springbootselenium.steps;

import com.swtestacademy.springbootselenium.annotations.LazyAutowired;
import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import com.swtestacademy.springbootselenium.annotations.TakeScreenshot;
import com.swtestacademy.springbootselenium.pages.HomePage;
import com.swtestacademy.springbootselenium.pages.LoginPage;

@LazyComponent
public class LoginSteps {
    @LazyAutowired
    HomePage homePage;

    @LazyAutowired
    LoginPage loginPage;

    public LoginSteps givenIAmAtLoginPage() {
        homePage
            .goToHomePage()
            .goToLoginPage();
        return this;
    }

    public LoginSteps whenILogin(String userName, String password) {
        loginPage
            .login(userName, password);
        return this;
    }

    public LoginSteps thenIVerifyUserNameErrorMessages(String expected) {
        loginPage
            .verifyLoginUserNameErrorMessage(expected);
        return this;
    }

    @TakeScreenshot("thenIVerifyLogEntryFailMessage")
    public LoginSteps thenIVerifyLogEntryFailMessage() {
        loginPage
            .verifyLogEntryFailMessage();
        return this;
    }

    @TakeScreenshot("thenIVerifyPasswordErrorMessage")
    public LoginSteps thenIVerifyPasswordErrorMessage(String expected) {
        loginPage
            .verifyPasswordErrorMessage(expected);
        return this;
    }
}
