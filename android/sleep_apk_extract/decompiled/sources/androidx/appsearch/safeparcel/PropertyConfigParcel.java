package androidx.appsearch.safeparcel;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.core.util.ObjectsCompat;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class PropertyConfigParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PropertyConfigParcel> CREATOR = new AbstractCreator<PropertyConfigParcel>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$PropertyConfigParcelCreator
        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return super.createFromParcel(parcel);
        }

        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return super.newArray(i);
        }
    };
    private final int mCardinality;
    private final int mDataType;
    private final String mDescription;
    private final DocumentIndexingConfigParcel mDocumentIndexingConfigParcel;
    private Integer mHashCode;
    private final IntegerIndexingConfigParcel mIntegerIndexingConfigParcel;
    private final JoinableConfigParcel mJoinableConfigParcel;
    private final String mName;
    private final String mSchemaType;
    private final boolean mScoringEnabled;
    private final StringIndexingConfigParcel mStringIndexingConfigParcel;

    public static class DocumentIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DocumentIndexingConfigParcel> CREATOR = new AbstractCreator<DocumentIndexingConfigParcel>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$DocumentIndexingConfigParcelCreator
            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return super.createFromParcel(parcel);
            }

            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return super.newArray(i);
            }
        };
        private final boolean mIndexNestedProperties;
        private final List<String> mIndexableNestedPropertiesList;

        public DocumentIndexingConfigParcel(boolean z, List<String> list) {
            this.mIndexNestedProperties = z;
            Objects.requireNonNull(list);
            this.mIndexableNestedPropertiesList = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DocumentIndexingConfigParcel)) {
                return false;
            }
            DocumentIndexingConfigParcel documentIndexingConfigParcel = (DocumentIndexingConfigParcel) obj;
            return ObjectsCompat.equals(Boolean.valueOf(this.mIndexNestedProperties), Boolean.valueOf(documentIndexingConfigParcel.mIndexNestedProperties)) && ObjectsCompat.equals(this.mIndexableNestedPropertiesList, documentIndexingConfigParcel.mIndexableNestedPropertiesList);
        }

        public List<String> getIndexableNestedPropertiesList() {
            return this.mIndexableNestedPropertiesList;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(this.mIndexNestedProperties), this.mIndexableNestedPropertiesList);
        }

        public boolean shouldIndexNestedProperties() {
            return this.mIndexNestedProperties;
        }

        public String toString() {
            return "{indexNestedProperties: " + this.mIndexNestedProperties + ", indexableNestedPropertiesList: " + this.mIndexableNestedPropertiesList + "}";
        }
    }

    public static class EmbeddingIndexingConfigParcel extends AbstractSafeParcelable {
    }

    public static class IntegerIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<IntegerIndexingConfigParcel> CREATOR = new AbstractCreator<IntegerIndexingConfigParcel>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$IntegerIndexingConfigParcelCreator
            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return super.createFromParcel(parcel);
            }

            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return super.newArray(i);
            }
        };
        private final int mIndexingType;

        public IntegerIndexingConfigParcel(int i) {
            this.mIndexingType = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntegerIndexingConfigParcel) && this.mIndexingType == ((IntegerIndexingConfigParcel) obj).mIndexingType;
        }

        public int getIndexingType() {
            return this.mIndexingType;
        }

        public int hashCode() {
            return ObjectsCompat.hashCode(Integer.valueOf(this.mIndexingType));
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(this.mIndexingType, "}", new StringBuilder("{indexingType: "));
        }
    }

    public static class JoinableConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<JoinableConfigParcel> CREATOR = new AbstractCreator<JoinableConfigParcel>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$JoinableConfigParcelCreator
            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return super.createFromParcel(parcel);
            }

            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return super.newArray(i);
            }
        };
        private final int mDeletePropagationType;
        private final int mJoinableValueType;

        public JoinableConfigParcel(int i, int i2) {
            this.mJoinableValueType = i;
            this.mDeletePropagationType = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JoinableConfigParcel)) {
                return false;
            }
            JoinableConfigParcel joinableConfigParcel = (JoinableConfigParcel) obj;
            return ObjectsCompat.equals(Integer.valueOf(this.mJoinableValueType), Integer.valueOf(joinableConfigParcel.mJoinableValueType)) && this.mDeletePropagationType == joinableConfigParcel.mDeletePropagationType;
        }

        public int getDeletePropagationType() {
            return this.mDeletePropagationType;
        }

        public int getJoinableValueType() {
            return this.mJoinableValueType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mJoinableValueType), Integer.valueOf(this.mDeletePropagationType));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{joinableValueType: ");
            sb.append(this.mJoinableValueType);
            sb.append(", deletePropagationType: ");
            return FileInsert$$ExternalSyntheticOutline0.m(this.mDeletePropagationType, "}", sb);
        }
    }

    public static class StringIndexingConfigParcel extends AbstractSafeParcelable {
        public static final Parcelable.Creator<StringIndexingConfigParcel> CREATOR = new AbstractCreator<StringIndexingConfigParcel>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$StringIndexingConfigParcelCreator
            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return super.createFromParcel(parcel);
            }

            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return super.newArray(i);
            }
        };
        private final int mIndexingType;
        private final int mTokenizerType;

        public StringIndexingConfigParcel(int i, int i2) {
            this.mIndexingType = i;
            this.mTokenizerType = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringIndexingConfigParcel)) {
                return false;
            }
            StringIndexingConfigParcel stringIndexingConfigParcel = (StringIndexingConfigParcel) obj;
            return this.mIndexingType == stringIndexingConfigParcel.mIndexingType && ObjectsCompat.equals(Integer.valueOf(this.mTokenizerType), Integer.valueOf(stringIndexingConfigParcel.mTokenizerType));
        }

        public int getIndexingType() {
            return this.mIndexingType;
        }

        public int getTokenizerType() {
            return this.mTokenizerType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mIndexingType), Integer.valueOf(this.mTokenizerType));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{indexingType: ");
            sb.append(this.mIndexingType);
            sb.append(", tokenizerType: ");
            return FileInsert$$ExternalSyntheticOutline0.m(this.mTokenizerType, "}", sb);
        }
    }

    public PropertyConfigParcel(String str, int i, int i2, String str2, StringIndexingConfigParcel stringIndexingConfigParcel, DocumentIndexingConfigParcel documentIndexingConfigParcel, IntegerIndexingConfigParcel integerIndexingConfigParcel, JoinableConfigParcel joinableConfigParcel, String str3, EmbeddingIndexingConfigParcel embeddingIndexingConfigParcel, boolean z) {
        Objects.requireNonNull(str);
        this.mName = str;
        this.mDataType = i;
        this.mCardinality = i2;
        this.mSchemaType = str2;
        this.mStringIndexingConfigParcel = stringIndexingConfigParcel;
        this.mDocumentIndexingConfigParcel = documentIndexingConfigParcel;
        this.mIntegerIndexingConfigParcel = integerIndexingConfigParcel;
        this.mJoinableConfigParcel = joinableConfigParcel;
        Objects.requireNonNull(str3);
        this.mDescription = str3;
        this.mScoringEnabled = z;
    }

    public static PropertyConfigParcel createForBoolean(String str, String str2, int i, boolean z) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 4, i, null, null, null, null, null, str2, null, z);
    }

    public static PropertyConfigParcel createForDocument(String str, String str2, int i, String str3, DocumentIndexingConfigParcel documentIndexingConfigParcel) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str3);
        Objects.requireNonNull(documentIndexingConfigParcel);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 6, i, str3, null, documentIndexingConfigParcel, null, null, str2, null, false);
    }

    public static PropertyConfigParcel createForLong(String str, String str2, int i, int i2, boolean z) {
        Objects.requireNonNull(str);
        IntegerIndexingConfigParcel integerIndexingConfigParcel = new IntegerIndexingConfigParcel(i2);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 2, i, null, null, null, integerIndexingConfigParcel, null, str2, null, z);
    }

    public static PropertyConfigParcel createForString(String str, String str2, int i, StringIndexingConfigParcel stringIndexingConfigParcel, JoinableConfigParcel joinableConfigParcel) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(stringIndexingConfigParcel);
        Objects.requireNonNull(joinableConfigParcel);
        Objects.requireNonNull(str2);
        return new PropertyConfigParcel(str, 1, i, null, stringIndexingConfigParcel, null, null, joinableConfigParcel, str2, null, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertyConfigParcel)) {
            return false;
        }
        PropertyConfigParcel propertyConfigParcel = (PropertyConfigParcel) obj;
        return ObjectsCompat.equals(this.mName, propertyConfigParcel.mName) && Objects.equals(this.mDescription, propertyConfigParcel.mDescription) && ObjectsCompat.equals(Integer.valueOf(this.mDataType), Integer.valueOf(propertyConfigParcel.mDataType)) && ObjectsCompat.equals(Integer.valueOf(this.mCardinality), Integer.valueOf(propertyConfigParcel.mCardinality)) && ObjectsCompat.equals(this.mSchemaType, propertyConfigParcel.mSchemaType) && ObjectsCompat.equals(this.mStringIndexingConfigParcel, propertyConfigParcel.mStringIndexingConfigParcel) && ObjectsCompat.equals(this.mDocumentIndexingConfigParcel, propertyConfigParcel.mDocumentIndexingConfigParcel) && ObjectsCompat.equals(this.mIntegerIndexingConfigParcel, propertyConfigParcel.mIntegerIndexingConfigParcel) && ObjectsCompat.equals(this.mJoinableConfigParcel, propertyConfigParcel.mJoinableConfigParcel) && ObjectsCompat.equals(null, null) && this.mScoringEnabled == propertyConfigParcel.mScoringEnabled;
    }

    public int getCardinality() {
        return this.mCardinality;
    }

    public int getDataType() {
        return this.mDataType;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public DocumentIndexingConfigParcel getDocumentIndexingConfigParcel() {
        return this.mDocumentIndexingConfigParcel;
    }

    public IntegerIndexingConfigParcel getIntegerIndexingConfigParcel() {
        return this.mIntegerIndexingConfigParcel;
    }

    public JoinableConfigParcel getJoinableConfigParcel() {
        return this.mJoinableConfigParcel;
    }

    public String getName() {
        return this.mName;
    }

    public String getSchemaType() {
        return this.mSchemaType;
    }

    public StringIndexingConfigParcel getStringIndexingConfigParcel() {
        return this.mStringIndexingConfigParcel;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(ObjectsCompat.hash(this.mName, this.mDescription, Integer.valueOf(this.mDataType), Integer.valueOf(this.mCardinality), this.mSchemaType, this.mStringIndexingConfigParcel, this.mDocumentIndexingConfigParcel, this.mIntegerIndexingConfigParcel, this.mJoinableConfigParcel, null, Boolean.valueOf(this.mScoringEnabled)));
        }
        return this.mHashCode.intValue();
    }

    public String toString() {
        return "{name: " + this.mName + ", description: " + this.mDescription + ", dataType: " + this.mDataType + ", cardinality: " + this.mCardinality + ", schemaType: " + this.mSchemaType + ", stringIndexingConfigParcel: " + this.mStringIndexingConfigParcel + ", documentIndexingConfigParcel: " + this.mDocumentIndexingConfigParcel + ", integerIndexingConfigParcel: " + this.mIntegerIndexingConfigParcel + ", joinableConfigParcel: " + this.mJoinableConfigParcel + ", embeddingIndexingConfigParcel: null, isScoringEnabled: " + this.mScoringEnabled + "}";
    }
}
