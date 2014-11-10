package org.motechproject.care.reporting.listener;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.reporting.job.ComputeFieldsJob;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ComputeFieldsEventListenerTest {

    @Mock
    private ComputeFieldsJob computeFieldsJob;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldInvokeComputeFieldsJob() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        ComputeFieldsEventListener eventListener = new ComputeFieldsEventListener(
                computeFieldsJob);

        eventListener.handleComputeFieldsEvent(null);

        verify(computeFieldsJob).run();
    }
}
