package org.motechproject.care.reporting.parser;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.reporting.builder.CommcareFormBuilder;
import org.motechproject.care.reporting.builder.FormValueElementBuilder;
import org.motechproject.commcare.domain.CommcareForm;
import org.motechproject.commcare.domain.FormValueElement;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.motechproject.care.reporting.builder.FormValueElementBuilder.getFVE;

public class ChildInfoParserTest {

    @Mock
    InfoParser infoParser;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldPopulateCaseInformation() throws Exception {

        String caseId1 = "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf";
        String caseId2 = "3e8998ce-b19f-4fa7-b1a1-721b6951e3cc";

        String dateModified1 = "2012-07-21T12:02:59.923+05:30";
        String dateModified2 = null;

        FormValueElement childCaseElement1 = new FormValueElementBuilder()
                .addAttribute("case_id", caseId1)
                .addAttribute("date_modified", dateModified1)
                .build();

        FormValueElement childCaseElement2 = new FormValueElementBuilder()
                .addAttribute("case_id",  caseId2)
                .addAttribute("date_modified", dateModified2)
                .build();

        FormValueElement childInfoElement1 = getFVE("case", childCaseElement1);
        FormValueElement childInfoElement2 = getFVE("case", childCaseElement2);

        CommcareForm commcareForm = new CommcareFormBuilder()
                .addSubElement("child_info", childInfoElement1)
                .addSubElement("child_info", childInfoElement2)
                .build();

        when(infoParser.getCaseElement(childInfoElement1)).thenReturn(childCaseElement1);
        when(infoParser.getCaseElement(childInfoElement2)).thenReturn(childCaseElement2);

        List<Map<String, String>> childrenMapList = new ChildInfoParser(infoParser).parse(commcareForm);

        assertEquals(2, childrenMapList.size());

        verify(infoParser).parse(childInfoElement1, true);
        verify(infoParser).parse(childInfoElement1, true);
        verify(infoParser).parse(childCaseElement2, true);
        verify(infoParser).parse(childInfoElement2, true);

        Collections.sort(childrenMapList, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return new CompareToBuilder().append(o1.get("caseId"), o2.get("caseId")).toComparison();
            }
        });

        ReflectionAssert.assertReflectionEquals(getExpectedChild(caseId1, dateModified1), childrenMapList.get(1));
        ReflectionAssert.assertReflectionEquals(getExpectedChild(caseId2, dateModified2), childrenMapList.get(0));
    }

    @Test
    public void shouldIgnoreChildrenIfCaseElementNotFoundWhilePopulatingCaseInformation() throws Exception {

        String caseId1 = "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf";
        String caseId2 = "3e8998ce-b19f-4fa7-b1a1-721b6951e3cc";

        String dateModified1 = "2012-07-21T12:02:59.923+05:30";
        String dateModified2 = null;

        FormValueElement childCaseElement1 = new FormValueElementBuilder()
                .addAttribute("case_id", caseId1)
                .addAttribute("date_modified", dateModified1)
                .build();

        FormValueElement childCaseElement2 = new FormValueElementBuilder()
                .addAttribute("case_id",  caseId2)
                .addAttribute("date_modified", dateModified2)
                .build();

        FormValueElement childInfoElement1 = getFVE("case", childCaseElement1);
        FormValueElement childInfoElement2 = getFVE("case", childCaseElement2);

        CommcareForm commcareForm = new CommcareFormBuilder()
                .addSubElement("child_info", childInfoElement1)
                .addSubElement("child_info", childInfoElement2)
                .build();

        when(infoParser.getCaseElement(childInfoElement2)).thenReturn(childCaseElement2);

        List<Map<String, String>> childrenMapList = new ChildInfoParser(infoParser).parse(commcareForm);

        assertEquals(1, childrenMapList.size());

        verify(infoParser, never()).parse(childInfoElement1, true);
        verify(infoParser, never()).parse(childInfoElement1, true);
        verify(infoParser).parse(childCaseElement2, true);
        verify(infoParser).parse(childInfoElement2, true);

        Collections.sort(childrenMapList, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return new CompareToBuilder().append(o1.get("caseId"), o2.get("caseId")).toComparison();
            }
        });

        ReflectionAssert.assertReflectionEquals(getExpectedChild(caseId2, dateModified2), childrenMapList.get(0));
    }

    private HashMap<String, String> getExpectedChild(final String caseId, final String dateModified) {

        return new HashMap<String, String>() {{
            put("caseId", caseId);
            put("dateModified", dateModified);
        }};
    }

    @Test
    public void shouldChildFormInfoOverwriteChildCaseInfo(){
        FormValueElement childCaseElement = new FormValueElementBuilder()
                .addAttribute("case_id", "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf")
                .addAttribute("date_modified", "2012-07-21T12:02:59.923+05:30")
                .build();

        FormValueElement childInfoElement = getFVE("case", childCaseElement);

        CommcareForm commcareForm = new CommcareFormBuilder()
                .addSubElement("child_info", childInfoElement)
                .build();


        final HashMap<String, String> expected = new HashMap<String, String>() {{
            put("caseId", "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf");
            put("dateModified", "2012-07-21T12:02:59.923+05:30");
            put("age", "22");
        }};

        when(infoParser.parse(childCaseElement, true)).thenReturn(new HashMap<String, String>() {{
            put("age", "21");
        }});

        when(infoParser.parse(childInfoElement, true)).thenReturn(new HashMap<String, String>() {{
            put("age", "22");
        }});
        when(infoParser.getCaseElement(childInfoElement)).thenReturn(childCaseElement);

        List<Map<String, String>> childrenList = new ChildInfoParser(infoParser).parse(commcareForm);

        assertEquals(1, childrenList.size());

        verify(infoParser).parse(childInfoElement, true);
        verify(infoParser).parse(childCaseElement, true);

        ReflectionAssert.assertReflectionEquals(expected, childrenList.get(0));
    }
}

