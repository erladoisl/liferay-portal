/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portalweb.portal.controlpanel.portal;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * <a href="AdvancedSearchUserTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchUserTest extends BaseTestCase {
	public void testAdvancedSearchUser() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Users")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Users"));
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Advanced \u00bb");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_125_firstName")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.typeKeys("_125_firstName", RuntimeVariables.replace("Selen"));
		selenium.type("_125_firstName", RuntimeVariables.replace("Selen"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("selenium01"));
		assertTrue(selenium.isTextPresent("selenium02"));
		selenium.type("_125_firstName", RuntimeVariables.replace("Selen1"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium01"));
		assertFalse(selenium.isTextPresent("selenium02"));
		selenium.type("_125_firstName", RuntimeVariables.replace(""));
		selenium.type("_125_middleName", RuntimeVariables.replace("lenn"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("selenium01"));
		assertTrue(selenium.isTextPresent("selenium02"));
		selenium.type("_125_middleName", RuntimeVariables.replace("lenn1"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium01"));
		assertFalse(selenium.isTextPresent("selenium02"));
		selenium.type("_125_middleName", RuntimeVariables.replace(""));
		selenium.type("_125_lastName", RuntimeVariables.replace("nium"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("selenium01"));
		assertTrue(selenium.isTextPresent("selenium02"));
		selenium.type("_125_lastName", RuntimeVariables.replace("nium1"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium01"));
		assertFalse(selenium.isTextPresent("selenium02"));
		selenium.type("_125_lastName", RuntimeVariables.replace(""));
		selenium.type("_125_screenName", RuntimeVariables.replace("selenium"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("selenium01"));
		assertTrue(selenium.isTextPresent("selenium02"));
		selenium.type("_125_screenName", RuntimeVariables.replace("selenium1"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium01"));
		assertFalse(selenium.isTextPresent("selenium02"));
		selenium.type("_125_screenName", RuntimeVariables.replace(""));
		selenium.type("_125_emailAddress",
			RuntimeVariables.replace("selenium.com"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("selenium01"));
		assertTrue(selenium.isTextPresent("selenium02"));
		selenium.type("_125_emailAddress",
			RuntimeVariables.replace("selenium.com1"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium01"));
		assertFalse(selenium.isTextPresent("selenium02"));
		selenium.type("_125_emailAddress", RuntimeVariables.replace(""));
		selenium.click("link=\u00ab Basic");
	}
}