package com.fasterxml.jackson.databind.introspect;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.util.ClassUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumNamingStrategyFactory {
    public static EnumNamingStrategy createEnumNamingStrategyInstance(Object obj, boolean z, EnumNamingStrategy enumNamingStrategy) {
        if (obj == null) {
            return enumNamingStrategy;
        }
        if (!(obj instanceof Class)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("AnnotationIntrospector returned EnumNamingStrategy definition of type ", ClassUtil.classNameOf(obj), "; expected type `Class<EnumNamingStrategy>` instead"));
            return null;
        }
        Class cls = (Class) obj;
        if (cls != EnumNamingStrategy.class) {
            if (!EnumNamingStrategy.class.isAssignableFrom(cls)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Problem with AnnotationIntrospector returned Class ", ClassUtil.classNameOf(cls), "; expected `Class<EnumNamingStrategy>`"));
                return null;
            }
            if (ClassUtil.createInstance(cls, z) != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
        }
        return null;
    }
}
