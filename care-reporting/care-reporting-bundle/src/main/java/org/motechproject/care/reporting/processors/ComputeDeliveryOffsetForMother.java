package org.motechproject.care.reporting.processors;

import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputeDeliveryOffsetForMother implements ComputedFieldsProcessor{

    private ICareService careService;
    private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");


    public ComputeDeliveryOffsetForMother(ICareService careService) {
        this.careService = careService;
    }

    @Override
    public void compute(Map<String, String> values) {

        final String motherKey = "caseId";
        final String serverModifiedKey = "serverDateModified";

        if(values == null) {
            logger.warn("map is empty when computing Delivery Offset for mother.");
            return;
        }

        final String serverModifiedValue = (!values.containsKey(serverModifiedKey)) ? null : values.get(serverModifiedKey);

        if(serverModifiedValue == null){
            logger.warn("serverModified is null when computing Delivery Offset for mother.");
            return;
        }

        final String motherId = (!values.containsKey(motherKey)) ? null : values.get(motherKey);

        if(motherId == null){
            logger.warn("motherId is null when computing Delivery Offset for mother.");
            return;
        }

        final MotherCase motherCase = careService.getMotherCase(motherId);

        if(motherCase == null){
            logger.info("Mother Case does not exist when computing Delivery Offset for mother.");
            return;
        }

        final DateTime deliveryDate = motherCase.getActualDeliveryDate() == null ? motherCase.getEdd() : motherCase.getActualDeliveryDate();

        if(deliveryDate == null) {
            logger.info("Mother Case Edd and Add are null when computing Delivery Offset for mother.");
            return;
        }

        DateTime serverModified = DateTime.parse(serverModifiedValue);
        final int days = Days.daysBetween(new DateTime(deliveryDate).toDateMidnight(), new DateTime(serverModified).toDateMidnight()).getDays();

        values.put("deliveryOffsetDays", String.valueOf(days));
    }
}
