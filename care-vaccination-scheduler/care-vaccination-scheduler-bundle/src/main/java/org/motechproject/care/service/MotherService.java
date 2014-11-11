package org.motechproject.care.service;

import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MotherService extends BaseService<Mother> {
    
    @Autowired
    MdsRepository dbRepository;
    @Autowired
    public MotherService(@Qualifier("motherVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
        super(vaccinationProcessor);
    }

    protected void onProcess(Mother mother) {
        Mother motherFromDb = dbRepository.get(Mother.class, "caseId",  mother.getCaseId());

        if(motherFromDb == null)
            processNew(mother);
        else
            processExisting(motherFromDb, mother);
    }

    private void processNew(Mother mother) {
        dbRepository.save(mother);
        if(mother.isActive())
            vaccinationProcessor.enrollUpdateVaccines(mother);
    }

    private void processExisting(Mother motherFromDb, Mother mother) {
        motherFromDb.setValuesFrom(mother);
        dbRepository.update(motherFromDb);

        if(motherFromDb.isActive())
            vaccinationProcessor.enrollUpdateVaccines(motherFromDb);
        else
            vaccinationProcessor.closeSchedules(motherFromDb);
    }

    @Override
    public boolean closeCase(String caseId) {
        synchronized (getLockName(caseId)) {
            Mother mother =  dbRepository.get(Mother.class,"caseId",caseId);
            if(mother == null)
                return false;

            mother.setClosedByCommcare(true);
            dbRepository.update(mother);
            vaccinationProcessor.closeSchedules(mother);
            return true;
        }
    }

    @Override
    public boolean expireCase(String caseId) {
        synchronized (getLockName(caseId)) {
            Mother mother = dbRepository.get(Mother.class,"caseId",caseId);
            if(mother == null)
                return false;
            mother.setExpired(true);
            dbRepository.update(mother);
            return true;
        }
    }
}