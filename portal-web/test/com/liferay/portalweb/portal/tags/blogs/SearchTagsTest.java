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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * <a href="SearchTagsTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class SearchTagsTest extends BaseTestCase {
	public void testSearchTags() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Tags Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Blogs Tags Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("_33_keywords",
			RuntimeVariables.replace("selenium1 liferay1"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Tags1 Blogs1 Test1 Entry1"));
		assertFalse(selenium.isTextPresent("Tags2 Blogs2 Test2 Entry2"));
		assertFalse(selenium.isTextPresent("Tags3 Blogs3 Test3 Entry3"));
		selenium.type("_33_keywords",
			RuntimeVariables.replace("selenium2 liferay2"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Tags1 Blogs1 Test1 Entry1"));
		assertFalse(selenium.isTextPresent("Tags2 Blogs2 Test2 Entry2"));
		assertTrue(selenium.isTextPresent("Tags3 Blogs3 Test3 Entry3"));
		selenium.type("_33_keywords",
			RuntimeVariables.replace("selenium3 liferay3"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Tags1 Blogs1 Test1 Entry1"));
		assertTrue(selenium.isTextPresent("Tags2 Blogs2 Test2 Entry2"));
		assertTrue(selenium.isTextPresent("Tags3 Blogs3 Test3 Entry3"));
		selenium.type("_33_keywords",
			RuntimeVariables.replace("selenium4 liferay4"));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Tags1 Blogs1 Test1 Entry1"));
		assertTrue(selenium.isTextPresent("Tags2 Blogs2 Test2 Entry2"));
		assertFalse(selenium.isTextPresent("Tags3 Blogs3 Test3 Entry3"));
	}
}