package org.motechproject.care.service;


import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.repository.Repository;

public abstract class BaseService<T extends Client> {
	
    protected final VaccinationProcessor vaccinationProcessor;

    public BaseService(VaccinationProcessor vaccinationProcessor) {
        this.vaccinationProcessor = vaccinationProcessor;
    }

    public void process(T client) {
        String caseId = client.getCaseId();
        synchronized (getLockName(caseId)) {
            onProcess(client);
        }
    }

    protected abstract void onProcess(T client);

    public abstract boolean closeCase(String caseId);

    public abstract boolean expireCase(String caseId);

    public String getLockName(String caseId) {
        return String.format("%s-%s", BaseService.class.getCanonicalName(), caseId).intern();
    }
}
