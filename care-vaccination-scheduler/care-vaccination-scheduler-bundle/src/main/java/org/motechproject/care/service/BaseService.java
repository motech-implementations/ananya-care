package org.motechproject.care.service;


import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T> {
	
    protected final VaccinationProcessor vaccinationProcessor;
    
    @Autowired
    MdsRepository dbRepository;
    
    public BaseService(VaccinationProcessor vaccinationProcessor) {
        this.vaccinationProcessor = vaccinationProcessor;
    }

    public void process(T client) {
        Client clients = (Client) client; 
        String caseId = clients.getCaseId();
        synchronized (getLockName(caseId)) {
            onProcess(client);
        }
    }
    
    public Flw getFlw(String flwId) {
       return dbRepository.get(Flw.class, "flwId", flwId);
    }
    public FlwGroup getFlwGroup(String groupId) {
        return dbRepository.get(FlwGroup.class, "groupId", groupId);
    }
    
    

    protected abstract void onProcess(T client);

    public abstract boolean closeCase(String caseId);

    public abstract boolean expireCase(String caseId);

    public String getLockName(String caseId) {
        return String.format("%s-%s", BaseService.class.getCanonicalName(), caseId).intern();
    }
}
