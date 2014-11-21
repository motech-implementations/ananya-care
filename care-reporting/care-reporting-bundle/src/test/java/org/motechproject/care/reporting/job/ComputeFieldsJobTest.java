package org.motechproject.care.reporting.job;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.reporting.service.ICareService;

public class ComputeFieldsJobTest {

    @Mock
    private ICareService careService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testExecute() throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException,
            InvocationTargetException, NoSuchMethodException,
            InstantiationException {
        ComputeFieldsJob job = new ComputeFieldsJob(careService);
        job.run();

        verify(careService).computeFieldsJob();
    }

}
