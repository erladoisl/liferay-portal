/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.kernel.io.unsync;

import com.liferay.portal.kernel.test.TestCase;

/**
 * <a href="UnsyncStringWriterTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Shuyang Zhou
 */
public class UnsyncStringWriterTest extends TestCase {

	public void testAppendChar() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.append('a');

		assertEquals(1, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));

		unsyncStringWriter.append('b');

		assertEquals(2, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.append('a');

		assertEquals(1, unsyncStringWriter.stringBundler.index());
		assertEquals("a", unsyncStringWriter.stringBundler.stringAt(0));

		unsyncStringWriter.append('b');

		assertEquals(2, unsyncStringWriter.stringBundler.index());
		assertEquals("a", unsyncStringWriter.stringBundler.stringAt(0));
		assertEquals("b", unsyncStringWriter.stringBundler.stringAt(1));
	}

	public void testAppendCharSequence() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.append(new StringBuilder("ab"));

		assertEquals(2, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));

		unsyncStringWriter.append(new StringBuilder("cd"));

		assertEquals(4, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));
		assertEquals('c', unsyncStringWriter.stringBuilder.charAt(2));
		assertEquals('d', unsyncStringWriter.stringBuilder.charAt(3));

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.append(new StringBuilder("ab"));

		assertEquals(1, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.stringBundler.stringAt(0));

		unsyncStringWriter.append(new StringBuilder("cd"));

		assertEquals(2, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.stringBundler.stringAt(0));
		assertEquals("cd", unsyncStringWriter.stringBundler.stringAt(1));
	}

	public void testConstructor() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertEquals(16, unsyncStringWriter.stringBuilder.capacity());
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter = new UnsyncStringWriter(false, 32);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertEquals(32, unsyncStringWriter.stringBuilder.capacity());
		assertNull(unsyncStringWriter.stringBundler);

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);
		assertEquals(16, unsyncStringWriter.stringBundler.capacity());

		unsyncStringWriter = new UnsyncStringWriter(true, 32);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);
		assertEquals(32, unsyncStringWriter.stringBundler.capacity());
	}

	public void testReset() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		unsyncStringWriter.write("test1");

		assertEquals(5, unsyncStringWriter.stringBuilder.length());

		unsyncStringWriter.reset();

		assertEquals(0, unsyncStringWriter.stringBuilder.length());

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		unsyncStringWriter.write("test1");

		assertEquals(1, unsyncStringWriter.stringBundler.index());

		unsyncStringWriter.reset();

		assertEquals(0, unsyncStringWriter.stringBundler.index());
	}

	public void testToString() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.append('a');

		assertEquals(1, unsyncStringWriter.stringBuilder.length());
		assertEquals("a", unsyncStringWriter.toString());

		unsyncStringWriter.append('b');

		assertEquals(2, unsyncStringWriter.stringBuilder.length());
		assertEquals("ab", unsyncStringWriter.toString());

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.append('a');

		assertEquals(1, unsyncStringWriter.stringBundler.index());
		assertEquals("a", unsyncStringWriter.toString());

		unsyncStringWriter.append('b');

		assertEquals(2, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.toString());
	}

	public void testWriteChar() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.write('a');

		assertEquals(1, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));

		unsyncStringWriter.write('b');

		assertEquals(2, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.write('a');

		assertEquals(1, unsyncStringWriter.stringBundler.index());
		assertEquals("a", unsyncStringWriter.stringBundler.stringAt(0));

		unsyncStringWriter.write('b');

		assertEquals(2, unsyncStringWriter.stringBundler.index());
		assertEquals("a", unsyncStringWriter.stringBundler.stringAt(0));
		assertEquals("b", unsyncStringWriter.stringBundler.stringAt(1));
	}

	public void testWriteCharArray() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.write("ab".toCharArray());

		assertEquals(2, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));

		unsyncStringWriter.write("cd".toCharArray());

		assertEquals(4, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));
		assertEquals('c', unsyncStringWriter.stringBuilder.charAt(2));
		assertEquals('d', unsyncStringWriter.stringBuilder.charAt(3));

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.write("ab".toCharArray());

		assertEquals(1, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.stringBundler.stringAt(0));

		unsyncStringWriter.write("cd".toCharArray());

		assertEquals(2, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.stringBundler.stringAt(0));
		assertEquals("cd", unsyncStringWriter.stringBundler.stringAt(1));
	}

	public void testWriteString() {

		// StringBuilder

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(false);

		assertNotNull(unsyncStringWriter.stringBuilder);
		assertNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.write("ab");

		assertEquals(2, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));

		unsyncStringWriter.write("cd");

		assertEquals(4, unsyncStringWriter.stringBuilder.length());
		assertEquals('a', unsyncStringWriter.stringBuilder.charAt(0));
		assertEquals('b', unsyncStringWriter.stringBuilder.charAt(1));
		assertEquals('c', unsyncStringWriter.stringBuilder.charAt(2));
		assertEquals('d', unsyncStringWriter.stringBuilder.charAt(3));

		// StringBundler

		unsyncStringWriter = new UnsyncStringWriter(true);

		assertNull(unsyncStringWriter.stringBuilder);
		assertNotNull(unsyncStringWriter.stringBundler);

		unsyncStringWriter.write("ab");

		assertEquals(1, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.stringBundler.stringAt(0));

		unsyncStringWriter.write("cd");

		assertEquals(2, unsyncStringWriter.stringBundler.index());
		assertEquals("ab", unsyncStringWriter.stringBundler.stringAt(0));
		assertEquals("cd", unsyncStringWriter.stringBundler.stringAt(1));
	}

}