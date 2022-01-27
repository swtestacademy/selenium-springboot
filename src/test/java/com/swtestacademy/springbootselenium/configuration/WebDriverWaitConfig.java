package com.swtestacademy.springbootselenium.configuration;

import com.swtestacademy.springbootselenium.annotations.LazyConfiguration;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofMillis(this.timeout));
    }
}
