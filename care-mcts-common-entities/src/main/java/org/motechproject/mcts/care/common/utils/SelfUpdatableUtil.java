package org.motechproject.mcts.care.common.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.motechproject.mcts.care.common.domain.SelfUpdatable;

public class SelfUpdatableUtil {

    public static Boolean validateIfUpdatable(String thisId, String otherId,
            Class classArg) {
        if (StringUtils.equals(thisId, otherId))
            return true;
        throw new IllegalArgumentException(
                String.format(
                        "Cannot Update %s, Id does not match. Id for source %s, Id for updated %s",
                        classArg.getName(), thisId, otherId));
    }

    public static void updateFields(SelfUpdatable<?> source,
            List<String> ignoredFields, Class classArg, SelfUpdatable<?> target) {
        for (java.lang.reflect.Field field : classArg.getDeclaredFields()) {
            if (ignoredFields.contains(field.getName())) {
                continue;
            }
            ReflectionUtils.updateValue(field.getName(), source, target);
        }

    }
}
