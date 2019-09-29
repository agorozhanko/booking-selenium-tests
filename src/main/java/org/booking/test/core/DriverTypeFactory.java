package org.booking.test.core;

import org.booking.test.config.ConfigurationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.stqa.selenium.factory.WebDriverFactory;

public class DriverTypeFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverTypeFactory.class);

    /**
     * Creates local web driver
     *
     * @param browserType browser name (chrome, firefox)
     * @return WebDriver instance
     */
    static WebDriver createDriver(BrowserType browserType) {
        DesiredCapabilities capabilities = null;
        switch (browserType) {
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--lang=" + ConfigurationProperties.getInstance().getLocale());
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                break;
            default:
                logger.info("Unsupported browser type " + browserType);
        }
        return WebDriverFactory.getDriver(capabilities);
    }

    static void closeBrowser(WebDriver webDriver) {
        WebDriverFactory.dismissDriver(webDriver);
    }
}
