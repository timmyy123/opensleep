package kotlin.reflect.jvm.internal.impl.load.java;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.WithMigrationStatus;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;
    private final WithMigrationStatus<NullabilityQualifier> nullabilityQualifier;
    private final boolean preferQualifierOverBound;
    private final boolean preferQualifierOverSupertype;
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    public /* synthetic */ JavaDefaultQualifiers(WithMigrationStatus withMigrationStatus, Collection collection, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(withMigrationStatus, collection, (i & 4) != 0 ? withMigrationStatus.getQualifier() == NullabilityQualifier.NOT_NULL : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, WithMigrationStatus withMigrationStatus, Collection collection, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            withMigrationStatus = javaDefaultQualifiers.nullabilityQualifier;
        }
        if ((i & 2) != 0) {
            collection = javaDefaultQualifiers.qualifierApplicabilityTypes;
        }
        if ((i & 4) != 0) {
            z = javaDefaultQualifiers.definitelyNotNull;
        }
        if ((i & 8) != 0) {
            z2 = javaDefaultQualifiers.preferQualifierOverBound;
        }
        if ((i & 16) != 0) {
            z3 = javaDefaultQualifiers.preferQualifierOverSupertype;
        }
        boolean z4 = z3;
        boolean z5 = z;
        return javaDefaultQualifiers.copy(withMigrationStatus, collection, z5, z2, z4);
    }

    public final JavaDefaultQualifiers copy(WithMigrationStatus<NullabilityQualifier> withMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2, boolean z3) {
        withMigrationStatus.getClass();
        collection.getClass();
        return new JavaDefaultQualifiers(withMigrationStatus, collection, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        return Intrinsics.areEqual(this.nullabilityQualifier, javaDefaultQualifiers.nullabilityQualifier) && Intrinsics.areEqual(this.qualifierApplicabilityTypes, javaDefaultQualifiers.qualifierApplicabilityTypes) && this.definitelyNotNull == javaDefaultQualifiers.definitelyNotNull && this.preferQualifierOverBound == javaDefaultQualifiers.preferQualifierOverBound && this.preferQualifierOverSupertype == javaDefaultQualifiers.preferQualifierOverSupertype;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final WithMigrationStatus<NullabilityQualifier> getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    public final boolean getPreferQualifierOverSupertype() {
        return this.preferQualifierOverSupertype;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    public int hashCode() {
        return Boolean.hashCode(this.preferQualifierOverSupertype) + FileInsert$$ExternalSyntheticOutline0.m(this.preferQualifierOverBound, FileInsert$$ExternalSyntheticOutline0.m(this.definitelyNotNull, (this.qualifierApplicabilityTypes.hashCode() + (this.nullabilityQualifier.hashCode() * 31)) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JavaDefaultQualifiers(nullabilityQualifier=");
        sb.append(this.nullabilityQualifier);
        sb.append(", qualifierApplicabilityTypes=");
        sb.append(this.qualifierApplicabilityTypes);
        sb.append(", definitelyNotNull=");
        sb.append(this.definitelyNotNull);
        sb.append(", preferQualifierOverBound=");
        sb.append(this.preferQualifierOverBound);
        sb.append(", preferQualifierOverSupertype=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.preferQualifierOverSupertype, ')');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(WithMigrationStatus<NullabilityQualifier> withMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2, boolean z3) {
        withMigrationStatus.getClass();
        collection.getClass();
        this.nullabilityQualifier = withMigrationStatus;
        this.qualifierApplicabilityTypes = collection;
        this.definitelyNotNull = z;
        this.preferQualifierOverBound = z2;
        this.preferQualifierOverSupertype = z3;
    }
}
