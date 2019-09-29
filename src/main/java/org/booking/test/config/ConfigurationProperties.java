package org.booking.test.config;

import org.booking.test.core.BrowserType;
import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("configuration.properties")
public class ConfigurationProperties {

    @Property("endpoint")
    public String endpoint;

    @Property("timeout.implicitlywait")
    private Long timeoutImplicitlyWait = 5L;

    @Property("timeout.pageload")
    private Long timeoutPageLoad = 30L;

    @Property("test.browser.type")
    private BrowserType browserType = BrowserType.CHROME;

    @Property("test.chrome.driver.path")
    private String chromeDriverPath;

    @Property("test.default.hub")
    private String defaultHub;

    @Property("test.locale")
    private String locale = "en";

    private ConfigurationProperties(){
        PropertyLoader.newInstance().populate(this);
    }

    public static ConfigurationProperties getInstance(){
        if (configProperties == null){
            configProperties = new ConfigurationProperties();
        }
        return configProperties;
    }

    private static ConfigurationProperties configProperties;

    public String getEndpoint() {
        return endpoint;
    }

    public Long getTimeoutImplicitlyWait() {
        return timeoutImplicitlyWait;
    }

    public Long getTimeoutPageLoad() {
        return timeoutPageLoad;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public String getDefaultHub() {
        return defaultHub;
    }

    public String getLocale() {
        return locale;
    }
}
