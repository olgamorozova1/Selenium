package org.issoft.automation.page;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Listener implements AfterTestExecutionCallback  {
    private WebDriver driver = new ChromeDriver();

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] captureScreenshot (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Boolean testResult = extensionContext.getExecutionException().isPresent();
        if (testResult) {
            captureScreenshot(driver);
        }
    }
}
