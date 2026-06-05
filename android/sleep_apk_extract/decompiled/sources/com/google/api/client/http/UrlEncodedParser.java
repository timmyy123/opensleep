package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UrlEncodedParser implements ObjectParser {
    public static final String MEDIA_TYPE = new HttpMediaType(OAuth.FORM_ENCODED).setCharsetParameter(StandardCharsets.UTF_8).build();

    public static void parse(Reader reader, Object obj, boolean z) throws IOException {
        int i;
        Class<?> cls = obj.getClass();
        ClassInfo classInfoOf = ClassInfo.of(cls);
        List listAsList = Arrays.asList(cls);
        GenericData genericData = GenericData.class.isAssignableFrom(cls) ? (GenericData) obj : null;
        Map map = Map.class.isAssignableFrom(cls) ? (Map) obj : null;
        ArrayValueMap arrayValueMap = new ArrayValueMap(obj);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        do {
            boolean z2 = true;
            while (true) {
                i = reader.read();
                if (i == -1 || i == 38) {
                    break;
                }
                if (i != 61) {
                    if (z2) {
                        stringWriter.write(i);
                    } else {
                        stringWriter2.write(i);
                    }
                } else if (z2) {
                    z2 = false;
                } else {
                    stringWriter2.write(i);
                }
            }
            String strDecodeUri = z ? CharEscapers.decodeUri(stringWriter.toString()) : stringWriter.toString();
            if (strDecodeUri.length() != 0) {
                String strDecodeUri2 = z ? CharEscapers.decodeUri(stringWriter2.toString()) : stringWriter2.toString();
                FieldInfo fieldInfo = classInfoOf.getFieldInfo(strDecodeUri);
                if (fieldInfo != null) {
                    Type typeResolveWildcardTypeOrTypeVariable = Data.resolveWildcardTypeOrTypeVariable(listAsList, fieldInfo.getGenericType());
                    if (Types.isArray(typeResolveWildcardTypeOrTypeVariable)) {
                        Class<?> rawArrayComponentType = Types.getRawArrayComponentType(listAsList, Types.getArrayComponentType(typeResolveWildcardTypeOrTypeVariable));
                        arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, parseValue(rawArrayComponentType, listAsList, strDecodeUri2));
                    } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(listAsList, typeResolveWildcardTypeOrTypeVariable), Iterable.class)) {
                        Collection<Object> collectionNewCollectionInstance = (Collection) fieldInfo.getValue(obj);
                        if (collectionNewCollectionInstance == null) {
                            collectionNewCollectionInstance = Data.newCollectionInstance(typeResolveWildcardTypeOrTypeVariable);
                            fieldInfo.setValue(obj, collectionNewCollectionInstance);
                        }
                        collectionNewCollectionInstance.add(parseValue(typeResolveWildcardTypeOrTypeVariable == Object.class ? null : Types.getIterableParameter(typeResolveWildcardTypeOrTypeVariable), listAsList, strDecodeUri2));
                    } else {
                        fieldInfo.setValue(obj, parseValue(typeResolveWildcardTypeOrTypeVariable, listAsList, strDecodeUri2));
                    }
                } else if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(strDecodeUri);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        if (genericData != null) {
                            genericData.set(strDecodeUri, arrayList);
                        } else {
                            map.put(strDecodeUri, arrayList);
                        }
                    }
                    arrayList.add(strDecodeUri2);
                }
            }
            stringWriter = new StringWriter();
            stringWriter2 = new StringWriter();
        } while (i != -1);
        arrayValueMap.setValues();
    }

    private static Object parseValue(Type type, List<Type> list, String str) {
        return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(list, type), str);
    }

    public static void parse(String str, Object obj, boolean z) {
        if (str == null) {
            return;
        }
        try {
            parse(new StringReader(str), obj, z);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    public static void parse(String str, Object obj) {
        parse(str, obj, true);
    }
}
