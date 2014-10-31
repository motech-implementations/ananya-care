package org.motechproject.care.reporting.converter;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JodaTimeConverterTest {

    @InjectMocks
    private JodaTimeConverter jodaTimeConveter = new JodaTimeConverter();

    @Test
    public void shouldConvertToType() {
        DateTime dt = (DateTime) jodaTimeConveter.convert(null, "12-09-1999");
        assertEquals(12, dt.getDayOfMonth());
        assertEquals(9, dt.getMonthOfYear());
        assertEquals(1999, dt.getYear());

    }
}
