package com.redhat.darcy.webdriver;

import com.opera.core.systems.OperaDriver;
import com.redhat.darcy.webdriver.internal.CachingTargetLocator;
import com.redhat.darcy.webdriver.internal.ForwardingTargetedWebDriver;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeNotNull;

public class OperaBrowserFactoryTest {
    @Before
    public void setupCheck() {
        assumeNotNull(System.getProperty("webdriver.opera.driver"));
    }
    @Test
    public void shouldBeInstanceOfUntargetedOperaDriver() {
        WebDriverBrowserFactory browserFactory = new OperaBrowserFactory();

        WebDriverBrowser browser = (WebDriverBrowser) browserFactory.newBrowser();
        ForwardingTargetedWebDriver webDriver = (ForwardingTargetedWebDriver) browser.getWrappedDriver();
        CachingTargetLocator targetLocator = (CachingTargetLocator) webDriver.getTargetLocator();

        assertThat(targetLocator.getUntargetedDriver(), instanceOf(OperaDriver.class));
        browser.close();
    }
}
