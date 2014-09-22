package org.motechproject.care.reporting.converter;

import static java.lang.String.format;

import org.apache.commons.beanutils.converters.AbstractConverter;
import org.motechproject.care.reporting.service.Service;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
public class FlwGroupConverter extends AbstractConverter {
    private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");

    private Service careService;

    @Autowired
    public FlwGroupConverter(Service careService) {
        super(null);
        this.careService = careService;
    }

    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        if(value == null) return null;

        if (!value.getClass().equals(String.class)) {
            logger.warn(format("Cannot convert FLW with value passed as %s of type %s", value, value.getClass()));
            return null;
        }
        return careService.getOrCreateGroup((String) value);
    }

    @Override
    protected Class getDefaultType() {
        return FlwGroup.class;
    }
}
