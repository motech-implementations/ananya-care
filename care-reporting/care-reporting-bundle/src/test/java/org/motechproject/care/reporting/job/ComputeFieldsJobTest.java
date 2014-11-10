package org.motechproject.care.reporting.job;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.reporting.service.Service;

public class ComputeFieldsJobTest {

    @Mock
    private Service service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testExecute() throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException,
            InvocationTargetException, NoSuchMethodException,
            InstantiationException {
        ComputeFieldsJob job = new ComputeFieldsJob(service);
        job.run();

        verify(service).computeFieldsJob();
    }

}
