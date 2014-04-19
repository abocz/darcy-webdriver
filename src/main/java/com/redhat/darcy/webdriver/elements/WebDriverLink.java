/*
 Copyright 2014 Red Hat, Inc. and/or its affiliates.

 This file is part of darcy-webdriver.

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.redhat.darcy.webdriver.elements;

import org.openqa.selenium.WebElement;

import com.redhat.darcy.ui.elements.Link;
import com.redhat.darcy.webdriver.WebDriverElementFactory;

public class WebDriverLink extends WebDriverElement implements Link {
    public WebDriverLink(WebElement source) {
        super(source);
    }

    @Override
    public void click() {
        me.click();
    }
    
    @Override
    public String getLinkText() {
        return me.getText();
    }

    public static class WebDriverLinkFactory implements WebDriverElementFactory<Link> {
        @Override
        public Link element(WebElement source) {
            return new WebDriverLink(source);
        }
    }
}
