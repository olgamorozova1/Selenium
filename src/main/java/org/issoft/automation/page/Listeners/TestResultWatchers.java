package org.issoft.automation.page.Listeners;

import io.qameta.allure.Attachment;
import org.issoft.automation.test.Task60PageObject.TestBase;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

public class TestResultWatchers implements TestWatcher {
    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] captureScreenshot() {
        return ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        captureScreenshot();
        cause.printStackTrace();
        Capabilities capabilities = ((RemoteWebDriver) TestBase.driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String versionOfBrowser = capabilities.getVersion().toString();
        System.out.println(browserName + " " + versionOfBrowser);
    }
}
