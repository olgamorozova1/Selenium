package org.issoft.automation.page.FinalTask.TestListeners;

import io.qameta.allure.Attachment;
import org.issoft.automation.test.FinalTask.BaseTestFinalTask;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class TestListener implements TestWatcher {
    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] captureScreenshot() {
        return ((TakesScreenshot) BaseTestFinalTask.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Details", type = "text/plain")
    private String getTestDetails() {
        Capabilities capabilities = ((RemoteWebDriver) BaseTestFinalTask.driver).getCapabilities();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return "Date: " + format.format((date)) +
                "\nBrowser name: " + capabilities.getBrowserName() +
                "\nBrowser version:" + capabilities.getVersion() +
                "\nPlatform: " + capabilities.getPlatform();
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
        getTestDetails();
    }
}
