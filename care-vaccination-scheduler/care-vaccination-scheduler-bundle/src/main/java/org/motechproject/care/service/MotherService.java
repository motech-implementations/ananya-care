package org.motechproject.care.service;

import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MotherService extends BaseService<MotherCase> {
    
    @Autowired
    MdsRepository dbRepository;
    @Autowired
    public MotherService(@Qualifier("motherVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
        super(vaccinationProcessor);
    }

    protected void onProcess(MotherCase mother) {
        MotherCase motherFromDb = dbRepository.get(MotherCase.class, "caseId",  mother.getCaseId());

        if(motherFromDb == null)
            processNew(mother);
        else
            processExisting(motherFromDb, mother);
    }

    private void processNew(MotherCase mother) {
        dbRepository.save(mother);
        if(mother.isActive())
            vaccinationProcessor.enrollUpdateVaccines(mother);
    }

    private void processExisting(MotherCase motherFromDb, MotherCase mother) {
        motherFromDb.valuesSetFrom(mother);
        dbRepository.update(motherFromDb);

        if(motherFromDb.isActive())
            vaccinationProcessor.enrollUpdateVaccines(motherFromDb);
        else
            vaccinationProcessor.closeSchedules(motherFromDb);
    }

    @Override
    public boolean closeCase(String caseId) {
        synchronized (getLockName(caseId)) {
            MotherCase mother =  dbRepository.get(MotherCase.class,"caseId",caseId);
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
            MotherCase mother = dbRepository.get(MotherCase.class,"caseId",caseId);
            if(mother == null)
                return false;
            mother.setExpired(true);
            dbRepository.update(mother);
            return true;
        }
    }
}