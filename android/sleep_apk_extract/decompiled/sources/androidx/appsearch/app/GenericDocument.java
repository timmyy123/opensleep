package androidx.appsearch.app;

import android.util.Log;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.safeparcel.GenericDocumentParcel;
import androidx.appsearch.safeparcel.PropertyParcel;
import androidx.appsearch.util.IndentingStringBuilder;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class GenericDocument {
    public static final GenericDocument EMPTY = new Builder("", "", "").build();
    private final GenericDocumentParcel mDocumentParcel;

    public GenericDocument(GenericDocumentParcel genericDocumentParcel) {
        Objects.requireNonNull(genericDocumentParcel);
        this.mDocumentParcel = genericDocumentParcel;
    }

    private void appendPropertyString(String str, Object obj, IndentingStringBuilder indentingStringBuilder) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(indentingStringBuilder);
        indentingStringBuilder.append("\"").append(str).append("\": [");
        int i = 0;
        if (obj instanceof GenericDocument[]) {
            GenericDocument[] genericDocumentArr = (GenericDocument[]) obj;
            while (i < genericDocumentArr.length) {
                indentingStringBuilder.append("\n");
                indentingStringBuilder.increaseIndentLevel();
                genericDocumentArr[i].appendGenericDocumentString(indentingStringBuilder);
                if (i != genericDocumentArr.length - 1) {
                    indentingStringBuilder.append(",");
                }
                indentingStringBuilder.append("\n");
                indentingStringBuilder.decreaseIndentLevel();
                i++;
            }
        } else {
            int length = Array.getLength(obj);
            while (i < length) {
                Object obj2 = Array.get(obj, i);
                if (obj2 instanceof String) {
                    indentingStringBuilder.append("\"").append((String) obj2).append("\"");
                } else if (obj2 instanceof byte[]) {
                    indentingStringBuilder.append(Arrays.toString((byte[]) obj2));
                } else if (obj2 != null) {
                    indentingStringBuilder.append(obj2.toString());
                }
                if (i != length - 1) {
                    indentingStringBuilder.append(", ");
                }
                i++;
            }
        }
        indentingStringBuilder.append("]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> Class<? extends T> findTargetClassToDeserialize(Class<T> cls, Map<String, List<String>> map, Map<String, List<String>> map2) {
        if (map.isEmpty()) {
            return cls;
        }
        Class<? extends T> assignableClassBySchemaName = AppSearchDocumentClassMap.getAssignableClassBySchemaName(map, getSchemaType(), cls);
        if (assignableClassBySchemaName != null) {
            return assignableClassBySchemaName;
        }
        List<String> parentTypes = map2.containsKey(getSchemaType()) ? map2.get(getSchemaType()) : getParentTypes();
        if (parentTypes != null) {
            for (int i = 0; i < parentTypes.size(); i++) {
                Class<? extends T> assignableClassBySchemaName2 = AppSearchDocumentClassMap.getAssignableClassBySchemaName(map, parentTypes.get(i), cls);
                if (assignableClassBySchemaName2 != null) {
                    return assignableClassBySchemaName2;
                }
            }
        }
        Log.w("AppSearchGenericDocumen", "Cannot find any compatible target class to deserialize. Perhaps the annotation processor was not run or the generated document class map was proguarded out?\nTry to deserialize to " + cls.getCanonicalName() + " directly.");
        return cls;
    }

    private static Object flattenAccumulator(List<Object> list) {
        if (list.isEmpty()) {
            return null;
        }
        Object obj = list.get(0);
        if (obj instanceof String[]) {
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                length += ((String[]) list.get(i)).length;
            }
            String[] strArr = new String[length];
            int length2 = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                String[] strArr2 = (String[]) list.get(i2);
                System.arraycopy(strArr2, 0, strArr, length2, strArr2.length);
                length2 += strArr2.length;
            }
            return strArr;
        }
        if (obj instanceof long[]) {
            int length3 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                length3 += ((long[]) list.get(i3)).length;
            }
            long[] jArr = new long[length3];
            int length4 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long[] jArr2 = (long[]) list.get(i4);
                System.arraycopy(jArr2, 0, jArr, length4, jArr2.length);
                length4 += jArr2.length;
            }
            return jArr;
        }
        if (obj instanceof double[]) {
            int length5 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                length5 += ((double[]) list.get(i5)).length;
            }
            double[] dArr = new double[length5];
            int length6 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                double[] dArr2 = (double[]) list.get(i6);
                System.arraycopy(dArr2, 0, dArr, length6, dArr2.length);
                length6 += dArr2.length;
            }
            return dArr;
        }
        if (obj instanceof boolean[]) {
            int length7 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                length7 += ((boolean[]) list.get(i7)).length;
            }
            boolean[] zArr = new boolean[length7];
            int length8 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                boolean[] zArr2 = (boolean[]) list.get(i8);
                System.arraycopy(zArr2, 0, zArr, length8, zArr2.length);
                length8 += zArr2.length;
            }
            return zArr;
        }
        if (obj instanceof byte[][]) {
            int length9 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                length9 += ((byte[][]) list.get(i9)).length;
            }
            byte[][] bArr = new byte[length9][];
            int length10 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                byte[][] bArr2 = (byte[][]) list.get(i10);
                System.arraycopy(bArr2, 0, bArr, length10, bArr2.length);
                length10 += bArr2.length;
            }
            return bArr;
        }
        if (!(obj instanceof GenericDocumentParcel[])) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m("Unexpected property type: ", obj));
            return null;
        }
        int length11 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            length11 += ((GenericDocumentParcel[]) list.get(i11)).length;
        }
        GenericDocumentParcel[] genericDocumentParcelArr = new GenericDocumentParcel[length11];
        int length12 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            GenericDocumentParcel[] genericDocumentParcelArr2 = (GenericDocumentParcel[]) list.get(i12);
            System.arraycopy(genericDocumentParcelArr2, 0, genericDocumentParcelArr, length12, genericDocumentParcelArr2.length);
            length12 += genericDocumentParcelArr2.length;
        }
        return genericDocumentParcelArr;
    }

    public static GenericDocument fromDocumentClass(Object obj) {
        Preconditions.checkNotNull(obj);
        return DocumentClassFactoryRegistry.getInstance().getOrCreateFactory(obj).toGenericDocument(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object getRawPropertyFromRawDocument(PropertyPath propertyPath, int i, Map<String, PropertyParcel> map) {
        Object objCopyOfRange;
        Objects.requireNonNull(propertyPath);
        Objects.requireNonNull(map);
        while (i < propertyPath.size()) {
            PropertyPath.PathSegment pathSegment = propertyPath.get(i);
            Object obj = map.get(pathSegment.getPropertyName());
            if (obj == null) {
                return null;
            }
            int propertyIndex = pathSegment.getPropertyIndex();
            if (propertyIndex != -1) {
                PropertyParcel propertyParcel = (PropertyParcel) obj;
                if (propertyParcel.getStringValues() != null) {
                    String[] stringValues = propertyParcel.getStringValues();
                    objCopyOfRange = (stringValues == null || propertyIndex >= stringValues.length) ? null : Arrays.copyOfRange(stringValues, propertyIndex, propertyIndex + 1);
                    obj = objCopyOfRange;
                } else if (propertyParcel.getLongValues() != null) {
                    long[] longValues = propertyParcel.getLongValues();
                    if (longValues != null && propertyIndex < longValues.length) {
                        objCopyOfRange = Arrays.copyOfRange(longValues, propertyIndex, propertyIndex + 1);
                    }
                    obj = objCopyOfRange;
                } else if (propertyParcel.getDoubleValues() != null) {
                    double[] doubleValues = propertyParcel.getDoubleValues();
                    if (doubleValues != null && propertyIndex < doubleValues.length) {
                        objCopyOfRange = Arrays.copyOfRange(doubleValues, propertyIndex, propertyIndex + 1);
                    }
                    obj = objCopyOfRange;
                } else if (propertyParcel.getBooleanValues() != null) {
                    boolean[] booleanValues = propertyParcel.getBooleanValues();
                    if (booleanValues != null && propertyIndex < booleanValues.length) {
                        objCopyOfRange = Arrays.copyOfRange(booleanValues, propertyIndex, propertyIndex + 1);
                    }
                    obj = objCopyOfRange;
                } else if (propertyParcel.getBytesValues() != null) {
                    byte[][] bytesValues = propertyParcel.getBytesValues();
                    if (bytesValues != null && propertyIndex < bytesValues.length) {
                        objCopyOfRange = Arrays.copyOfRange(bytesValues, propertyIndex, propertyIndex + 1);
                    }
                    obj = objCopyOfRange;
                } else if (propertyParcel.getDocumentValues() != null) {
                    Object[] documentValues = propertyParcel.getDocumentValues();
                    if (documentValues != null && propertyIndex < documentValues.length) {
                        objCopyOfRange = documentValues[propertyIndex];
                    }
                    obj = objCopyOfRange;
                } else if (propertyParcel.getEmbeddingValues() != null) {
                    EmbeddingVector[] embeddingValues = propertyParcel.getEmbeddingValues();
                    if (embeddingValues != null && propertyIndex < embeddingValues.length) {
                        objCopyOfRange = Arrays.copyOfRange(embeddingValues, propertyIndex, propertyIndex + 1);
                    }
                    obj = objCopyOfRange;
                } else {
                    if (propertyParcel.getBlobHandleValues() == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m("Unsupported value type: ", obj));
                        return null;
                    }
                    AppSearchBlobHandle[] blobHandleValues = propertyParcel.getBlobHandleValues();
                    if (blobHandleValues != null && propertyIndex < blobHandleValues.length) {
                        objCopyOfRange = Arrays.copyOfRange(blobHandleValues, propertyIndex, propertyIndex + 1);
                    }
                    obj = objCopyOfRange;
                }
            }
            if (obj == null || i == propertyPath.size() - 1) {
                return (obj == null || !(obj instanceof PropertyParcel)) ? obj : ((PropertyParcel) obj).getValues();
            }
            if (!(obj instanceof GenericDocumentParcel)) {
                if (obj instanceof PropertyParcel) {
                    PropertyParcel propertyParcel2 = (PropertyParcel) obj;
                    if (propertyParcel2.getDocumentValues() != null) {
                        GenericDocumentParcel[] documentValues2 = propertyParcel2.getDocumentValues();
                        if (documentValues2 != null && documentValues2.length == 1) {
                            map = documentValues2[0].getPropertyMap();
                        } else if (documentValues2 != null) {
                            ArrayList arrayList = new ArrayList(documentValues2.length);
                            for (GenericDocumentParcel genericDocumentParcel : documentValues2) {
                                Object rawPropertyFromRawDocument = getRawPropertyFromRawDocument(propertyPath, i + 1, genericDocumentParcel.getPropertyMap());
                                if (rawPropertyFromRawDocument != null) {
                                    arrayList.add(rawPropertyFromRawDocument);
                                }
                            }
                            return flattenAccumulator(arrayList);
                        }
                    }
                }
                Log.e("AppSearchGenericDocumen", "Failed to apply path to document; no nested value found: " + propertyPath);
                return null;
            }
            map = ((GenericDocumentParcel) obj).getPropertyMap();
            i++;
        }
        return null;
    }

    private static <T> T safeCastProperty(String str, Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AppSearchGenericDocumen", "Error casting to requested type for path \"" + str + "\"", e);
            return null;
        }
    }

    private static void warnIfSinglePropertyTooLong(String str, String str2, int i) {
        if (i > 1) {
            Log.w("AppSearchGenericDocumen", Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m(i, "The value for \"", str2, "\" contains ", " elements. Only the first one will be returned from getProperty"), str, "(). Try getProperty", str, "Array()."));
        }
    }

    public void appendGenericDocumentString(IndentingStringBuilder indentingStringBuilder) {
        Preconditions.checkNotNull(indentingStringBuilder);
        indentingStringBuilder.append("{\n");
        indentingStringBuilder.increaseIndentLevel();
        indentingStringBuilder.append("namespace: \"").append(getNamespace()).append("\",\n");
        indentingStringBuilder.append("id: \"").append(getId()).append("\",\n");
        indentingStringBuilder.append("score: ").append(Integer.valueOf(getScore())).append(",\n");
        indentingStringBuilder.append("schemaType: \"").append(getSchemaType()).append("\",\n");
        List<String> parentTypes = getParentTypes();
        if (parentTypes != null) {
            indentingStringBuilder.append("parentTypes: ").append(parentTypes).append("\n");
        }
        indentingStringBuilder.append("creationTimestampMillis: ").append(Long.valueOf(getCreationTimestampMillis())).append(",\n");
        indentingStringBuilder.append("timeToLiveMillis: ").append(Long.valueOf(getTtlMillis())).append(",\n");
        indentingStringBuilder.append("properties: {\n");
        String[] strArr = (String[]) getPropertyNames().toArray(new String[0]);
        Arrays.sort(strArr);
        for (int i = 0; i < strArr.length; i++) {
            Object objCheckNotNull = Preconditions.checkNotNull(getProperty(strArr[i]));
            indentingStringBuilder.increaseIndentLevel();
            appendPropertyString(strArr[i], objCheckNotNull, indentingStringBuilder);
            if (i != strArr.length - 1) {
                indentingStringBuilder.append(",\n");
            }
            indentingStringBuilder.decreaseIndentLevel();
        }
        indentingStringBuilder.append("\n");
        indentingStringBuilder.append("}");
        indentingStringBuilder.decreaseIndentLevel();
        indentingStringBuilder.append("\n");
        indentingStringBuilder.append("}");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericDocument) {
            return this.mDocumentParcel.equals(((GenericDocument) obj).mDocumentParcel);
        }
        return false;
    }

    public long getCreationTimestampMillis() {
        return this.mDocumentParcel.getCreationTimestampMillis();
    }

    public GenericDocumentParcel getDocumentParcel() {
        return this.mDocumentParcel;
    }

    public String getId() {
        return this.mDocumentParcel.getId();
    }

    public String getNamespace() {
        return this.mDocumentParcel.getNamespace();
    }

    @Deprecated
    public List<String> getParentTypes() {
        List<String> parentTypes = this.mDocumentParcel.getParentTypes();
        if (parentTypes == null) {
            return null;
        }
        return Collections.unmodifiableList(parentTypes);
    }

    public Object getProperty(String str) {
        Objects.requireNonNull(str);
        Object rawPropertyFromRawDocument = getRawPropertyFromRawDocument(new PropertyPath(str), 0, this.mDocumentParcel.getPropertyMap());
        if (rawPropertyFromRawDocument instanceof GenericDocumentParcel) {
            return new GenericDocument[]{new GenericDocument((GenericDocumentParcel) rawPropertyFromRawDocument)};
        }
        if (!(rawPropertyFromRawDocument instanceof GenericDocumentParcel[])) {
            return rawPropertyFromRawDocument;
        }
        GenericDocumentParcel[] genericDocumentParcelArr = (GenericDocumentParcel[]) rawPropertyFromRawDocument;
        GenericDocument[] genericDocumentArr = new GenericDocument[genericDocumentParcelArr.length];
        for (int i = 0; i < genericDocumentParcelArr.length; i++) {
            GenericDocumentParcel genericDocumentParcel = genericDocumentParcelArr[i];
            if (genericDocumentParcel == null) {
                Log.e("AppSearchGenericDocumen", "The inner parcel is null at " + i + ", for path: " + str);
            } else {
                genericDocumentArr[i] = new GenericDocument(genericDocumentParcel);
            }
        }
        return genericDocumentArr;
    }

    public boolean getPropertyBoolean(String str) {
        Preconditions.checkNotNull(str);
        boolean[] propertyBooleanArray = getPropertyBooleanArray(str);
        if (propertyBooleanArray == null || propertyBooleanArray.length == 0) {
            return false;
        }
        warnIfSinglePropertyTooLong("Boolean", str, propertyBooleanArray.length);
        return propertyBooleanArray[0];
    }

    public boolean[] getPropertyBooleanArray(String str) {
        Preconditions.checkNotNull(str);
        return (boolean[]) safeCastProperty(str, getProperty(str), boolean[].class);
    }

    public GenericDocument getPropertyDocument(String str) {
        Preconditions.checkNotNull(str);
        GenericDocument[] propertyDocumentArray = getPropertyDocumentArray(str);
        if (propertyDocumentArray == null || propertyDocumentArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("Document", str, propertyDocumentArray.length);
        return propertyDocumentArray[0];
    }

    public GenericDocument[] getPropertyDocumentArray(String str) {
        Preconditions.checkNotNull(str);
        return (GenericDocument[]) safeCastProperty(str, getProperty(str), GenericDocument[].class);
    }

    public long getPropertyLong(String str) {
        Preconditions.checkNotNull(str);
        long[] propertyLongArray = getPropertyLongArray(str);
        if (propertyLongArray == null || propertyLongArray.length == 0) {
            return 0L;
        }
        warnIfSinglePropertyTooLong("Long", str, propertyLongArray.length);
        return propertyLongArray[0];
    }

    public long[] getPropertyLongArray(String str) {
        Preconditions.checkNotNull(str);
        return (long[]) safeCastProperty(str, getProperty(str), long[].class);
    }

    public Set<String> getPropertyNames() {
        return Collections.unmodifiableSet(this.mDocumentParcel.getPropertyNames());
    }

    public String getPropertyString(String str) {
        Preconditions.checkNotNull(str);
        String[] propertyStringArray = getPropertyStringArray(str);
        if (propertyStringArray == null || propertyStringArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("String", str, propertyStringArray.length);
        return propertyStringArray[0];
    }

    public String[] getPropertyStringArray(String str) {
        Preconditions.checkNotNull(str);
        return (String[]) safeCastProperty(str, getProperty(str), String[].class);
    }

    public String getSchemaType() {
        return this.mDocumentParcel.getSchemaType();
    }

    public int getScore() {
        return this.mDocumentParcel.getScore();
    }

    public long getTtlMillis() {
        return this.mDocumentParcel.getTtlMillis();
    }

    public int hashCode() {
        return this.mDocumentParcel.hashCode();
    }

    public <T> T toDocumentClass(Class<T> cls, DocumentClassMappingContext documentClassMappingContext) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(documentClassMappingContext);
        return DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) findTargetClassToDeserialize(cls, documentClassMappingContext.getDocumentClassMap(), documentClassMappingContext.getParentTypeMap())).fromGenericDocument(this, documentClassMappingContext);
    }

    public String toString() {
        IndentingStringBuilder indentingStringBuilder = new IndentingStringBuilder();
        appendGenericDocumentString(indentingStringBuilder);
        return indentingStringBuilder.toString();
    }

    public static class Builder<BuilderType extends Builder> {
        private final BuilderType mBuilderTypeInstance;
        private final GenericDocumentParcel.Builder mDocumentParcelBuilder;

        public Builder(String str, String str2, String str3) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(str3);
            this.mBuilderTypeInstance = this;
            this.mDocumentParcelBuilder = new GenericDocumentParcel.Builder(str, str2, str3);
        }

        private void validatePropertyName(String str) {
            if (str.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Property name cannot be blank.");
            }
        }

        public GenericDocument build() {
            return new GenericDocument(this.mDocumentParcelBuilder.build());
        }

        public BuilderType clearProperty(String str) {
            Preconditions.checkNotNull(str);
            this.mDocumentParcelBuilder.clearProperty(str);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setCreationTimestampMillis(long j) {
            this.mDocumentParcelBuilder.setCreationTimestampMillis(j);
            return this.mBuilderTypeInstance;
        }

        @Deprecated
        public BuilderType setParentTypes(List<String> list) {
            this.mDocumentParcelBuilder.setParentTypes(list);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyBoolean(String str, boolean... zArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(zArr);
            validatePropertyName(str);
            this.mDocumentParcelBuilder.putInPropertyMap(str, zArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyBytes(String str, byte[]... bArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(bArr);
            validatePropertyName(str);
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "The byte[] at ", " is null."));
                    return null;
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, bArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyDocument(String str, GenericDocument... genericDocumentArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(genericDocumentArr);
            validatePropertyName(str);
            GenericDocumentParcel[] genericDocumentParcelArr = new GenericDocumentParcel[genericDocumentArr.length];
            for (int i = 0; i < genericDocumentArr.length; i++) {
                GenericDocument genericDocument = genericDocumentArr[i];
                if (genericDocument == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "The document at ", " is null."));
                    return null;
                }
                genericDocumentParcelArr[i] = genericDocument.getDocumentParcel();
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, genericDocumentParcelArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyDouble(String str, double... dArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(dArr);
            validatePropertyName(str);
            this.mDocumentParcelBuilder.putInPropertyMap(str, dArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyEmbedding(String str, EmbeddingVector... embeddingVectorArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(embeddingVectorArr);
            validatePropertyName(str);
            for (int i = 0; i < embeddingVectorArr.length; i++) {
                if (embeddingVectorArr[i] == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "The EmbeddingVector at ", " is null."));
                    return null;
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, embeddingVectorArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyLong(String str, long... jArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(jArr);
            validatePropertyName(str);
            this.mDocumentParcelBuilder.putInPropertyMap(str, jArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setPropertyString(String str, String... strArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(strArr);
            validatePropertyName(str);
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "The String at ", " is null."));
                    return null;
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, strArr);
            return this.mBuilderTypeInstance;
        }

        public BuilderType setScore(int i) {
            if (i >= 0) {
                this.mDocumentParcelBuilder.setScore(i);
                return this.mBuilderTypeInstance;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Document score cannot be negative.");
            return null;
        }

        public BuilderType setTtlMillis(long j) {
            if (j >= 0) {
                this.mDocumentParcelBuilder.setTtlMillis(j);
                return this.mBuilderTypeInstance;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Document ttlMillis cannot be negative.");
            return null;
        }

        public Builder(GenericDocumentParcel.Builder builder) {
            Objects.requireNonNull(builder);
            this.mDocumentParcelBuilder = builder;
            this.mBuilderTypeInstance = this;
        }

        public Builder(GenericDocument genericDocument) {
            this(new GenericDocumentParcel.Builder(genericDocument.mDocumentParcel));
        }
    }

    public <T> T toDocumentClass(Class<T> cls) {
        return (T) toDocumentClass(cls, DocumentClassMappingContext.EMPTY);
    }
}
