package com.squareup.kotlinpoet;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/squareup/kotlinpoet/Import;", "", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "alias", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "", "compareTo", "(Lcom/squareup/kotlinpoet/Import;)I", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQualifiedName", "getAlias", "importString", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Import implements Comparable<Import> {
    private final String alias;
    private final String importString;
    private final String qualifiedName;

    public Import(String str, String str2) {
        str.getClass();
        this.qualifiedName = str;
        this.alias = str2;
        StringBuilder sb = new StringBuilder();
        sb.append(UtilKt.escapeSegmentsIfNecessary$default(str, (char) 0, 1, null));
        if (str2 != null) {
            sb.append(" as " + UtilKt.escapeIfNecessary$default(str2, false, 1, null));
        }
        this.importString = sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Import other) {
        other.getClass();
        return this.importString.compareTo(other.importString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Import)) {
            return false;
        }
        Import r5 = (Import) other;
        return Intrinsics.areEqual(this.qualifiedName, r5.qualifiedName) && Intrinsics.areEqual(this.alias, r5.alias);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public int hashCode() {
        int iHashCode = this.qualifiedName.hashCode() * 31;
        String str = this.alias;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getImportString() {
        return this.importString;
    }

    public /* synthetic */ Import(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
