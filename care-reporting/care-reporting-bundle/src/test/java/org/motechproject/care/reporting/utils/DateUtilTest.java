package org.motechproject.care.reporting.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void determineDateFormatTest() {
		assertEquals("dd-MM-yyyy", DateUtil.determineDateFormat("12-03-1993"));
		assertEquals("dd-MM-yyyy", DateUtil.determineDateFormat(" 12-03-1993"));
		assertEquals("MM/dd/yyyy", DateUtil.determineDateFormat("09/23/1990"));
	}

}
