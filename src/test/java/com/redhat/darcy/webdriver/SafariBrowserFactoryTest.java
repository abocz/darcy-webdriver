package com.redhat.darcy.webdriver;

import com.redhat.darcy.webdriver.internal.CachingTargetLocator;
import com.redhat.darcy.webdriver.internal.ForwardingTargetedWebDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.safari.SafariDriver;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

public class SafariBrowserFactoryTest {
    @Before
    public void setupCheck() {
        Platform current = Platform.getCurrent();
        assumeTrue(Platform.MAC.is(current));
        assumeNotNull(System.getProperty("webdriver.safari.driver"));
    }

    @Test
    public void shouldBeInstanceOfUntargetedSafariDriver() {
        WebDriverBrowserFactory browserFactory = new SafariBrowserFactory();

        WebDriverBrowser browser = (WebDriverBrowser) browserFactory.newBrowser();
        ForwardingTargetedWebDriver webDriver = (ForwardingTargetedWebDriver) browser.getWrappedDriver();
        CachingTargetLocator targetLocator = (CachingTargetLocator) webDriver.getTargetLocator();

        assertThat(targetLocator.getUntargetedDriver(), instanceOf(SafariDriver.class));
        browser.close();
    }
}
