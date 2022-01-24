package com.swtestacademy.springbootselenium.tests;

import com.swtestacademy.springbootselenium.annotations.LazyAutowired;
import com.swtestacademy.springbootselenium.steps.LoginSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {
    @LazyAutowired
    LoginSteps loginSteps;

    @Test
    public void invalidUserNameInvalidPassword() {
        System.out.println("Driver of invalidUserNameInvalidPassword test: " + applicationContext
            .getBean(WebDriver.class));

        loginSteps
            .givenIAmAtLoginPage()
            .whenILogin("onur@swtestacademy.com", "11223344")
            .thenIVerifyLogEntryFailMessage();
    }

    @Test
    public void emptyUserEmptyPassword() {
        System.out.println("Driver of emptyUserEmptyPassword test: " + applicationContext
            .getBean(WebDriver.class));

        loginSteps
            .givenIAmAtLoginPage()
            .whenILogin("", "")
            .thenIVerifyUserNameErrorMessages("Lütfen e-posta adresinizi girin.")
            .thenIVerifyPasswordErrorMessage("Bu alanın doldurulması zorunludur.");
    }
}
