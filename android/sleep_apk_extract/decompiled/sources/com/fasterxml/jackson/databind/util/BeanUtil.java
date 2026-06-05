package com.fasterxml.jackson.databind.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BeanUtil {
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String checkUnsupportedType(MapperConfig<?> mapperConfig, JavaType javaType) {
        MapperFeature mapperFeature;
        String str;
        String str2;
        String name = javaType.getRawClass().getName();
        MapperFeature mapperFeature2 = null;
        if (isJava8TimeClass(name)) {
            if (name.indexOf(46, 10) >= 0 || javaType.isTypeOrSubTypeOf(Throwable.class)) {
                return null;
            }
            mapperFeature = MapperFeature.REQUIRE_HANDLERS_FOR_JAVA8_TIMES;
            if (mapperConfig != null && !mapperConfig.isEnabled(mapperFeature)) {
                return null;
            }
            str = "Java 8 date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else {
            if (isJodaTimeClass(name)) {
                str = "Joda date/time";
                str2 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(str, " type ", ClassUtil.getTypeDescription(javaType), " not supported by default: add Module \"", str2);
                sbM66m.append("\" to enable handling");
                String string = sbM66m.toString();
                return mapperFeature2 == null ? FileInsert$$ExternalSyntheticOutline0.m(string, " (or disable `MapperFeature.", mapperFeature2.name(), "`)") : string;
            }
            if (!isJava8OptionalClass(name)) {
                return null;
            }
            mapperFeature = MapperFeature.REQUIRE_HANDLERS_FOR_JAVA8_OPTIONALS;
            if (mapperConfig != null && !mapperConfig.isEnabled(mapperFeature)) {
                return null;
            }
            str = "Java 8 optional";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8";
        }
        mapperFeature2 = mapperFeature;
        StringBuilder sbM66m2 = Fragment$$ExternalSyntheticOutline1.m66m(str, " type ", ClassUtil.getTypeDescription(javaType), " not supported by default: add Module \"", str2);
        sbM66m2.append("\" to enable handling");
        String string2 = sbM66m2.toString();
        if (mapperFeature2 == null) {
        }
    }

    public static Object getDefaultValue(JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        Class<?> clsPrimitiveType = ClassUtil.primitiveType(rawClass);
        if (clsPrimitiveType != null) {
            return ClassUtil.defaultValue(clsPrimitiveType);
        }
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return JsonInclude.Include.NON_EMPTY;
        }
        if (rawClass == String.class) {
            return "";
        }
        if (javaType.isTypeOrSubTypeOf(Date.class)) {
            return new Date(0L);
        }
        if (!javaType.isTypeOrSubTypeOf(Calendar.class)) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0L);
        return gregorianCalendar;
    }

    private static boolean isJava8OptionalClass(String str) {
        return str.startsWith("java.util.Optional");
    }

    private static boolean isJava8TimeClass(String str) {
        return str.startsWith("java.time.");
    }

    private static boolean isJodaTimeClass(String str) {
        return str.startsWith("org.joda.time.");
    }
}
