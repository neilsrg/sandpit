package au.com.prince.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;


import java.text.SimpleDateFormat;

public class JsonDataFormatUtils {
    public static final String DATETIME_FMTSTR_YYYY_MM_DD = "YYYY-MM-dd";

    public static ObjectMapper createObjectMapperJodaYYYY_MM_DD() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.setDateFormat(new SimpleDateFormat(DATETIME_FMTSTR_YYYY_MM_DD));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
