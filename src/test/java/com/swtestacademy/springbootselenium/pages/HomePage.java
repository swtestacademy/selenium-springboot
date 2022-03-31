package com.swtestacademy.springbootselenium.pages;

import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class HomePage extends BasePage {
    @Autowired
    LoginPage loginPage;

    @Value("${application.url}")
    private String baseURL;

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.CLASS_NAME, using = "btnSignIn")
    public WebElement signInButton;

    By homePageLogo = By.cssSelector(".logo.home");

    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public HomePage goToLoginPage() {
        click(signInButton);
        return this;
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.signInButton.isDisplayed());
    }

    public HomePage verifyThatIAmAtHomePage() {
        Assertions.assertTrue(driver.findElement(homePageLogo).isDisplayed());
        return this;

    }
}