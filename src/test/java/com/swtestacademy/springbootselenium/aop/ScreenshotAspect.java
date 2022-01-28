package com.swtestacademy.springbootselenium.aop;

import com.swtestacademy.springbootselenium.annotations.TakeScreenshot;
import com.swtestacademy.springbootselenium.utils.ScreenshotUtil;
import java.io.IOException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ScreenshotAspect {
    @Autowired
    private ScreenshotUtil screenshotUtil;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint joinPoint, TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotUtil.takeScreenShot(joinPoint.getSignature().getName());
    }
}
