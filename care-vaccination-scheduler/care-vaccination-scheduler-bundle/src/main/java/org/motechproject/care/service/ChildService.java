package org.motechproject.care.service;

import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChildService extends BaseService<Child> {


    @Autowired
    public ChildService(@Qualifier("childVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
        super(vaccinationProcessor);
    }
    @Autowired
    MdsRepository dbRepository;
    protected void onProcess(Child child) {
        Child childFromDb = dbRepository.get(Child.class, "caseId", child.getCaseId());

        if(childFromDb == null)
            processNew(child);
        else if(childFromDb.isActive())
            processExisting(childFromDb, child);
    }

    private void processNew(Child child) {
        dbRepository.save(child);
        if(child.shouldEnrollForSchedules()) {
            vaccinationProcessor.enrollUpdateVaccines(child);
        }
    }

    private void processExisting(Child childFromDb, Child child) {
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
            Child child =  dbRepository.get(Child.class,"caseId",caseId);
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
            Child child = dbRepository.get(Child.class,"caseId",caseId);
            if(child == null)
                return false;
            child.setExpired(true);
            dbRepository.update(child);
            return true;
        }
    }
}
