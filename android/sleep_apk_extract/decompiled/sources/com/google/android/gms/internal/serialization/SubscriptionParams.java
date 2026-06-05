package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzva, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/SubscriptionParams;", "", "objectFilter", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "traitFilter", "", "", "<init>", "(Lcom/google/nest/platform/mesh/interaction/FilterQuery;Ljava/util/List;)V", "getObjectFilter", "()Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "getTraitFilter", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class SubscriptionParams {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final FilterQuery objectFilter;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final List traitFilter;

    public /* synthetic */ SubscriptionParams(FilterQuery filterQuery, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new FilterQuery(null, null, 3, null) : filterQuery, CollectionsKt.emptyList());
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionParams)) {
            return false;
        }
        SubscriptionParams subscriptionParams = (SubscriptionParams) other;
        return Intrinsics.areEqual(this.objectFilter, subscriptionParams.objectFilter) && Intrinsics.areEqual(this.traitFilter, subscriptionParams.traitFilter);
    }

    public final int hashCode() {
        return this.traitFilter.hashCode() + (this.objectFilter.hashCode() * 31);
    }

    public final String toString() {
        FilterQuery filterQuery = this.objectFilter;
        int length = String.valueOf(filterQuery).length();
        List list = this.traitFilter;
        StringBuilder sb = new StringBuilder(length + 46 + String.valueOf(list).length() + 1);
        sb.append("SubscriptionParams(objectFilter=");
        sb.append(filterQuery);
        sb.append(", traitFilter=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final FilterQuery getObjectFilter() {
        return this.objectFilter;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getTraitFilter() {
        return this.traitFilter;
    }

    public SubscriptionParams(FilterQuery filterQuery, List list) {
        filterQuery.getClass();
        list.getClass();
        this.objectFilter = filterQuery;
        this.traitFilter = list;
    }
}
