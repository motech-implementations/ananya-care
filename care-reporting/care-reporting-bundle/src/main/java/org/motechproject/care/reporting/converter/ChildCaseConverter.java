package org.motechproject.care.reporting.converter;


import static java.lang.String.format;

import org.apache.commons.beanutils.converters.AbstractConverter;
import org.motechproject.care.reporting.service.Service;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
public class ChildCaseConverter extends AbstractConverter {
    private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");
    private Service careService;

    @Autowired
    public ChildCaseConverter(Service careService) {
        super(null);
        this.careService = careService;
    }


    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        if (!value.getClass().equals(String.class)) {
            logger.warn(format("Cannot convert Child Case with value passed as %s of type %s", value, value.getClass()));
            return null;
        }

        return careService.getOrCreateChildCase((String) value);
    }

    @Override
    protected Class getDefaultType() {
        return ChildCase.class;
    }
}
