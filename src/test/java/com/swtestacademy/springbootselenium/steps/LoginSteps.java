package com.swtestacademy.springbootselenium.steps;

import com.swtestacademy.springbootselenium.annotations.ElapsedTime;
import com.swtestacademy.springbootselenium.annotations.LazyAutowired;
import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import com.swtestacademy.springbootselenium.annotations.TakeScreenshot;
import com.swtestacademy.springbootselenium.pages.HomePage;
import com.swtestacademy.springbootselenium.pages.LoginPage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class LoginSteps {
    @Value("${browser}")
    private String browser;

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

    @ElapsedTime
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

    @TakeScreenshot
    public LoginSteps thenIVerifyInvalidLoginMessage() {
        loginPage.verifyPasswordErrorMessageWithCss("E-posta adresiniz veya şifreniz hatalı");
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyPasswordErrorMessage(String expected) {
        loginPage
            .verifyPasswordErrorMessage(expected);
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyPasswordErrorMessageWithCss(String expected) {
        loginPage
            .verifyPasswordErrorMessageWithCss(expected);
        return this;
    }
}
