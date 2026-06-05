package com.google.gson;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes4.dex */
public final class GsonBuilder {
    static final GsonBuilder DEFAULT;
    static final ConstructorConstructor DEFAULT_CONSTRUCTOR_CONSTRUCTOR;
    static final JsonAdapterAnnotationTypeAdapterFactory DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY;
    private static final Strictness DEFAULT_STRICTNESS = null;
    static final List<TypeAdapterFactory> DEFAULT_TYPE_ADAPTER_FACTORIES;
    private static final FormattingStyle DEFAULT_FORMATTING_STYLE = FormattingStyle.COMPACT;
    private static final String DEFAULT_DATE_PATTERN = null;
    private static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    private static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    private static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    Excluder excluder = Excluder.DEFAULT;
    LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    FieldNamingStrategy fieldNamingPolicy = DEFAULT_FIELD_NAMING_STRATEGY;
    final Map<Type, Object> instanceCreators = new HashMap();
    final List<TypeAdapterFactory> factories = new ArrayList();
    final List<TypeAdapterFactory> hierarchyFactories = new ArrayList();
    boolean serializeNulls = false;
    String datePattern = DEFAULT_DATE_PATTERN;
    int dateStyle = 2;
    int timeStyle = 2;
    boolean complexMapKeySerialization = false;
    boolean serializeSpecialFloatingPointValues = false;
    boolean escapeHtmlChars = true;
    FormattingStyle formattingStyle = DEFAULT_FORMATTING_STYLE;
    boolean generateNonExecutableJson = false;
    Strictness strictness = DEFAULT_STRICTNESS;
    boolean useJdkUnsafe = true;
    ToNumberStrategy objectToNumberStrategy = DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
    ToNumberStrategy numberToNumberStrategy = DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
    final ArrayDeque<Object> reflectionFilters = new ArrayDeque<>();

    static {
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(Collections.EMPTY_MAP, true, Collections.EMPTY_LIST);
        DEFAULT_CONSTRUCTOR_CONSTRUCTOR = constructorConstructor;
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY = jsonAdapterAnnotationTypeAdapterFactory;
        GsonBuilder gsonBuilder = new GsonBuilder();
        DEFAULT = gsonBuilder;
        DEFAULT_TYPE_ADAPTER_FACTORIES = gsonBuilder.createFactories(constructorConstructor, jsonAdapterAnnotationTypeAdapterFactory);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c A[PHI: r1
      0x002c: PHI (r1v3 com.google.gson.TypeAdapterFactory) = (r1v2 com.google.gson.TypeAdapterFactory), (r1v8 com.google.gson.TypeAdapterFactory) binds: [B:15:0x003f, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addDateTypeAdapters(List<TypeAdapterFactory> list) {
        TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory;
        TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory2;
        boolean z = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        String str = this.datePattern;
        TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory3 = null;
        if (str == null || str.trim().isEmpty()) {
            int i = this.dateStyle;
            if (i == 2 && this.timeStyle == 2) {
                return;
            }
            typeAdapterFactoryCreateAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(i, this.timeStyle);
            if (z) {
                typeAdapterFactoryCreateAdapterFactory3 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(this.dateStyle, this.timeStyle);
                typeAdapterFactoryCreateAdapterFactory2 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(this.dateStyle, this.timeStyle);
            } else {
                typeAdapterFactoryCreateAdapterFactory2 = null;
            }
        } else {
            typeAdapterFactoryCreateAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(this.datePattern);
            if (z) {
                typeAdapterFactoryCreateAdapterFactory3 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(this.datePattern);
                typeAdapterFactoryCreateAdapterFactory2 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(this.datePattern);
            }
        }
        list.add(typeAdapterFactoryCreateAdapterFactory);
        if (z) {
            list.add(typeAdapterFactoryCreateAdapterFactory3);
            list.add(typeAdapterFactoryCreateAdapterFactory2);
        }
    }

    private void addUserDefinedAdapters(List<TypeAdapterFactory> list) {
        if (!this.factories.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.factories);
            Collections.reverse(arrayList);
            list.addAll(arrayList);
        }
        if (this.hierarchyFactories.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(arrayList2);
        list.addAll(arrayList2);
    }

    private TypeAdapter<Number> doubleAdapter() {
        return this.serializeSpecialFloatingPointValues ? TypeAdapters.DOUBLE : TypeAdapters.DOUBLE_STRICT;
    }

    private TypeAdapter<Number> floatAdapter() {
        return this.serializeSpecialFloatingPointValues ? TypeAdapters.FLOAT : TypeAdapters.FLOAT_STRICT;
    }

    private static boolean hasNonOverridableAdapter(Type type) {
        return type == Object.class;
    }

    public static <E> List<E> newImmutableList(Collection<E> collection) {
        if (collection.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        if (collection.size() == 1) {
            return Collections.singletonList(collection instanceof List ? ((List) collection).get(0) : collection.iterator().next());
        }
        return Collections.unmodifiableList(Arrays.asList(collection.toArray()));
    }

    public Gson create() {
        return new Gson(this);
    }

    public List<TypeAdapterFactory> createFactories(ConstructorConstructor constructorConstructor, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.getFactory(this.objectToNumberStrategy));
        arrayList.add(this.excluder);
        addUserDefinedAdapters(arrayList);
        addDateTypeAdapters(arrayList);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> typeAdapter = this.longSerializationPolicy.typeAdapter();
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, typeAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter()));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter()));
        arrayList.add(NumberTypeAdapter.getFactory(this.numberToNumberStrategy));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, TypeAdapters.atomicLongAdapter(typeAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, TypeAdapters.atomicLongArrayAdapter(typeAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.BIG_DECIMAL_FACTORY);
        arrayList.add(TypeAdapters.BIG_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.LAZILY_PARSED_NUMBER_FACTORY);
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DefaultDateTypeAdapter.DEFAULT_STYLE_FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        TypeAdapterFactory typeAdapterFactoryJavaTimeTypeAdapterFactory = TypeAdapters.javaTimeTypeAdapterFactory();
        if (typeAdapterFactoryJavaTimeTypeAdapterFactory != null) {
            arrayList.add(typeAdapterFactoryJavaTimeTypeAdapterFactory);
        }
        arrayList.addAll(SqlTypesSupport.SQL_TYPE_FACTORIES);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, this.complexMapKeySerialization));
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, this.fieldNamingPolicy, this.excluder, jsonAdapterAnnotationTypeAdapterFactory, newImmutableList(this.reflectionFilters)));
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(obj);
        boolean z = obj instanceof JsonSerializer;
        if (!z && !(obj instanceof JsonDeserializer) && !(obj instanceof TypeAdapter)) {
            Gson$$ExternalSyntheticBUOutline0.m("Class ", obj.getClass().getName(), " does not implement any supported type adapter class or interface");
            return null;
        }
        if (hasNonOverridableAdapter(type)) {
            Gson$$ExternalSyntheticBUOutline0.m("Cannot override built-in adapter for ", type);
            return null;
        }
        if (z || (obj instanceof JsonDeserializer)) {
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        if (str != null) {
            try {
                new SimpleDateFormat(str);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(FileInsert$$ExternalSyntheticOutline0.m("The date pattern '", str, "' is not valid"), e);
            }
        }
        this.datePattern = str;
        return this;
    }
}
