package org.motechproject.mcts.care.common.mds.service;

import org.motechproject.mds.service.MotechDataService;

public interface MdsServiceFactory {

    MotechDataService<?> fetchServiceInterface(Class<?> clazz);

    MotechDataService<?> fetchDefaultServiceInterface();

}
