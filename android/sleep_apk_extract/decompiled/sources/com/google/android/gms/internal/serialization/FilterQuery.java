package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzua, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\u0004H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "", "objectIds", "", "", "matchers", "Lcom/google/nest/platform/mesh/interaction/FilterMatcher;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getObjectIds", "()Ljava/util/List;", "getMatchers", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilterQuery {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final List objectIds;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final List matchers;

    public /* synthetic */ FilterQuery(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList = (i & 1) != 0 ? CollectionsKt.emptyList() : null;
        list2 = (i & 2) != 0 ? CollectionsKt.emptyList() : list2;
        listEmptyList.getClass();
        list2.getClass();
        this.objectIds = listEmptyList;
        this.matchers = list2;
    }

    public final String toString() {
        List list = this.objectIds;
        int length = String.valueOf(list).length();
        List list2 = this.matchers;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(list2).length());
        sb.append("FilterQuery(objectIds=");
        sb.append(list);
        sb.append(", matchers=");
        sb.append(list2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final List getObjectIds() {
        return this.objectIds;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getMatchers() {
        return this.matchers;
    }
}
