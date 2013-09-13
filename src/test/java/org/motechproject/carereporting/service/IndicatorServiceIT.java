package org.motechproject.carereporting.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.carereporting.domain.FrequencyEntity;
import org.motechproject.carereporting.domain.IndicatorClassificationEntity;
import org.motechproject.carereporting.domain.IndicatorEntity;
import org.motechproject.carereporting.domain.IndicatorValueEntity;
import org.motechproject.carereporting.domain.ReportEntity;
import org.motechproject.carereporting.domain.dto.IndicatorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class IndicatorServiceIT extends AbstractTransactionalJUnit4SpringContextTests {

    private static final int EXPECTED_INDICATORS_COUNT = 1;
    private static final int CLASSIFICATION_ID = 1;
    private static final int EXPECTED_CLASSIFICATION_INDICATORS_COUNT = 1;
    private static final int USER_ID = 1;
    private static final int INDICATOR_ID = 1;
    private static final int PARENT_AREA_ID = 1;
    private static final Date START_DATE = new Date();
    private static final Date END_DATE = new Date();
    private static final String NEW_INDICATOR_NAME = "new name";
    private static final Integer FREQUENCY_ID = 1;

    @Autowired
    private IndicatorService indicatorService;

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    @Before
    public void setupAuthentication() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] permissions = {"CAN_CREATE_INDICATORS", "CAN_EDIT_INDICATORS", "CAN_REMOVE_INDICATORS",
            "CAN_CREATE_CLASSIFICATIONS", "CAN_EDIT_CLASSIFICATIONS", "CAN_REMOVE_CLASSIFICATIONS"};
        for (String permission: permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userService.getUserById(USER_ID), null, authorities));
    }

    @Test
    public void testGetAllIndicators() {
        assertEquals(EXPECTED_INDICATORS_COUNT, indicatorService.getAllIndicators().size());
    }

    @Test
    public void testGetIndicatorsByClassificationId() {
        assertEquals(EXPECTED_CLASSIFICATION_INDICATORS_COUNT, indicatorService.getIndicatorsByClassificationId(CLASSIFICATION_ID).size());
    }

    @Test
    public void testGetIndicatorById() {
        assertNotNull(indicatorService.getIndicatorById(INDICATOR_ID));
    }

    @Test
    @Ignore
    public void testCreateNewIndicator() {
        int indicatorsCount = indicatorService.getAllIndicators().size();
        createIndicator();
        assertEquals(indicatorsCount + 1, indicatorService.getAllIndicators().size());
    }

    private void createIndicator() {
        IndicatorDto indicatorDto = new IndicatorDto("name", new HashSet<Integer>(), 1, new HashSet<Integer>(), 1,
                new HashSet<ReportEntity>(), new BigDecimal(30), 1, null, false, false);
        indicatorService.createNewIndicator(indicatorService.createIndicatorEntityFromDto(indicatorDto));
    }

    @Test
    public void testGetIndicatorTrendForChildAreas() {
        assertNotNull(indicatorService.getIndicatorTrendForChildAreas(INDICATOR_ID, PARENT_AREA_ID, FREQUENCY_ID, START_DATE, END_DATE));
    }

    @Test
    public void testUpdateIndicator() {
        IndicatorEntity indicator = indicatorService.getIndicatorById(INDICATOR_ID);
        indicator.setName(NEW_INDICATOR_NAME);
        indicatorService.updateIndicator(indicator);
        indicator = indicatorService.getIndicatorById(INDICATOR_ID);
        assertEquals(NEW_INDICATOR_NAME, indicator.getName());
    }

    @Test
    public void testGetAllIndicatorClassifications() {
        assertNotNull(indicatorService.getAllIndicatorClassifications());
    }

    @Test
    public void testCreateNewIndicatorClassification() {
        int indicatorClassificationsCount = indicatorService.getAllIndicatorClassifications().size();
        createIndicatorClassification();
        assertEquals(indicatorClassificationsCount + 1, indicatorService.getAllIndicatorClassifications().size());
    }

    private void createIndicatorClassification() {
        IndicatorClassificationEntity indicatorClassification = new IndicatorClassificationEntity("name");
        indicatorService.createNewIndicatorClassification(indicatorClassification);
    }

    @Test
    public void testUpdateIndicatorClassification() {
        String newName = "new name";
        IndicatorClassificationEntity indicatorClassification = indicatorService.getAllIndicatorClassifications().iterator().next();
        indicatorClassification.setName(newName);
        indicatorService.updateIndicatorClassification(indicatorClassification);
        indicatorClassification = indicatorService.getIndicatorClassificationById(indicatorClassification.getId());
        assertEquals(newName, indicatorClassification.getName());
    }

    @Test
    public void testDeleteIndicatorClassification() {
        int indicatorClassificationsCount = indicatorService.getAllIndicatorClassifications().size();
        indicatorService.deleteIndicatorClassification(indicatorService.getIndicatorClassificationById(CLASSIFICATION_ID));
        assertEquals(indicatorClassificationsCount - 1, indicatorService.getAllIndicatorClassifications().size());
    }

    @Test
    public void testGetAllIndicatorValues() {
        assertNotNull(indicatorService.getAllIndicatorValues());
    }

    @Test
    public void testCreateNewIndicatorValue() {
        Integer id = 1;
        IndicatorEntity indicator = indicatorService.getIndicatorById(INDICATOR_ID);
        FrequencyEntity frequencyEntity = new FrequencyEntity();
        frequencyEntity.setId(id);
        IndicatorValueEntity indicatorValueEntity = new IndicatorValueEntity(indicator,
                areaService.getAreaById(1), BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, frequencyEntity, new Date());
        indicatorService.createNewIndicatorValue(indicatorValueEntity);
        assertNotNull(indicatorService.getAllIndicatorValues().iterator().next());
    }

    @Test
    public void testUpdateIndicatorValue() {
        Integer id = 1;
        IndicatorEntity indicator = indicatorService.getIndicatorById(INDICATOR_ID);
        FrequencyEntity frequencyEntity = new FrequencyEntity();
        frequencyEntity.setId(id);
        IndicatorValueEntity indicatorValueEntity = new IndicatorValueEntity(indicator,
                areaService.getAreaById(1), BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, frequencyEntity, new Date());
        indicatorService.createNewIndicatorValue(indicatorValueEntity);
        indicatorValueEntity.setValue(BigDecimal.TEN);
        indicatorService.updateIndicatorValue(indicatorValueEntity);
        indicatorValueEntity = indicatorService.getAllIndicatorValues().iterator().next();
        assertEquals(BigDecimal.TEN, indicatorValueEntity.getValue());
    }

    @Test
    public void testGetIndicatorsWithTrendsUnderUser() {
        assertNotNull(indicatorService.getIndicatorsWithTrendsUnderUser(userService.getCurrentlyLoggedUser(), new Date(), new Date(), 1, 5));
    }

    @Test
    public void testSetComputingForIndicator() {
        indicatorService.setComputedForIndicator(indicatorService.getIndicatorById(INDICATOR_ID), true);
        IndicatorEntity indicatorEntity = indicatorService.getIndicatorById(INDICATOR_ID);
        assertEquals(Boolean.TRUE, indicatorEntity.getComputed());
    }

}
