package org.motechproject.care.reporting.mapper;

import static org.junit.Assert.assertEquals;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;

// @Transactional
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class CareReportingMapperIT extends BasePaxIT {

    @Inject
    private ICareService careService;
    /*
     * @Rule public ExpectedException expectedException =
     * ExpectedException.none();
     */

    private CareReportingMapper careReportingMapper;

    @Before
    public void setUp() {
        careReportingMapper = CareReportingMapper.getInstance(careService);
    }

    @Test
    public void testMapsFromKeyValueToFormObject() throws Exception {

        HashMap<String, String> newFormValues = new HashMap<String, String>() {
            {
                put("instanceId", "1234");
                put("ageCalc", "1");
                put("dateModified", "2012-07-21T12:02:59.923+05:30");
            }
        };
        NewForm newForm = careReportingMapper.map(NewForm.class, newFormValues);

        assertEquals("1234", newForm.getInstanceId());
        assertEquals((short) 1, (short) newForm.getAgeCalc());
        assertEquals(new DateTime(2012, 7, 21, 12, 2, 59, 923, DateTimeZone
                .forOffsetHoursMinutes(5, 30)).toDate(), newForm
                .getDateModified());
    }

    @Test
    public void shouldThrowExceptionIfUnableToConvertInteger() {
        validateMapping("anInteger", "10.1");
    }

    @Test
    public void shouldThrowExceptionIfUnableToConvertBoolean() {
        validateMapping("aBoolean", "10");
    }

    @Test
    public void shouldThrowExceptionIfUnableToConvertShort() {
        validateMapping("aShort", "3457889");
    }

    @Test
    public void shouldThrowExceptionIfUnableToConvertBigDecimal() {
        validateMapping("aBigDecimal", "invalidDecimal");
    }

    @Test
    public void shouldThrowExceptionIfDateFormatIsInvalid() {
        validateMapping("date", "01/15/2012");
    }

    private void validateMapping(String fieldName, String value) {
        /*
         * expectedException.expect(RuntimeException.class);
         * expectedException.expectMessage
         * (String.format("Exception when setting %s to %s", value, fieldName));
         */

        careReportingMapper.map(TestForm.class, asMap(fieldName, value));
    }

    @Test
    public void shouldAutoConvertSupportedObject() throws Exception {
        Flw flw = new Flw();
        flw.setFlwId("89fda0284e008d2e0c980fb13f96c45a");
        // template.save(flw);

        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("89fda0284e008d2e0c980fb13f96c45a");
        // template.save(flwGroup);

        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("94d5374f-290e-409f-bc57-86c2e4bcc43f");
        // template.save(motherCase);

        ChildCase childCase = new ChildCase();
        childCase.setCaseId("94d5374f-290e-409f-bc57-86c2e4bcc43f");
        // template.save(childCase);

        ConverterDemoObject target = careReportingMapper.map(
                ConverterDemoObject.class, values());

        assertReflectionEqualsWithIgnore(flw, target.flw);
        assertReflectionEqualsWithIgnore(flwGroup, target.flwGroup);
        assertReflectionEqualsWithIgnore(motherCase, target.motherCase);
        assertReflectionEqualsWithIgnore(childCase, target.childCase);
    }

    private HashMap<String, Object> asMap(final String key, final Object value) {
        return new HashMap<String, Object>() {
            {
                put(key, value);
            }
        };
    }

    private Map<String, Object> values() {
        return new HashMap<String, Object>() {
            {
                put("flw", "89fda0284e008d2e0c980fb13f96c45a");
                put("flwGroup", "89fda0284e008d2e0c980fb13f96c45a");
                put("motherCase", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
                put("childCase", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
            }
        };
    }

    @Test
    public void shouldConvertKnownDateFormats() {
        DateTimeZone dateTimeZone = DateTimeZone.forTimeZone(TimeZone
                .getTimeZone("IST"));

        validateIfDateFormatIsAccepted("2012-07-21T12:02:59.923+06:30",
                new DateTime(2012, 7, 21, 11, 2, 59, 923, dateTimeZone)
                        .toDate());
        validateIfDateFormatIsAccepted("2012-07-21T12:02:59.923+0630",
                new DateTime(2012, 7, 21, 11, 2, 59, 923, dateTimeZone)
                        .toDate());
        validateIfDateFormatIsAccepted("2012-07-21T12:02:59.923+05",
                new DateTime(2012, 7, 21, 12, 32, 59, 923, dateTimeZone)
                        .toDate());
        validateIfDateFormatIsAccepted("2012-07-21T12:02:59.923Z",
                new DateTime(2012, 7, 21, 17, 32, 59, 923, dateTimeZone)
                        .toDate());

        validateIfDateFormatIsAccepted("2012-07-21T12:02:59+06:30",
                new DateTime(2012, 7, 21, 11, 2, 59, dateTimeZone).toDate());
        validateIfDateFormatIsAccepted("2012-07-21T12:02:59+0630",
                new DateTime(2012, 7, 21, 11, 2, 59, dateTimeZone).toDate());
        validateIfDateFormatIsAccepted("2012-07-21T12:02:59+05", new DateTime(
                2012, 7, 21, 12, 32, 59, dateTimeZone).toDate());
        validateIfDateFormatIsAccepted("2012-07-21T12:02:59Z", new DateTime(
                2012, 7, 21, 17, 32, 59, dateTimeZone).toDate());

        validateIfDateFormatIsAccepted("2012-07-21T12:02:59", new DateTime(
                2012, 7, 21, 12, 2, 59).toDate());

        validateIfDateFormatIsAccepted("2012-11-29", new DateTime(2012, 11, 29,
                0, 0, 0).toDate());
        validateIfDateFormatIsAccepted("2012-01-02", new DateTime(2012, 1, 2,
                0, 0, 0).toDate());
    }

    private void validateIfDateFormatIsAccepted(final String input,
            Date expected) {
        TestForm actualDate = careReportingMapper.map(TestForm.class,
                new HashMap<String, String>() {
                    {
                        put("date", input);
                    }
                });

        assertEquals(expected, actualDate.getDate());
    }

    public static class TestForm {
        private Date date;
        private Boolean aBoolean;
        private Short aShort;
        private BigDecimal aBigDecimal;
        private Integer anInteger;

        public void setaBoolean(Boolean aBoolean) {
            this.aBoolean = aBoolean;
        }

        public void setaShort(Short aShort) {
            this.aShort = aShort;
        }

        public void setaBigDecimal(BigDecimal aBigDecimal) {
            this.aBigDecimal = aBigDecimal;
        }

        public void setAnInteger(Integer anInteger) {
            this.anInteger = anInteger;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return date;
        }
    }

}
