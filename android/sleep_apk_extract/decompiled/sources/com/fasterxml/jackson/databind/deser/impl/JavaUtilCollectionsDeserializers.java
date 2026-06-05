package com.fasterxml.jackson.databind.deser.impl;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JavaUtilCollectionsDeserializers {

    public static class JavaUtilCollectionsConverter implements Converter<Object, Object> {
        private final JavaType _inputType;
        private final int _kind;

        public JavaUtilCollectionsConverter(int i, JavaType javaType) {
            this._inputType = javaType;
            this._kind = i;
        }

        private void _checkSingleton(int i) {
            if (i == 1) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "Can not deserialize Singleton container from ", " entries"));
        }

        @Override // com.fasterxml.jackson.databind.util.Converter
        public Object convert(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this._kind) {
                case 1:
                    Set set = (Set) obj;
                    _checkSingleton(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    _checkSingleton(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    _checkSingleton(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                case 7:
                    return Collections.synchronizedSet((Set) obj);
                case 8:
                    return Collections.synchronizedCollection((Collection) obj);
                case 9:
                    return Collections.synchronizedList((List) obj);
                case 10:
                    return Collections.synchronizedMap((Map) obj);
                default:
                    return obj;
            }
        }

        @Override // com.fasterxml.jackson.databind.util.Converter
        public JavaType getInputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        @Override // com.fasterxml.jackson.databind.util.Converter
        public JavaType getOutputType(TypeFactory typeFactory) {
            return this._inputType;
        }
    }

    private static String _findSingletonTypeName(String str) {
        if (str.startsWith("Singleton")) {
            return str.substring(9);
        }
        return null;
    }

    private static String _findSyncTypeName(String str) {
        if (str.startsWith("Synchronized")) {
            return str.substring(12);
        }
        return null;
    }

    private static String _findUnmodifiableTypeName(String str) {
        if (str.startsWith("Unmodifiable")) {
            return str.substring(12);
        }
        return null;
    }

    private static String _findUtilArrayTypeName(String str) {
        if (str.startsWith("java.util.Arrays$")) {
            return str.substring(17);
        }
        return null;
    }

    private static String _findUtilCollectionsImmutableTypeName(String str) {
        if (str.startsWith("java.util.ImmutableCollections$")) {
            return str.substring(31);
        }
        return null;
    }

    private static String _findUtilCollectionsTypeName(String str) {
        if (str.startsWith("java.util.Collections$")) {
            return str.substring(22);
        }
        return null;
    }

    public static JavaUtilCollectionsConverter converter(int i, JavaType javaType, Class<?> cls) {
        return new JavaUtilCollectionsConverter(i, javaType.findSuperType(cls));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JsonDeserializer<?> findForCollection(DeserializationContext deserializationContext, JavaType javaType) {
        JavaUtilCollectionsConverter javaUtilCollectionsConverterConverter;
        String name = javaType.getRawClass().getName();
        if (!name.startsWith("java.util.")) {
            return null;
        }
        String str_findUtilCollectionsTypeName = _findUtilCollectionsTypeName(name);
        if (str_findUtilCollectionsTypeName == null) {
            String str_findUtilArrayTypeName = _findUtilArrayTypeName(name);
            if (str_findUtilArrayTypeName != null) {
                if (str_findUtilArrayTypeName.contains("List")) {
                    return new StdDelegatingDeserializer(converter(11, javaType, List.class));
                }
                return null;
            }
            String str_findUtilCollectionsImmutableTypeName = _findUtilCollectionsImmutableTypeName(name);
            if (str_findUtilCollectionsImmutableTypeName != null) {
                if (str_findUtilCollectionsImmutableTypeName.contains("List")) {
                    return new StdDelegatingDeserializer(converter(11, javaType, List.class));
                }
                if (str_findUtilCollectionsImmutableTypeName.contains("Set")) {
                    return new StdDelegatingDeserializer(converter(4, javaType, Set.class));
                }
            }
            return null;
        }
        String str_findUnmodifiableTypeName = _findUnmodifiableTypeName(str_findUtilCollectionsTypeName);
        if (str_findUnmodifiableTypeName != null) {
            javaUtilCollectionsConverterConverter = str_findUnmodifiableTypeName.endsWith("Set") ? converter(4, javaType, Set.class) : str_findUnmodifiableTypeName.endsWith("List") ? converter(5, javaType, List.class) : null;
        } else {
            String str_findSingletonTypeName = _findSingletonTypeName(str_findUtilCollectionsTypeName);
            if (str_findSingletonTypeName == null) {
                String str_findSyncTypeName = _findSyncTypeName(str_findUtilCollectionsTypeName);
                if (str_findSyncTypeName != null) {
                    if (str_findSyncTypeName.endsWith("Set")) {
                        javaUtilCollectionsConverterConverter = converter(7, javaType, Set.class);
                    } else if (str_findSyncTypeName.endsWith("List")) {
                        javaUtilCollectionsConverterConverter = converter(9, javaType, List.class);
                    } else if (str_findSyncTypeName.endsWith("Collection")) {
                        javaUtilCollectionsConverterConverter = converter(8, javaType, Collection.class);
                    }
                }
            } else if (str_findSingletonTypeName.endsWith("Set")) {
                javaUtilCollectionsConverterConverter = converter(1, javaType, Set.class);
            } else if (str_findSingletonTypeName.endsWith("List")) {
                javaUtilCollectionsConverterConverter = converter(2, javaType, List.class);
            }
        }
        if (javaUtilCollectionsConverterConverter == null) {
            return null;
        }
        return new StdDelegatingDeserializer(javaUtilCollectionsConverterConverter);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JsonDeserializer<?> findForMap(DeserializationContext deserializationContext, JavaType javaType) {
        JavaUtilCollectionsConverter javaUtilCollectionsConverterConverter;
        String name = javaType.getRawClass().getName();
        String str_findUtilCollectionsTypeName = _findUtilCollectionsTypeName(name);
        if (str_findUtilCollectionsTypeName != null) {
            String str_findUnmodifiableTypeName = _findUnmodifiableTypeName(str_findUtilCollectionsTypeName);
            if (str_findUnmodifiableTypeName != null) {
                javaUtilCollectionsConverterConverter = str_findUnmodifiableTypeName.contains("Map") ? converter(6, javaType, Map.class) : null;
            } else {
                String str_findSingletonTypeName = _findSingletonTypeName(str_findUtilCollectionsTypeName);
                if (str_findSingletonTypeName == null) {
                    String str_findSyncTypeName = _findSyncTypeName(str_findUtilCollectionsTypeName);
                    if (str_findSyncTypeName != null && str_findSyncTypeName.contains("Map")) {
                        javaUtilCollectionsConverterConverter = converter(10, javaType, Map.class);
                    }
                } else if (str_findSingletonTypeName.contains("Map")) {
                    javaUtilCollectionsConverterConverter = converter(3, javaType, Map.class);
                }
            }
        } else {
            String str_findUtilCollectionsImmutableTypeName = _findUtilCollectionsImmutableTypeName(name);
            if (str_findUtilCollectionsImmutableTypeName != null && str_findUtilCollectionsImmutableTypeName.contains("Map")) {
                javaUtilCollectionsConverterConverter = converter(6, javaType, Map.class);
            }
        }
        if (javaUtilCollectionsConverterConverter == null) {
            return null;
        }
        return new StdDelegatingDeserializer(javaUtilCollectionsConverterConverter);
    }
}
