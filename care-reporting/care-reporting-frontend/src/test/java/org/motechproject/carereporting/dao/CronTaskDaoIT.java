package org.motechproject.carereporting.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.carereporting.domain.CronTaskEntity;
import org.motechproject.carereporting.domain.FrequencyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class CronTaskDaoIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CronTaskDao cronTaskDao;

    @Autowired
    private FrequencyDao frequencyDao;

    private static final String TASK_NAME = "daily";

    @Test
    public void testGetByFrequency() {
        String cronExpression = "0 00 00 * * ?";
        FrequencyEntity frequencyEntity = frequencyDao.getByFrequencyName(TASK_NAME);
        CronTaskEntity cronTaskEntity = cronTaskDao.getByFrequency(frequencyEntity);

        assertNotNull(cronTaskEntity);
        assertEquals(TASK_NAME, cronTaskEntity.getFrequency().getFrequencyName());
        assertEquals(cronExpression, cronTaskEntity.toString());
    }

}
