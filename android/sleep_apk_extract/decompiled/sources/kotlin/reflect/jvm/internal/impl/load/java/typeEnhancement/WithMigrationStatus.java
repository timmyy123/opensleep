package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class WithMigrationStatus<T> {
    private final boolean isForWarningOnly;
    private final T qualifier;

    public /* synthetic */ WithMigrationStatus(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WithMigrationStatus copy$default(WithMigrationStatus withMigrationStatus, Object obj, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = withMigrationStatus.qualifier;
        }
        if ((i & 2) != 0) {
            z = withMigrationStatus.isForWarningOnly;
        }
        return withMigrationStatus.copy(obj, z);
    }

    public final WithMigrationStatus<T> copy(T t, boolean z) {
        return new WithMigrationStatus<>(t, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WithMigrationStatus)) {
            return false;
        }
        WithMigrationStatus withMigrationStatus = (WithMigrationStatus) obj;
        return Intrinsics.areEqual(this.qualifier, withMigrationStatus.qualifier) && this.isForWarningOnly == withMigrationStatus.isForWarningOnly;
    }

    public final T getQualifier() {
        return this.qualifier;
    }

    public int hashCode() {
        T t = this.qualifier;
        return Boolean.hashCode(this.isForWarningOnly) + ((t == null ? 0 : t.hashCode()) * 31);
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WithMigrationStatus(qualifier=");
        sb.append(this.qualifier);
        sb.append(", isForWarningOnly=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.isForWarningOnly, ')');
    }

    public WithMigrationStatus(T t, boolean z) {
        this.qualifier = t;
        this.isForWarningOnly = z;
    }
}
