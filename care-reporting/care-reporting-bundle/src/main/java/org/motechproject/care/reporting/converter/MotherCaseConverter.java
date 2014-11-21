package org.motechproject.care.reporting.converter;

import org.apache.commons.beanutils.converters.AbstractConverter;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotherCaseConverter extends AbstractConverter {
    private ICareService careService;

    @Autowired
    public MotherCaseConverter(ICareService careService) {
        super(null);
        this.careService = careService;
    }

    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        return careService.getOrCreateMotherCase((String) value);
    }

    @Override
    protected Class getDefaultType() {
        return MotherCase.class;
    }
}
