package com.google.home.matter.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001d\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006 "}, d2 = {"Lcom/google/home/matter/serialization/ScopedCommandId;", "", "Lcom/google/home/matter/serialization/ClusterId;", "cluster", "Lkotlin/UInt;", "command", "<init>", "(Lcom/google/home/matter/serialization/ClusterId;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/home/matter/serialization/ClusterId;", "getCluster", "()Lcom/google/home/matter/serialization/ClusterId;", "I", "getCommand-pVg5ArA", "vendor", "getVendor-pVg5ArA", "id", "getId-pVg5ArA", "uddmId", "getUddmId-pVg5ArA", "traitId", "Ljava/lang/String;", "getTraitId", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ScopedCommandId {
    private final ClusterId cluster;
    private final int command;
    private final int id;
    private final String traitId;
    private final int uddmId;
    private final int vendor;

    private ScopedCommandId(ClusterId clusterId, int i) {
        clusterId.getClass();
        this.cluster = clusterId;
        this.command = i;
        int iM2389constructorimpl = UInt.m2389constructorimpl((char) UInt.m2389constructorimpl(i >>> 16));
        this.vendor = iM2389constructorimpl;
        int iM2389constructorimpl2 = UInt.m2389constructorimpl((char) i);
        this.id = iM2389constructorimpl2;
        this.uddmId = UInt.m2389constructorimpl(UInt.m2389constructorimpl(iM2389constructorimpl << 8) | iM2389constructorimpl2);
        String traitId = clusterId.getTraitId();
        String strM534hex8WZ4Q5Ns = ClusterIdKt.m534hex8WZ4Q5Ns(i);
        this.traitId = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(traitId).length() + 1 + String.valueOf(strM534hex8WZ4Q5Ns).length()), traitId, ".", strM534hex8WZ4Q5Ns);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScopedCommandId)) {
            return false;
        }
        ScopedCommandId scopedCommandId = (ScopedCommandId) other;
        return Intrinsics.areEqual(this.cluster, scopedCommandId.cluster) && this.command == scopedCommandId.command;
    }

    public final ClusterId getCluster() {
        return this.cluster;
    }

    public final String getTraitId() {
        return this.traitId;
    }

    /* JADX INFO: renamed from: getUddmId-pVg5ArA, reason: not valid java name and from getter */
    public final int getUddmId() {
        return this.uddmId;
    }

    public int hashCode() {
        return UInt.m2391hashCodeimpl(this.command) + (this.cluster.hashCode() * 31);
    }

    public String toString() {
        return this.traitId;
    }

    public /* synthetic */ ScopedCommandId(ClusterId clusterId, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clusterId, i);
    }
}
