package com.redhat.darcy.webdriver;

import com.redhat.darcy.web.api.Browser;
import com.redhat.darcy.webdriver.elements.WebDriverElement;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Fluently describes a {@link com.redhat.darcy.web.api.BrowserFactory} that creates specifically
 * configured {@link org.openqa.selenium.phantomjs.PhantomJSDriver;}.
 */
public class PhantomJsBrowserFactory extends WebDriverBrowserFactory<PhantomJsBrowserFactory> {
    private DesiredCapabilities capabilities;
    private PhantomJSDriverService service;
    private ElementConstructorMap elementImpls = ElementConstructorMap
            .newElementConstructorMapWithDefaults();

    @Override
    public Browser newBrowser() {
        PhantomJSDriver driver;

        if (service != null) {
            driver = new PhantomJSDriver(service);
        } else if (capabilities != null) {
            driver = new PhantomJSDriver(capabilities);
        } else {
            driver = new PhantomJSDriver();
        }
        return makeBrowser(driver, elementImpls);
    }

    public PhantomJsBrowserFactory capableOf(Capabilities cap) {
        capabilities = new DesiredCapabilities(cap, capabilities);
        return this;
    }

    public PhantomJsBrowserFactory usingService(PhantomJSDriverService ser) {
        service = ser;
        return this;
    }

    @Override
    public <E extends WebDriverElement> PhantomJsBrowserFactory withElementImplementation(
            Class<? super E> type, ElementConstructor<E> constructor) {
        elementImpls.put(type, constructor);
        return this;
    }
}
