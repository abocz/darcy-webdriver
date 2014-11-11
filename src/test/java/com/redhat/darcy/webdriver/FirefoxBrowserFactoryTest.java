package com.redhat.darcy.webdriver;

import com.redhat.darcy.webdriver.internal.CachingTargetLocator;
import com.redhat.darcy.webdriver.internal.ForwardingTargetedWebDriver;
import com.redhat.darcy.webdriver.testing.rules.TraceTestName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class FirefoxBrowserFactoryTest {
    @Rule
    public TraceTestName traceTestName = new TraceTestName();

    @Test
    public void shouldBeInstanceOfUntargetedFirefoxDriver() {
        WebDriverBrowserFactory browserFactory = new FirefoxBrowserFactory();

        WebDriverBrowser browser = (WebDriverBrowser) browserFactory.newBrowser();
        ForwardingTargetedWebDriver webDriver = (ForwardingTargetedWebDriver) browser.getWrappedDriver();
        CachingTargetLocator targetLocator = (CachingTargetLocator) webDriver.getTargetLocator();

        assertThat(targetLocator.getUntargetedDriver(), instanceOf(FirefoxDriver.class));
        browser.close();
    }

    @Test
    public void shouldBeFireFoxin() {

        FirefoxBrowserFactory browserFactory = new FirefoxBrowserFactory();
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("webdriver_firefox_port",7046);
        browserFactory = browserFactory.desiring(cap);
        WebDriverBrowser browser = (WebDriverBrowser) browserFactory.newBrowser();
        ForwardingTargetedWebDriver webDriver = (ForwardingTargetedWebDriver) browser.getWrappedDriver();
        CachingTargetLocator targetLocator = (CachingTargetLocator) webDriver.getTargetLocator();

        assertThat(targetLocator.getUntargetedDriver(), instanceOf(FirefoxDriver.class));
        browser.close();
    }


}
