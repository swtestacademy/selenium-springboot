package com.swtestacademy.springbootselenium.configuration;

import com.swtestacademy.springbootselenium.annotations.LazyConfiguration;
import com.swtestacademy.springbootselenium.annotations.WebdriverScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;

@LazyConfiguration
public class WebDriverConfig {
    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager
            .firefoxdriver()
            .setup();
        return new FirefoxDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @Primary
    public WebDriver chromeDriver() {
        WebDriverManager
            .firefoxdriver()
            .setup();
        return new ChromeDriver();
    }
}
