package com.swtestacademy.springbootselenium.steps;

import com.swtestacademy.springbootselenium.annotations.LazyAutowired;
import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import com.swtestacademy.springbootselenium.annotations.TakeScreenshot;
import com.swtestacademy.springbootselenium.pages.HomePage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class HomeSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    HomePage homePage;

    public HomeSteps givenIAmAtHomePage() {
        homePage
            .goToHomePage();
        return this;
    }

    @TakeScreenshot
    public HomeSteps thenIVerifyIAmAtHomePage() {
            homePage
                .verifyThatIAmAtHomePage();
        return this;
    }
}
