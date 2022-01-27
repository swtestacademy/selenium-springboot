package com.swtestacademy.springbootselenium.utils;

import com.swtestacademy.springbootselenium.annotations.LazyComponent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;

@LazyComponent
public class ScreenshotUtil {
    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot(String testName) throws IOException {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve( testName + ".png").toFile());
    }

    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

}
