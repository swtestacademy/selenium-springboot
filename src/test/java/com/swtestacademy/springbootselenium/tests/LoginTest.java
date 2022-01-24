package com.swtestacademy.springbootselenium.tests;

import com.swtestacademy.springbootselenium.annotations.LazyAutowired;
import com.swtestacademy.springbootselenium.steps.LoginSteps;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

//@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {
    @LazyAutowired
    LoginSteps loginSteps;


    @Test
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
        System.out.println("Driver of invalidLoginTest_InvalidUserNameInvalidPassword" + applicationContext
            .getBean(WebDriver.class));

        loginSteps
            .givenIAmAtLoginPage()
            .whenILogin("onur@swtestacademy.com", "11223344")
            .thenIVerifyLogEntryFailMessage();
    }
//
//    @Test
//    public void invalidLoginTest_EmptyUserEmptyPassword() {
//        System.out.println("Driver of invalidLoginTest_EmptyUserEmptyPassword" + driver.toString());
//        page
//            .getPage(HomePage.class)
//            .givenIAmAtHomePage()
//            .whenIGoToLoginPage()
//            .andILoginToN11("", "")
//            .thenIVerifyLoginUserNameErrorMessage("Lütfen e-posta adresinizi girin.")
//            .thenIVerifyPasswordErrorMessage("Bu alanın doldurulması zorunludur.");
//    }
}
