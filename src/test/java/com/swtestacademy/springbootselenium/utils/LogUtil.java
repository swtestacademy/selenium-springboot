package com.swtestacademy.springbootselenium.utils;

import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

@LazyComponent
public class LogUtil {
    public static LogEntries getLogs(WebDriver driver) {
        return driver
            .manage()
            .logs()
            .get(LogType.BROWSER);
    }

    public void isLoginErrorLog(WebDriver driver) {
        //Check logs (works only Chrome and Edge)
        LogEntries logEntries = driver
            .manage()
            .logs()
            .get(LogType.BROWSER);
        Assert.assertTrue(logEntries
            .getAll()
            .stream()
            .anyMatch(logEntry -> logEntry
                .getMessage()
                .contains("An invalid email address was specified")));
    }
}
