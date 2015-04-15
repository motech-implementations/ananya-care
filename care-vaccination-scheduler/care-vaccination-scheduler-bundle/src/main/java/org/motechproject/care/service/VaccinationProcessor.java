package org.motechproject.care.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.motechproject.care.service.schedule.VaccinationService;
import org.motechproject.care.service.util.ClientLoggerUtil;
import org.motechproject.mcts.care.common.mds.domain.Client;

public class VaccinationProcessor {

	private static final Logger LOGGER = Logger.getLogger(VaccinationProcessor.class);
	
    protected List<VaccinationService> vaccinationServices;

    public VaccinationProcessor(List<VaccinationService> vaccinationServices) {
        this.vaccinationServices = vaccinationServices;
    }
    
    /**
     * Bug Fix : Following code handles if any vaccination schedular fails 
     * and allows to proceed with other vaccination schedular
     * @author atish
     * @since 4/12/2015
     * @param client
     */
    public void enrollUpdateVaccines(Client client){
        for(VaccinationService vaccineService : vaccinationServices)
        	try {
        		  LOGGER.info("Processing vaccination :"+ vaccineService.getClass().getName());
        			vaccineService.process(client);
        		  LOGGER.info("Processed vaccination :"+ vaccineService.getClass().getName());	
        	}catch (Exception exception) {
        		log(exception, vaccineService, client);
			}
    }

    public List<VaccinationService> getVaccinationServices() {
        return vaccinationServices;
    }

    /**
     * Bug Fix : Following code handles if any vaccination schedular fails 
     * and allows to proceed with other vaccination schedular
     * @author atish
     * @since 4/12/2015
     * @param client
     */
    public void closeSchedules(Client client) {
        for(VaccinationService vaccineService : vaccinationServices)
        	try {
        		vaccineService.close(client);
			} catch (Exception exception) {
				log(exception,vaccineService, client);
			}
            
    }
    
    /**
     * Bug Fix : Following code handles if any vaccination schedular fails 
     * and allows to proceed with other vaccination schedular
     * @author atish
     * @since 5/12/2015
     * @param exception
     * @param service
     * @param client
     */
    private void log(Exception exception,VaccinationService service,Client client) {
    	
    	LOGGER.error(String.format("Failed to schedule vaccination %s  while processing/closing Client %s , due to Error %s",service.getClass().getName(),ClientLoggerUtil.clientBuilder(client).toString(),ClientLoggerUtil.ExceptionBuilder(exception).toString()));
    }
    
    
    
}
