package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzve, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;", "", "onTraitsChanged", "", "handle", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "objectData", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "onTraitsChanged-n_T_TKg", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/ObjectData;)V", "onTraitsDeleted", "traitIds", "", "", "onTraitsDeleted-17BgtZs", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/List;)V", "onObjectDeleted", "deletedObjects", "onObjectDeleted-n_T_TKg", "(Ljava/lang/String;Ljava/util/List;)V", "onPrimingComplete", "onPrimingComplete-duiV754", "(Ljava/lang/String;)V", "onSubscriptionStateChanged", "type", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber$SubscriptionStateChangeType;", "onSubscriptionStateChanged-n_T_TKg", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/interaction/TraitSubscriber$SubscriptionStateChangeType;)V", "SubscriptionStateChangeType", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TraitSubscriber {
    void zza(String str, ObjectData objectData);

    void zzb(String str, ObjectData objectData, List list);

    void zzc(String str, List list);

    void zzd(String str);

    void zze(String str, zzvd zzvdVar);
}
