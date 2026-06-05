package androidx.appsearch.app;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appsearch.exceptions.IllegalSchemaException;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.PropertyConfigParcel;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.util.IndentingStringBuilder;
import androidx.collection.ArraySet;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.urbandroid.sleep.service.Settings$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class AppSearchSchema extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AppSearchSchema> CREATOR = new AbstractCreator<AppSearchSchema>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$AppSearchSchemaCreator
        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return super.createFromParcel(parcel);
        }

        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return super.newArray(i);
        }
    };
    private final String mDescription;
    private final List<String> mParentTypes;
    final List<PropertyConfigParcel> mPropertyConfigParcels;
    private final String mSchemaType;

    public static final class BlobHandlePropertyConfig extends PropertyConfig {
        public BlobHandlePropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }
    }

    public static final class BooleanPropertyConfig extends PropertyConfig {

        public static final class Builder {
            private final String mPropertyName;
            private String mDescription = "";
            private int mCardinality = 2;
            private boolean mScoringEnabled = false;

            public Builder(String str) {
                this.mPropertyName = (String) Preconditions.checkNotNull(str);
            }

            public BooleanPropertyConfig build() {
                return new BooleanPropertyConfig(PropertyConfigParcel.createForBoolean(this.mPropertyName, this.mDescription, this.mCardinality, this.mScoringEnabled));
            }

            public Builder setCardinality(int i) {
                Preconditions.checkArgumentInRange(i, 1, 3, "cardinality");
                this.mCardinality = i;
                return this;
            }
        }

        public BooleanPropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }
    }

    public static final class Builder {
        private String mSchemaType;
        private String mDescription = "";
        private ArrayList<PropertyConfigParcel> mPropertyConfigParcels = new ArrayList<>();
        private LinkedHashSet<String> mParentTypes = new LinkedHashSet<>();
        private final Set<String> mPropertyNames = new ArraySet();
        private boolean mBuilt = false;

        public Builder(String str) {
            this.mSchemaType = (String) Preconditions.checkNotNull(str);
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mPropertyConfigParcels = new ArrayList<>(this.mPropertyConfigParcels);
                this.mParentTypes = new LinkedHashSet<>(this.mParentTypes);
                this.mBuilt = false;
            }
        }

        public Builder addProperty(PropertyConfig propertyConfig) {
            Preconditions.checkNotNull(propertyConfig);
            resetIfBuilt();
            String name = propertyConfig.getName();
            if (!this.mPropertyNames.add(name)) {
                throw new IllegalSchemaException(FileInsert$$ExternalSyntheticOutline0.m("Property defined more than once: ", name));
            }
            this.mPropertyConfigParcels.add(propertyConfig.mPropertyConfigParcel);
            return this;
        }

        public AppSearchSchema build() {
            this.mBuilt = true;
            return new AppSearchSchema(this.mSchemaType, this.mPropertyConfigParcels, new ArrayList(this.mParentTypes), this.mDescription);
        }
    }

    public static final class BytesPropertyConfig extends PropertyConfig {
        public BytesPropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }
    }

    public static final class DocumentPropertyConfig extends PropertyConfig {

        public static final class Builder {
            private final String mPropertyName;
            private final String mSchemaType;
            private String mDescription = "";
            private int mCardinality = 2;
            private boolean mShouldIndexNestedProperties = false;
            private final Set<String> mIndexableNestedPropertiesList = new ArraySet();

            public Builder(String str, String str2) {
                this.mPropertyName = (String) Preconditions.checkNotNull(str);
                this.mSchemaType = (String) Preconditions.checkNotNull(str2);
            }

            public DocumentPropertyConfig build() {
                if (!this.mShouldIndexNestedProperties || this.mIndexableNestedPropertiesList.isEmpty()) {
                    return new DocumentPropertyConfig(PropertyConfigParcel.createForDocument(this.mPropertyName, this.mDescription, this.mCardinality, this.mSchemaType, new PropertyConfigParcel.DocumentIndexingConfigParcel(this.mShouldIndexNestedProperties, new ArrayList(this.mIndexableNestedPropertiesList))));
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("DocumentIndexingConfig#shouldIndexNestedProperties is required to be false when one or more indexableNestedProperties are provided.");
                return null;
            }

            public Builder setCardinality(int i) {
                Preconditions.checkArgumentInRange(i, 1, 3, "cardinality");
                this.mCardinality = i;
                return this;
            }

            public Builder setShouldIndexNestedProperties(boolean z) {
                this.mShouldIndexNestedProperties = z;
                return this;
            }
        }

        public DocumentPropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }

        public void appendDocumentPropertyConfigFields(IndentingStringBuilder indentingStringBuilder) {
            indentingStringBuilder.append("shouldIndexNestedProperties: ").append(Boolean.valueOf(shouldIndexNestedProperties())).append(",\n");
            indentingStringBuilder.append("indexableNestedProperties: ").append(getIndexableNestedProperties()).append(",\n");
            indentingStringBuilder.append("schemaType: \"").append(getSchemaType()).append("\",\n");
        }

        public List<String> getIndexableNestedProperties() {
            PropertyConfigParcel.DocumentIndexingConfigParcel documentIndexingConfigParcel = this.mPropertyConfigParcel.getDocumentIndexingConfigParcel();
            if (documentIndexingConfigParcel == null) {
                return Collections.EMPTY_LIST;
            }
            List<String> indexableNestedPropertiesList = documentIndexingConfigParcel.getIndexableNestedPropertiesList();
            return indexableNestedPropertiesList == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(indexableNestedPropertiesList);
        }

        public String getSchemaType() {
            return (String) Preconditions.checkNotNull(this.mPropertyConfigParcel.getSchemaType());
        }

        public boolean shouldIndexNestedProperties() {
            PropertyConfigParcel.DocumentIndexingConfigParcel documentIndexingConfigParcel = this.mPropertyConfigParcel.getDocumentIndexingConfigParcel();
            if (documentIndexingConfigParcel == null) {
                return false;
            }
            return documentIndexingConfigParcel.shouldIndexNestedProperties();
        }
    }

    public static final class DoublePropertyConfig extends PropertyConfig {
        public DoublePropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }
    }

    public static final class EmbeddingPropertyConfig extends PropertyConfig {
        public EmbeddingPropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }
    }

    public static final class LongPropertyConfig extends PropertyConfig {

        public static final class Builder {
            private final String mPropertyName;
            private String mDescription = "";
            private int mCardinality = 2;
            private int mIndexingType = 0;
            private boolean mScoringEnabled = false;

            public Builder(String str) {
                this.mPropertyName = (String) Preconditions.checkNotNull(str);
            }

            public LongPropertyConfig build() {
                return new LongPropertyConfig(PropertyConfigParcel.createForLong(this.mPropertyName, this.mDescription, this.mCardinality, this.mIndexingType, this.mScoringEnabled));
            }

            public Builder setCardinality(int i) {
                Preconditions.checkArgumentInRange(i, 1, 3, "cardinality");
                this.mCardinality = i;
                return this;
            }

            public Builder setIndexingType(int i) {
                Preconditions.checkArgumentInRange(i, 0, 1, "indexingType");
                this.mIndexingType = i;
                return this;
            }
        }

        public LongPropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }

        public void appendLongPropertyConfigFields(IndentingStringBuilder indentingStringBuilder) {
            int indexingType = getIndexingType();
            if (indexingType == 0) {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_NONE,\n");
            } else if (indexingType != 1) {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_UNKNOWN,\n");
            } else {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_RANGE,\n");
            }
        }

        public int getIndexingType() {
            PropertyConfigParcel.IntegerIndexingConfigParcel integerIndexingConfigParcel = this.mPropertyConfigParcel.getIntegerIndexingConfigParcel();
            if (integerIndexingConfigParcel == null) {
                return 0;
            }
            return integerIndexingConfigParcel.getIndexingType();
        }
    }

    public static abstract class PropertyConfig {
        final PropertyConfigParcel mPropertyConfigParcel;

        public PropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            this.mPropertyConfigParcel = (PropertyConfigParcel) Preconditions.checkNotNull(propertyConfigParcel);
        }

        public static PropertyConfig fromParcel(PropertyConfigParcel propertyConfigParcel) {
            Preconditions.checkNotNull(propertyConfigParcel);
            switch (propertyConfigParcel.getDataType()) {
                case 1:
                    return new StringPropertyConfig(propertyConfigParcel);
                case 2:
                    return new LongPropertyConfig(propertyConfigParcel);
                case 3:
                    return new DoublePropertyConfig(propertyConfigParcel);
                case 4:
                    return new BooleanPropertyConfig(propertyConfigParcel);
                case 5:
                    return new BytesPropertyConfig(propertyConfigParcel);
                case 6:
                    return new DocumentPropertyConfig(propertyConfigParcel);
                case 7:
                    return new EmbeddingPropertyConfig(propertyConfigParcel);
                case 8:
                    return new BlobHandlePropertyConfig(propertyConfigParcel);
                default:
                    throw new IllegalArgumentException("Unsupported property bundle of type " + propertyConfigParcel.getDataType() + "; contents: " + propertyConfigParcel);
            }
        }

        public void appendPropertyConfigString(IndentingStringBuilder indentingStringBuilder) {
            Preconditions.checkNotNull(indentingStringBuilder);
            indentingStringBuilder.append("{\n");
            indentingStringBuilder.increaseIndentLevel();
            indentingStringBuilder.append("name: \"").append(getName()).append("\",\n");
            indentingStringBuilder.append("description: \"").append(getDescription()).append("\",\n");
            if (this instanceof StringPropertyConfig) {
                ((StringPropertyConfig) this).appendStringPropertyConfigFields(indentingStringBuilder);
            } else if (this instanceof DocumentPropertyConfig) {
                ((DocumentPropertyConfig) this).appendDocumentPropertyConfigFields(indentingStringBuilder);
            } else if (this instanceof LongPropertyConfig) {
                ((LongPropertyConfig) this).appendLongPropertyConfigFields(indentingStringBuilder);
            }
            int cardinality = getCardinality();
            if (cardinality == 1) {
                indentingStringBuilder.append("cardinality: CARDINALITY_REPEATED,\n");
            } else if (cardinality == 2) {
                indentingStringBuilder.append("cardinality: CARDINALITY_OPTIONAL,\n");
            } else if (cardinality != 3) {
                indentingStringBuilder.append("cardinality: CARDINALITY_UNKNOWN,\n");
            } else {
                indentingStringBuilder.append("cardinality: CARDINALITY_REQUIRED,\n");
            }
            switch (getDataType()) {
                case 1:
                    indentingStringBuilder.append("dataType: DATA_TYPE_STRING,\n");
                    break;
                case 2:
                    indentingStringBuilder.append("dataType: DATA_TYPE_LONG,\n");
                    break;
                case 3:
                    indentingStringBuilder.append("dataType: DATA_TYPE_DOUBLE,\n");
                    break;
                case 4:
                    indentingStringBuilder.append("dataType: DATA_TYPE_BOOLEAN,\n");
                    break;
                case 5:
                    indentingStringBuilder.append("dataType: DATA_TYPE_BYTES,\n");
                    break;
                case 6:
                    indentingStringBuilder.append("dataType: DATA_TYPE_DOCUMENT,\n");
                    break;
                case 7:
                    indentingStringBuilder.append("dataType: DATA_TYPE_EMBEDDING,\n");
                    break;
                case 8:
                    indentingStringBuilder.append("dataType: DATA_TYPE_BLOB_HANDLE,\n");
                    break;
                default:
                    indentingStringBuilder.append("dataType: DATA_TYPE_UNKNOWN,\n");
                    break;
            }
            indentingStringBuilder.decreaseIndentLevel();
            indentingStringBuilder.append("}");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PropertyConfig) {
                return ObjectsCompat.equals(this.mPropertyConfigParcel, ((PropertyConfig) obj).mPropertyConfigParcel);
            }
            return false;
        }

        public int getCardinality() {
            return this.mPropertyConfigParcel.getCardinality();
        }

        public int getDataType() {
            return this.mPropertyConfigParcel.getDataType();
        }

        public String getDescription() {
            return this.mPropertyConfigParcel.getDescription();
        }

        public String getName() {
            return this.mPropertyConfigParcel.getName();
        }

        public int hashCode() {
            return this.mPropertyConfigParcel.hashCode();
        }

        public String toString() {
            IndentingStringBuilder indentingStringBuilder = new IndentingStringBuilder();
            appendPropertyConfigString(indentingStringBuilder);
            return indentingStringBuilder.toString();
        }
    }

    public static final class StringPropertyConfig extends PropertyConfig {

        public static final class Builder {
            private final String mPropertyName;
            private String mDescription = "";
            private int mCardinality = 2;
            private int mIndexingType = 0;
            private int mTokenizerType = 0;
            private int mJoinableValueType = 0;
            private int mDeletePropagationType = 0;

            public Builder(String str) {
                this.mPropertyName = (String) Preconditions.checkNotNull(str);
            }

            public StringPropertyConfig build() {
                int i = this.mTokenizerType;
                int i2 = this.mIndexingType;
                if (i == 0) {
                    Preconditions.checkState(i2 == 0, "Cannot set TOKENIZER_TYPE_NONE with an indexing type other than INDEXING_TYPE_NONE.");
                } else {
                    Preconditions.checkState(i2 != 0, "Cannot set TOKENIZER_TYPE_PLAIN with INDEXING_TYPE_NONE.");
                }
                if (this.mJoinableValueType == 1) {
                    Preconditions.checkState(this.mCardinality != 1, "Cannot set JOINABLE_VALUE_TYPE_QUALIFIED_ID with CARDINALITY_REPEATED.");
                }
                if (this.mDeletePropagationType != 0) {
                    Preconditions.checkState(this.mJoinableValueType == 1, "Cannot set delete propagation without setting JOINABLE_VALUE_TYPE_QUALIFIED_ID.");
                }
                return new StringPropertyConfig(PropertyConfigParcel.createForString(this.mPropertyName, this.mDescription, this.mCardinality, new PropertyConfigParcel.StringIndexingConfigParcel(this.mIndexingType, this.mTokenizerType), new PropertyConfigParcel.JoinableConfigParcel(this.mJoinableValueType, this.mDeletePropagationType)));
            }

            public Builder setCardinality(int i) {
                Preconditions.checkArgumentInRange(i, 1, 3, "cardinality");
                this.mCardinality = i;
                return this;
            }

            public Builder setIndexingType(int i) {
                Preconditions.checkArgumentInRange(i, 0, 2, "indexingType");
                this.mIndexingType = i;
                return this;
            }

            public Builder setJoinableValueType(int i) {
                Preconditions.checkArgumentInRange(i, 0, 1, "joinableValueType");
                this.mJoinableValueType = i;
                return this;
            }

            public Builder setTokenizerType(int i) {
                Preconditions.checkArgumentInRange(i, 0, 3, "tokenizerType");
                this.mTokenizerType = i;
                return this;
            }
        }

        public StringPropertyConfig(PropertyConfigParcel propertyConfigParcel) {
            super(propertyConfigParcel);
        }

        public void appendStringPropertyConfigFields(IndentingStringBuilder indentingStringBuilder) {
            int indexingType = getIndexingType();
            if (indexingType == 0) {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_NONE,\n");
            } else if (indexingType == 1) {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_EXACT_TERMS,\n");
            } else if (indexingType != 2) {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_UNKNOWN,\n");
            } else {
                indentingStringBuilder.append("indexingType: INDEXING_TYPE_PREFIXES,\n");
            }
            int tokenizerType = getTokenizerType();
            if (tokenizerType == 0) {
                indentingStringBuilder.append("tokenizerType: TOKENIZER_TYPE_NONE,\n");
            } else if (tokenizerType == 1) {
                indentingStringBuilder.append("tokenizerType: TOKENIZER_TYPE_PLAIN,\n");
            } else if (tokenizerType == 2) {
                indentingStringBuilder.append("tokenizerType: TOKENIZER_TYPE_VERBATIM,\n");
            } else if (tokenizerType != 3) {
                indentingStringBuilder.append("tokenizerType: TOKENIZER_TYPE_UNKNOWN,\n");
            } else {
                indentingStringBuilder.append("tokenizerType: TOKENIZER_TYPE_RFC822,\n");
            }
            int joinableValueType = getJoinableValueType();
            if (joinableValueType == 0) {
                indentingStringBuilder.append("joinableValueType: JOINABLE_VALUE_TYPE_NONE,\n");
            } else if (joinableValueType != 1) {
                indentingStringBuilder.append("joinableValueType: JOINABLE_VALUE_TYPE_UNKNOWN,\n");
            } else {
                indentingStringBuilder.append("joinableValueType: JOINABLE_VALUE_TYPE_QUALIFIED_ID,\n");
            }
            int deletePropagationType = getDeletePropagationType();
            if (deletePropagationType == 0) {
                indentingStringBuilder.append("deletePropagationType: DELETE_PROPAGATION_TYPE_NONE,\n");
            } else if (deletePropagationType != 1) {
                indentingStringBuilder.append("deletePropagationType: DELETE_PROPAGATION_TYPE_UNKNOWN,\n");
            } else {
                indentingStringBuilder.append("deletePropagationType: DELETE_PROPAGATION_TYPE_PROPAGATE_FROM,\n");
            }
        }

        public int getDeletePropagationType() {
            PropertyConfigParcel.JoinableConfigParcel joinableConfigParcel = this.mPropertyConfigParcel.getJoinableConfigParcel();
            if (joinableConfigParcel == null) {
                return 0;
            }
            return joinableConfigParcel.getDeletePropagationType();
        }

        public int getIndexingType() {
            PropertyConfigParcel.StringIndexingConfigParcel stringIndexingConfigParcel = this.mPropertyConfigParcel.getStringIndexingConfigParcel();
            if (stringIndexingConfigParcel == null) {
                return 0;
            }
            return stringIndexingConfigParcel.getIndexingType();
        }

        public int getJoinableValueType() {
            PropertyConfigParcel.JoinableConfigParcel joinableConfigParcel = this.mPropertyConfigParcel.getJoinableConfigParcel();
            if (joinableConfigParcel == null) {
                return 0;
            }
            return joinableConfigParcel.getJoinableValueType();
        }

        public int getTokenizerType() {
            PropertyConfigParcel.StringIndexingConfigParcel stringIndexingConfigParcel = this.mPropertyConfigParcel.getStringIndexingConfigParcel();
            if (stringIndexingConfigParcel == null) {
                return 0;
            }
            return stringIndexingConfigParcel.getTokenizerType();
        }
    }

    public AppSearchSchema(String str, List<PropertyConfigParcel> list, List<String> list2, String str2) {
        this.mSchemaType = (String) Preconditions.checkNotNull(str);
        this.mPropertyConfigParcels = (List) Preconditions.checkNotNull(list);
        this.mParentTypes = (List) Preconditions.checkNotNull(list2);
        this.mDescription = (String) Preconditions.checkNotNull(str2);
    }

    private void appendAppSearchSchemaString(IndentingStringBuilder indentingStringBuilder) {
        Preconditions.checkNotNull(indentingStringBuilder);
        indentingStringBuilder.append("{\n");
        indentingStringBuilder.increaseIndentLevel();
        indentingStringBuilder.append("schemaType: \"").append(getSchemaType()).append("\",\n");
        indentingStringBuilder.append("description: \"").append(getDescription()).append("\",\n");
        indentingStringBuilder.append("properties: [\n");
        PropertyConfig[] propertyConfigArr = (PropertyConfig[]) getProperties().toArray(new PropertyConfig[0]);
        Arrays.sort(propertyConfigArr, new Settings$$ExternalSyntheticLambda0(1));
        for (int i = 0; i < propertyConfigArr.length; i++) {
            PropertyConfig propertyConfig = propertyConfigArr[i];
            indentingStringBuilder.increaseIndentLevel();
            propertyConfig.appendPropertyConfigString(indentingStringBuilder);
            if (i != propertyConfigArr.length - 1) {
                indentingStringBuilder.append(",\n");
            }
            indentingStringBuilder.decreaseIndentLevel();
        }
        indentingStringBuilder.append("\n");
        indentingStringBuilder.append("]\n");
        indentingStringBuilder.decreaseIndentLevel();
        indentingStringBuilder.append("}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$appendAppSearchSchemaString$0(PropertyConfig propertyConfig, PropertyConfig propertyConfig2) {
        return propertyConfig.getName().compareTo(propertyConfig2.getName());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSearchSchema)) {
            return false;
        }
        AppSearchSchema appSearchSchema = (AppSearchSchema) obj;
        if (getSchemaType().equals(appSearchSchema.getSchemaType()) && getDescription().equals(appSearchSchema.getDescription()) && getParentTypes().equals(appSearchSchema.getParentTypes())) {
            return getProperties().equals(appSearchSchema.getProperties());
        }
        return false;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public List<String> getParentTypes() {
        return Collections.unmodifiableList(this.mParentTypes);
    }

    public List<PropertyConfig> getProperties() {
        if (this.mPropertyConfigParcels.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.mPropertyConfigParcels.size());
        for (int i = 0; i < this.mPropertyConfigParcels.size(); i++) {
            arrayList.add(PropertyConfig.fromParcel(this.mPropertyConfigParcels.get(i)));
        }
        return arrayList;
    }

    public String getSchemaType() {
        return this.mSchemaType;
    }

    public int hashCode() {
        return ObjectsCompat.hash(getSchemaType(), getProperties(), getParentTypes(), getDescription());
    }

    public String toString() {
        IndentingStringBuilder indentingStringBuilder = new IndentingStringBuilder();
        appendAppSearchSchemaString(indentingStringBuilder);
        return indentingStringBuilder.toString();
    }
}
