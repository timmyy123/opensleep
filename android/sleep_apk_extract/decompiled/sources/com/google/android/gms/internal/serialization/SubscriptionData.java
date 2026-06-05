package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzum, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012*\u0010\u0004\u001a&\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\t\u0012\u0004\u0012\u00020\n0\b0\u0005j\u0002`\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J-\u0010\u0013\u001a&\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\t\u0012\u0004\u0012\u00020\n0\b0\u0005j\u0002`\u000bHÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032,\b\u0002\u0010\u0004\u001a&\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\t\u0012\u0004\u0012\u00020\n0\b0\u0005j\u0002`\u000bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR5\u0010\u0004\u001a&\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\t\u0012\u0004\u0012\u00020\n0\b0\u0005j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/SubscriptionData;", "", "remainingUnprimedSubscriptions", "", "objectsMap", "", "", "Lcom/google/nest/platform/mesh/serialization/ObjectId;", "", "Lcom/google/nest/platform/mesh/serialization/TraitId;", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "Lcom/google/nest/platform/mesh/interaction/ObjectsMap;", "<init>", "(ILjava/util/Map;)V", "getRemainingUnprimedSubscriptions", "()I", "getObjectsMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class SubscriptionData {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final int remainingUnprimedSubscriptions;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final Map objectsMap;

    public SubscriptionData(int i, Map map) {
        map.getClass();
        this.remainingUnprimedSubscriptions = i;
        this.objectsMap = map;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionData)) {
            return false;
        }
        SubscriptionData subscriptionData = (SubscriptionData) other;
        return this.remainingUnprimedSubscriptions == subscriptionData.remainingUnprimedSubscriptions && Intrinsics.areEqual(this.objectsMap, subscriptionData.objectsMap);
    }

    public final int hashCode() {
        return this.objectsMap.hashCode() + (Integer.hashCode(this.remainingUnprimedSubscriptions) * 31);
    }

    public final String toString() {
        int i = this.remainingUnprimedSubscriptions;
        int length = String.valueOf(i).length();
        Map map = this.objectsMap;
        StringBuilder sb = new StringBuilder(length + 61 + String.valueOf(map).length() + 1);
        sb.append("SubscriptionData(remainingUnprimedSubscriptions=");
        sb.append(i);
        sb.append(", objectsMap=");
        sb.append(map);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final int getRemainingUnprimedSubscriptions() {
        return this.remainingUnprimedSubscriptions;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final Map getObjectsMap() {
        return this.objectsMap;
    }
}
