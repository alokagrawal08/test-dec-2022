
package TestContainers;


import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.VncRecordingContainer;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class TestContainerSelenium {
    private static final File target = new File("/Users/samgladson/Downloads/CucumberFramework/recording");
    @ClassRule
    public static BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions()).withRecordingMode(RECORD_ALL,target, VncRecordingContainer.VncRecordingFormat.MP4);
    public static BrowserWebDriverContainer<?>  firefox = new BrowserWebDriverContainer<> ().withCapabilities(new FirefoxOptions());
    public static BrowserWebDriverContainer<?>  internetExplorer = new BrowserWebDriverContainer<>().withCapabilities(new InternetExplorerOptions());
    public static BrowserWebDriverContainer<?>  opera = new BrowserWebDriverContainer<>().withCapabilities(new OperaOptions());

    @Test
    public void whenNavigatedToPage_thenHeadingIsInThePage() {
        chrome.start();
        RemoteWebDriver driver = chrome.getWebDriver();
        driver.get("https://google.com");
        String heading = driver.findElement(By.name("btnI")).getAttribute("value");


        assertEquals("I'm Feeling Lucky", heading);
    }
}
