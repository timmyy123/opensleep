package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/google/home/automation/Attribute;", "T", "", "", "clusterId", "Lkotlin/UInt;", "tagId", "<init>", "(Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/String;", "getClusterId", "I", "getTagId-pVg5ArA", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Attribute<T> {
    private final String clusterId;
    private final int tagId;

    private Attribute(String str, int i) {
        str.getClass();
        this.clusterId = str;
        this.tagId = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) other;
        return Intrinsics.areEqual(this.clusterId, attribute.clusterId) && this.tagId == attribute.tagId;
    }

    public int hashCode() {
        return UInt.m2391hashCodeimpl(this.tagId) + (this.clusterId.hashCode() * 31);
    }

    public String toString() {
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.tagId);
        String str = this.clusterId;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(strM2392toStringimpl).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Attribute(clusterId=", str, ", tagId=", strM2392toStringimpl);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ Attribute(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
