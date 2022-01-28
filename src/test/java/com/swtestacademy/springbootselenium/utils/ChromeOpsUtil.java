package com.swtestacademy.springbootselenium.utils;

import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@LazyComponent
public class ChromeOpsUtil {
    public static ChromeOptions getChromeOptions() {
        DesiredCapabilities caps = new DesiredCapabilities();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return new ChromeOptions().merge(caps);
    }
}
