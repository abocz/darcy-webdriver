package com.redhat.darcy.webdriver.internal;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.internal.WrapsDriver;

@RunWith(JUnit4.class)
public class TargetedWebDriverTest {
    @Test
    public void shouldWrapDriver() {
        TargetedWebDriver mockedDriver = mock(TargetedWebDriver.class);
        assertThat(mockedDriver, instanceOf(WrapsDriver.class));
    }

}
