package org.motechproject.care.reporting.job;

import java.lang.reflect.InvocationTargetException;

public interface Job {
    public void run() throws IllegalArgumentException, IllegalAccessException,
            NoSuchFieldException, SecurityException, InvocationTargetException,
            NoSuchMethodException, InstantiationException;
}
