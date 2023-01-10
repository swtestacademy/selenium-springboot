package com.swtestacademy.springbootselenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Objects;

//Custom Expected Condition Class
public class ElementContainsText implements ExpectedCondition<Boolean> {
    private final String textToFind;
    private final By     by;

    //Constructor (Set the given values)
    public ElementContainsText(final By by, final String textToFind) {
        this.by = by;
        this.textToFind = textToFind;
    }

    //Override the apply method with your own functionality
    @Override
    public Boolean apply(WebDriver webDriver) {
        //Find the element with given By method (By CSS, XPath, Name, etc.)
        WebElement element = Objects
            .requireNonNull(webDriver)
            .findElement(this.by);

        //Check that the element contains given text?
        return element
            .getText()
            .contains(this.textToFind);
    }

    //This is for log message. I override it because when test fails, it will give us a meaningful message.
    @Override
    public String toString() {
        return ": \"Does " + this.by + " contain " + this.textToFind + "?\"";
    }
}
