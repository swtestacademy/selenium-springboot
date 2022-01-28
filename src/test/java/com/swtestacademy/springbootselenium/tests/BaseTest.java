package com.swtestacademy.springbootselenium.tests;

import com.swtestacademy.springbootselenium.annotations.LazyAutowired;
import com.swtestacademy.springbootselenium.annotations.SeleniumTest;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

@SeleniumTest
@Getter
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setup() {
    }

    @LazyAutowired
    public ApplicationContext applicationContext;

    @AfterEach
    public void teardown() {
        this.applicationContext
            .getBean(WebDriver.class)
            .quit();
    }
}
