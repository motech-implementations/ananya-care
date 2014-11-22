package org.motechproject.care.service;

import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChildService extends BaseService<ChildCase> {


    @Autowired
    public ChildService(@Qualifier("childVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
        super(vaccinationProcessor);
    }
    @Autowired
    MdsRepository dbRepository;
    protected void onProcess(ChildCase child) {
        ChildCase childFromDb = dbRepository.get(ChildCase.class, "caseId", child.getCaseId());

        if(childFromDb == null)
            processNew(child);
        else if(childFromDb.isActive())
            processExisting(childFromDb, child);
    }

    private void processNew(ChildCase child) {
        dbRepository.save(child);
        if(child.shouldEnrollForSchedules()) {
            vaccinationProcessor.enrollUpdateVaccines(child);
        }
    }

    private void processExisting(ChildCase childFromDb, ChildCase child) {
        childFromDb.setValuesFrom(child);
        dbRepository.update(childFromDb);

        if(childFromDb.isActive()) {
            vaccinationProcessor.enrollUpdateVaccines(childFromDb);
        }
        else {
            vaccinationProcessor.closeSchedules(childFromDb);
        }
    }

    @Override
    public boolean closeCase(String caseId) {
        synchronized (getLockName(caseId)) {
            ChildCase child =  dbRepository.get(ChildCase.class,"caseId",caseId);
            if(child == null)
                return false;

            child.setClosedByCommcare(true);
            dbRepository.update(child);
            vaccinationProcessor.closeSchedules(child);
            return true;
        }
    
    }

    @Override
    public boolean expireCase(String caseId) {
        synchronized (getLockName(caseId)) {
            ChildCase child = dbRepository.get(ChildCase.class,"caseId",caseId);
            if(child == null)
                return false;
            child.setExpired(true);
            dbRepository.update(child);
            return true;
        }
    }

    public MotherCase getMother(String mother_id) {
        return dbRepository.get(MotherCase.class, "caseId", mother_id);
    }
}
