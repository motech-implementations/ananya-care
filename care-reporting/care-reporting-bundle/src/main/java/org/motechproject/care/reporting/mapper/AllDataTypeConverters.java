package org.motechproject.care.reporting.mapper;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.joda.time.DateTime;
import org.motechproject.care.reporting.converter.ChildCaseConverter;
import org.motechproject.care.reporting.converter.FlwConverter;
import org.motechproject.care.reporting.converter.FlwGroupConverter;
import org.motechproject.care.reporting.converter.JodaTimeConverter;
import org.motechproject.care.reporting.converter.MotherCaseConverter;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.care.reporting.utils.CareDateConverter;
import org.motechproject.care.reporting.utils.CareTypeConverter;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public class AllDataTypeConverters {

    public void registerBaseConverters(ConvertUtilsBean convertUtilsBean,
            String[] allowedDateFormats) {
        convertUtilsBean.register(new CareDateConverter(allowedDateFormats),
                Date.class);
        convertUtilsBean.register(new JodaTimeConverter(), DateTime.class);
        registerPrimitive(convertUtilsBean, Integer.class);
        registerPrimitive(convertUtilsBean, Short.class);
        registerPrimitive(convertUtilsBean, Boolean.class);
        registerPrimitive(convertUtilsBean, BigDecimal.class);
    }

    private void registerPrimitive(ConvertUtilsBean convertUtilsBean,
            Class typeToConvert) {
        convertUtilsBean.register(new CareTypeConverter(typeToConvert),
                typeToConvert);
    }

    public void registerDomainConverters(ConvertUtilsBean convertUtils,
            ICareService careService) {
        convertUtils.register(new FlwConverter(careService), Flw.class);
        convertUtils.register(new FlwGroupConverter(careService),
                FlwGroup.class);
        convertUtils.register(new MotherCaseConverter(careService),
                MotherCase.class);
        convertUtils.register(new ChildCaseConverter(careService),
                ChildCase.class);

    }
}
