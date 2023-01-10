package com.swtestacademy.springbootselenium.utils;

import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

@LazyComponent
public class BrowserOps {
    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.DRIVER, Level.ALL);

        chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
        return chromeOptions;
    }

    public FirefoxOptions getFireFoxOptions() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("devtools.console.stdout.content", true);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.DRIVER, Level.ALL);

        firefoxOptions
            .setProfile(firefoxProfile)
            .setCapability("moz:loggingPrefs", logPrefs);
        return firefoxOptions;
    }
}
