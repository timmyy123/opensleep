package com.google.api.client.json;

import com.google.api.client.json.JsonPolymorphicTypeMap;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import com.google.api.client.util.Types;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonParser implements Closeable {
    private static WeakHashMap<Class<?>, Field> cachedTypemapFields = new WeakHashMap<>();
    private static final Lock lock = new ReentrantLock();

    /* JADX INFO: renamed from: com.google.api.client.json.JsonParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$api$client$json$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$api$client$json$JsonToken = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.END_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.END_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$api$client$json$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static Field getCachedTypemapFieldFor(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        Lock lock2 = lock;
        lock2.lock();
        try {
            if (cachedTypemapFields.containsKey(cls)) {
                Field field2 = cachedTypemapFields.get(cls);
                lock2.unlock();
                return field2;
            }
            Iterator<FieldInfo> it = ClassInfo.of(cls).getFieldInfos().iterator();
            while (it.hasNext()) {
                Field field3 = it.next().getField();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) field3.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    boolean z = true;
                    Preconditions.checkArgument(field == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.checkArgument(Data.isPrimitive(field3.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, field3.getType());
                    JsonPolymorphicTypeMap.TypeDef[] typeDefArrTypeDefinitions = jsonPolymorphicTypeMap.typeDefinitions();
                    HashSet hashSetNewHashSet = Sets.newHashSet();
                    if (typeDefArrTypeDefinitions.length <= 0) {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (JsonPolymorphicTypeMap.TypeDef typeDef : typeDefArrTypeDefinitions) {
                        Preconditions.checkArgument(hashSetNewHashSet.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                    }
                    field = field3;
                }
            }
            cachedTypemapFields.put(cls, field);
            return field;
        } finally {
            lock.unlock();
        }
    }

    private void parse(ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser) {
        if (obj instanceof GenericJson) {
            ((GenericJson) obj).setFactory(getFactory());
        }
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        Class<?> cls = obj.getClass();
        ClassInfo classInfoOf = ClassInfo.of(cls);
        boolean zIsAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (!zIsAssignableFrom && Map.class.isAssignableFrom(cls)) {
            parseMap(null, (Map) obj, Types.getMapValueParameter(cls), arrayList, customizeJsonParser);
            return;
        }
        while (jsonTokenStartParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            FieldInfo fieldInfo = classInfoOf.getFieldInfo(text);
            if (fieldInfo != null) {
                if (fieldInfo.isFinal() && !fieldInfo.isPrimitive()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("final array/object fields are not supported");
                    return;
                }
                Field field = fieldInfo.getField();
                int size = arrayList.size();
                arrayList.add(field.getGenericType());
                Object value = parseValue(field, fieldInfo.getGenericType(), arrayList, obj, customizeJsonParser, true);
                arrayList.remove(size);
                fieldInfo.setValue(obj, value);
            } else if (zIsAssignableFrom) {
                ((GenericData) obj).set(text, parseValue(null, null, arrayList, obj, customizeJsonParser, true));
            } else {
                skipChildren();
            }
            jsonTokenStartParsingObjectOrArray = nextToken();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void parseArray(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) {
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        while (jsonTokenStartParsingObjectOrArray != JsonToken.END_ARRAY) {
            JsonParser jsonParser = this;
            collection.add(jsonParser.parseValue(field, type, arrayList, collection, customizeJsonParser, true));
            jsonTokenStartParsingObjectOrArray = jsonParser.nextToken();
            this = jsonParser;
        }
    }

    private void parseMap(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) {
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        while (jsonTokenStartParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = this.getText();
            this.nextToken();
            JsonParser jsonParser = this;
            map.put(text, jsonParser.parseValue(field, type, arrayList, map, customizeJsonParser, true));
            jsonTokenStartParsingObjectOrArray = jsonParser.nextToken();
            this = jsonParser;
        }
    }

    private final Object parseValue(Field field, Type type, ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser, boolean z) {
        JsonParser jsonParser;
        int i;
        Class<?> cls;
        Class<?> cls2;
        Field field2 = field;
        Type typeResolveWildcardTypeOrTypeVariable = Data.resolveWildcardTypeOrTypeVariable(arrayList, type);
        Type typeRef = null;
        Class<?> rawClass = typeResolveWildcardTypeOrTypeVariable instanceof Class ? (Class) typeResolveWildcardTypeOrTypeVariable : null;
        if (typeResolveWildcardTypeOrTypeVariable instanceof ParameterizedType) {
            rawClass = Types.getRawClass((ParameterizedType) typeResolveWildcardTypeOrTypeVariable);
        }
        if (rawClass == Void.class) {
            skipChildren();
            return null;
        }
        JsonToken currentToken = getCurrentToken();
        try {
            i = AnonymousClass1.$SwitchMap$com$google$api$client$json$JsonToken[currentToken.ordinal()];
            cls = Double.TYPE;
            cls2 = Float.TYPE;
            try {
            } catch (IllegalArgumentException e) {
                e = e;
                jsonParser = this;
            }
        } catch (IllegalArgumentException e2) {
            e = e2;
            jsonParser = this;
        }
        switch (i) {
            case 1:
            case 4:
            case 5:
                Preconditions.checkArgument(!Types.isArray(typeResolveWildcardTypeOrTypeVariable), "expected object or map type but got %s", typeResolveWildcardTypeOrTypeVariable);
                Field cachedTypemapFieldFor = z ? getCachedTypemapFieldFor(rawClass) : null;
                boolean z2 = rawClass != null && Types.isAssignableToOrFrom(rawClass, Map.class);
                Object genericJson = cachedTypemapFieldFor != null ? new GenericJson() : (z2 || rawClass == null) ? Data.newMapInstance(rawClass) : Types.newInstance(rawClass);
                int size = arrayList.size();
                if (typeResolveWildcardTypeOrTypeVariable != null) {
                    arrayList.add(typeResolveWildcardTypeOrTypeVariable);
                }
                if (z2 && !GenericData.class.isAssignableFrom(rawClass)) {
                    Type mapValueParameter = Map.class.isAssignableFrom(rawClass) ? Types.getMapValueParameter(typeResolveWildcardTypeOrTypeVariable) : null;
                    if (mapValueParameter != null) {
                        parseMap(field, (Map) genericJson, mapValueParameter, arrayList, customizeJsonParser);
                        return genericJson;
                    }
                }
                jsonParser = this;
                try {
                    jsonParser.parse(arrayList, genericJson, customizeJsonParser);
                    if (typeResolveWildcardTypeOrTypeVariable != null) {
                        arrayList.remove(size);
                    }
                    if (cachedTypemapFieldFor == null) {
                        return genericJson;
                    }
                    Object obj2 = ((GenericJson) genericJson).get(cachedTypemapFieldFor.getName());
                    Preconditions.checkArgument(obj2 != null, "No value specified for @JsonPolymorphicTypeMap field");
                    String string = obj2.toString();
                    JsonPolymorphicTypeMap.TypeDef[] typeDefArrTypeDefinitions = ((JsonPolymorphicTypeMap) cachedTypemapFieldFor.getAnnotation(JsonPolymorphicTypeMap.class)).typeDefinitions();
                    int length = typeDefArrTypeDefinitions.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            JsonPolymorphicTypeMap.TypeDef typeDef = typeDefArrTypeDefinitions[i2];
                            if (typeDef.key().equals(string)) {
                                typeRef = typeDef.ref();
                            } else {
                                i2++;
                            }
                        }
                    }
                    Type type2 = typeRef;
                    Preconditions.checkArgument(type2 != null, "No TypeDef annotation found with key: " + string);
                    JsonFactory factory = jsonParser.getFactory();
                    JsonParser jsonParserCreateJsonParser = factory.createJsonParser(factory.toString(genericJson));
                    jsonParserCreateJsonParser.startParsing();
                    try {
                        return jsonParserCreateJsonParser.parseValue(field, type2, arrayList, null, null, false);
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        field2 = field;
                    }
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    field2 = field;
                }
                StringBuilder sb = new StringBuilder();
                String currentName = jsonParser.getCurrentName();
                if (currentName != null) {
                    sb.append("key ");
                    sb.append(currentName);
                }
                if (field2 != null) {
                    if (currentName != null) {
                        sb.append(", ");
                    }
                    sb.append("field ");
                    sb.append(field2);
                }
                throw new IllegalArgumentException(sb.toString(), e);
            case 2:
            case 3:
                boolean zIsArray = Types.isArray(typeResolveWildcardTypeOrTypeVariable);
                Preconditions.checkArgument(typeResolveWildcardTypeOrTypeVariable == null || zIsArray || (rawClass != null && Types.isAssignableToOrFrom(rawClass, Collection.class)), "expected collection or array type but got %s", typeResolveWildcardTypeOrTypeVariable);
                Collection<Object> collectionNewCollectionInstance = Data.newCollectionInstance(typeResolveWildcardTypeOrTypeVariable);
                if (zIsArray) {
                    typeRef = Types.getArrayComponentType(typeResolveWildcardTypeOrTypeVariable);
                } else if (rawClass != null && Iterable.class.isAssignableFrom(rawClass)) {
                    typeRef = Types.getIterableParameter(typeResolveWildcardTypeOrTypeVariable);
                }
                Type typeResolveWildcardTypeOrTypeVariable2 = Data.resolveWildcardTypeOrTypeVariable(arrayList, typeRef);
                parseArray(field2, collectionNewCollectionInstance, typeResolveWildcardTypeOrTypeVariable2, arrayList, customizeJsonParser);
                return zIsArray ? Types.toArray(collectionNewCollectionInstance, Types.getRawArrayComponentType(arrayList, typeResolveWildcardTypeOrTypeVariable2)) : collectionNewCollectionInstance;
            case 6:
            case 7:
                Preconditions.checkArgument(typeResolveWildcardTypeOrTypeVariable == null || rawClass == Boolean.TYPE || (rawClass != null && rawClass.isAssignableFrom(Boolean.class)), "expected type Boolean or boolean but got %s", typeResolveWildcardTypeOrTypeVariable);
                return currentToken == JsonToken.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
            case 8:
            case 9:
                Preconditions.checkArgument(field2 == null || field2.getAnnotation(JsonString.class) == null, "number type formatted as a JSON number cannot use @JsonString annotation");
                if (rawClass != null && !rawClass.isAssignableFrom(BigDecimal.class)) {
                    if (rawClass == BigInteger.class) {
                        return getBigIntegerValue();
                    }
                    if (rawClass != Double.class && rawClass != cls) {
                        if (rawClass != Long.class && rawClass != Long.TYPE) {
                            if (rawClass != Float.class && rawClass != cls2) {
                                if (rawClass != Integer.class && rawClass != Integer.TYPE) {
                                    if (rawClass != Short.class && rawClass != Short.TYPE) {
                                        if (rawClass != Byte.class && rawClass != Byte.TYPE) {
                                            throw new IllegalArgumentException("expected numeric type but got " + typeResolveWildcardTypeOrTypeVariable);
                                        }
                                        return Byte.valueOf(getByteValue());
                                    }
                                    return Short.valueOf(getShortValue());
                                }
                                return Integer.valueOf(getIntValue());
                            }
                            return Float.valueOf(getFloatValue());
                        }
                        return Long.valueOf(getLongValue());
                    }
                    return Double.valueOf(getDoubleValue());
                }
                return getDecimalValue();
            case 10:
                String lowerCase = getText().trim().toLowerCase(Locale.US);
                if ((rawClass != cls2 && rawClass != Float.class && rawClass != cls && rawClass != Double.class) || (!lowerCase.equals("nan") && !lowerCase.equals("infinity") && !lowerCase.equals("-infinity"))) {
                    Preconditions.checkArgument((rawClass != null && Number.class.isAssignableFrom(rawClass) && (field2 == null || field2.getAnnotation(JsonString.class) == null)) ? false : true, "number field formatted as a JSON string must use the @JsonString annotation");
                }
                return Data.parsePrimitiveValue(typeResolveWildcardTypeOrTypeVariable, getText());
            case 11:
                Preconditions.checkArgument(rawClass == null || !rawClass.isPrimitive(), "primitive number field but found a JSON null");
                if (rawClass != null && (rawClass.getModifiers() & 1536) != 0) {
                    if (Types.isAssignableToOrFrom(rawClass, Collection.class)) {
                        return Data.nullOf(Data.newCollectionInstance(typeResolveWildcardTypeOrTypeVariable).getClass());
                    }
                    if (Types.isAssignableToOrFrom(rawClass, Map.class)) {
                        return Data.nullOf(Data.newMapInstance(rawClass).getClass());
                    }
                }
                return Data.nullOf(Types.getRawArrayComponentType(arrayList, typeResolveWildcardTypeOrTypeVariable));
            default:
                throw new IllegalArgumentException("unexpected JSON node type: " + currentToken);
        }
    }

    private JsonToken startParsing() {
        JsonToken currentToken = getCurrentToken();
        if (currentToken == null) {
            currentToken = nextToken();
        }
        Preconditions.checkArgument(currentToken != null, "no JSON input found");
        return currentToken;
    }

    private JsonToken startParsingObjectOrArray() {
        JsonToken jsonTokenStartParsing = startParsing();
        int i = AnonymousClass1.$SwitchMap$com$google$api$client$json$JsonToken[jsonTokenStartParsing.ordinal()];
        boolean z = true;
        if (i != 1) {
            return i != 2 ? jsonTokenStartParsing : nextToken();
        }
        JsonToken jsonTokenNextToken = nextToken();
        if (jsonTokenNextToken != JsonToken.FIELD_NAME && jsonTokenNextToken != JsonToken.END_OBJECT) {
            z = false;
        }
        Preconditions.checkArgument(z, jsonTokenNextToken);
        return jsonTokenNextToken;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract BigInteger getBigIntegerValue();

    public abstract byte getByteValue();

    public abstract String getCurrentName();

    public abstract JsonToken getCurrentToken();

    public abstract BigDecimal getDecimalValue();

    public abstract double getDoubleValue();

    public abstract JsonFactory getFactory();

    public abstract float getFloatValue();

    public abstract int getIntValue();

    public abstract long getLongValue();

    public abstract short getShortValue();

    public abstract String getText();

    public abstract JsonToken nextToken();

    public final <T> T parseAndClose(Class<T> cls, CustomizeJsonParser customizeJsonParser) {
        try {
            return (T) parse(cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public abstract JsonParser skipChildren();

    public final String skipToKey(Set<String> set) {
        JsonToken jsonTokenStartParsingObjectOrArray = startParsingObjectOrArray();
        while (jsonTokenStartParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (set.contains(text)) {
                return text;
            }
            skipChildren();
            jsonTokenStartParsingObjectOrArray = nextToken();
        }
        return null;
    }

    public final <T> T parseAndClose(Class<T> cls) {
        return (T) parseAndClose(cls, null);
    }

    public final void skipToKey(String str) {
        skipToKey(Collections.singleton(str));
    }

    public Object parse(Type type, boolean z) {
        return parse(type, z, (CustomizeJsonParser) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object parse(Type type, boolean z, CustomizeJsonParser customizeJsonParser) throws Throwable {
        JsonParser jsonParser;
        Throwable th;
        try {
            if (!Void.class.equals(type)) {
                try {
                    startParsing();
                } catch (Throwable th2) {
                    th = th2;
                    jsonParser = this;
                    if (!z) {
                    }
                }
            }
            jsonParser = this;
            try {
                Object value = jsonParser.parseValue(null, type, new ArrayList<>(), null, customizeJsonParser, true);
                if (z) {
                    jsonParser.close();
                }
                return value;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                if (!z) {
                    jsonParser.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            jsonParser = this;
        }
    }

    public final <T> T parse(Class<T> cls, CustomizeJsonParser customizeJsonParser) {
        return (T) parse((Type) cls, false, customizeJsonParser);
    }
}
