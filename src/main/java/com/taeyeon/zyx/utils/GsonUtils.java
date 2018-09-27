package com.taeyeon.zyx.utils;

import com.google.gson.*;
import com.taeyeon.zyx.dto.DtoProperty;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author zyx
 * @date 2018/9/27 027 12:12
 */
public class GsonUtils {
    public GsonUtils() {
    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        GsonBuilder builder = (new GsonBuilder()).registerTypeAdapter(Date.class, new GsonUtils.UtilDateSerializer()).registerTypeAdapter(Date.class, new DateDeserializerUtils()).registerTypeAdapter(Calendar.class, new GsonUtils.UtilCalendarSerializer()).registerTypeAdapter(GregorianCalendar.class, new GsonUtils.UtilCalendarSerializer()).setDateFormat(1).setPrettyPrinting();
        return StringUtils.isNotBlank(json) ? builder.create().fromJson(json, tClass) : null;
    }

    public static <T> T fromJson(String json, Type type) {
        GsonBuilder builder = (new GsonBuilder()).registerTypeAdapter(Date.class, new GsonUtils.UtilDateSerializer()).registerTypeAdapter(Date.class, new DateDeserializerUtils()).registerTypeAdapter(Calendar.class, new GsonUtils.UtilCalendarSerializer()).registerTypeAdapter(GregorianCalendar.class, new GsonUtils.UtilCalendarSerializer()).setDateFormat(1).setPrettyPrinting();
        return StringUtils.isNotBlank(json) ? builder.create().fromJson(json, type) : null;
    }

    public static <T> T fromDateFormateJson(String json, Class<T> tClass) {
        GsonBuilder builder = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss");
        return StringUtils.isNotBlank(json) ? builder.create().fromJson(json, tClass) : null;
    }

    public static <T> T fromDateFormateJson(String json, Type type) {
        GsonBuilder builder = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss");
        return StringUtils.isNotBlank(json) ? builder.create().fromJson(json, type) : null;
    }

    public static String toJson(Object obj) {
        GsonBuilder builder = (new GsonBuilder()).registerTypeAdapter(Date.class, new DateSerializerUtils()).registerTypeAdapter(Date.class, new DateDeserializerUtils()).setDateFormat(1);
        return obj == null ? "" : builder.create().toJson(obj);
    }

    public static String toJsonWithFiledDesc(Object obj) {
        GsonBuilder builder = (new GsonBuilder()).registerTypeAdapter(Date.class, new DateSerializerUtils()).registerTypeAdapter(Date.class, new DateDeserializerUtils()).setDateFormat(1).setFieldNamingStrategy(new GsonUtils.EduFieldNamingStrategy());
        return obj == null ? "" : builder.create().toJson(obj);
    }

    public static String toDateFormatJson(Object obj) {
        GsonBuilder builder = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss");
        return obj == null ? "" : builder.create().toJson(obj);
    }

    private static class EduFieldNamingStrategy implements FieldNamingStrategy {
        private EduFieldNamingStrategy() {
        }

        public String translateName(Field field) {
            DtoProperty dtoProperty = (DtoProperty)field.getAnnotation(DtoProperty.class);
            if (null == dtoProperty) {
                return field.getName();
            } else if (dtoProperty.hidden()) {
                return field.getName();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(field.getName()).append("(").append(dtoProperty.value()).append(")");
                return stringBuilder.toString();
            }
        }
    }

    private static class UtilCalendarSerializer implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {
        private UtilCalendarSerializer() {
        }

        public JsonElement serialize(Calendar cal, Type type, JsonSerializationContext context) {
            return new JsonPrimitive(cal.getTimeInMillis());
        }

        public Calendar deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(element.getAsJsonPrimitive().getAsLong());
            return cal;
        }
    }

    private static class UtilDateSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private UtilDateSerializer() {
        }

        public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
            return new JsonPrimitive(date.getTime());
        }

        public Date deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
            return new Date(element.getAsJsonPrimitive().getAsLong());
        }
    }
}
