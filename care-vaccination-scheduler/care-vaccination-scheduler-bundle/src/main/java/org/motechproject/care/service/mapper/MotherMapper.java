package org.motechproject.care.service.mapper;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.motechproject.care.request.CareCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public class MotherMapper {

    public static MotherCase map(CareCase careCase, Flw flw, FlwGroup flwGroup) {

        String lastPregTT;
        if (careCase.getLast_preg_tt().equalsIgnoreCase("yes")) {
            lastPregTT = "yes";
        } else {
            lastPregTT = "no";
        }
        String isAlive;
        if (careCase.getMother_alive().equalsIgnoreCase("no")) {
            isAlive = "no";
        } else {
            isAlive = "yes";
        }
        return new MotherCase(careCase.getCase_id(),
                get_date_obj(careCase.getDate_modified()), flw,
                careCase.getCase_name(), flwGroup,
                get_date_obj(careCase.getEdd()),
                get_date_obj(careCase.getAdd()),
                get_date_obj(careCase.getTt_1_date()),
                get_date_obj(careCase.getTt_2_date()), lastPregTT,
                get_date_obj(careCase.getAnc_1_date()),
                get_date_obj(careCase.getAnc_2_date()),
                get_date_obj(careCase.getAnc_3_date()),
                get_date_obj(careCase.getAnc_4_date()),
                get_date_obj(careCase.getTt_booster_date()), isAlive);
    }

    private static DateTime get_date_obj(String date_string) {
        return StringUtils.isNotEmpty(date_string) ? DateTime
                .parse(date_string) : null;
    }
}
