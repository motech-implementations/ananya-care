package org.motechproject.care.reporting.mapper;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.joda.time.DateTime;
import org.motechproject.care.reporting.converter.JodaTimeConverter;

public class Mapper {
    protected BeanUtilsBean beanUtils = new BeanUtilsBean();
    protected AllDataTypeConverters allDataTypeConverters;

    public Mapper(String[] allowedDateFormats) {
        allDataTypeConverters = new AllDataTypeConverters();
        allDataTypeConverters.registerBaseConverters(beanUtils.getConvertUtils(), allowedDateFormats);
    }

    public <T, U> T map(Class<T> type, Map<String, U> keyStore) {
        T newInstance;
        try {
            newInstance = type.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return map(newInstance, keyStore);
    }

    public <T, U> T map(T typeInstance, Map<String, U> keyStore) {
        for (Map.Entry<String, U> field : keyStore.entrySet()) {
            String key = field.getKey();
            U value = field.getValue();

            set(typeInstance, key, value);
        }

        return typeInstance;
    }

    public <T> T map(String from, Class<T> to) {
    	if (to == DateTime.class) {
    		beanUtils.getConvertUtils().register(new JodaTimeConverter(), DateTime.class);
    	}
        return (T) beanUtils.getConvertUtils().convert(from, to);
    }

    private void set(Object object, String fieldName, Object fieldValue) {
        try {
            beanUtils.setProperty(object, fieldName, fieldValue);
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Exception when setting %s to %s", fieldValue, fieldName), ex);
        }
    }
}
