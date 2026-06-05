package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzvf, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/TraitsDeletedEvent;", "Lcom/google/nest/platform/mesh/interaction/SubscribeTraitsEvent;", "objectData", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "traitIds", "", "", "<init>", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/List;)V", "getObjectData", "()Lcom/google/nest/platform/mesh/serialization/ObjectData;", "getTraitIds", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TraitsDeletedEvent implements SubscribeTraitsEvent {
    private final ObjectData zza;
    private final List zzb;

    public TraitsDeletedEvent(ObjectData objectData, List list) {
        objectData.getClass();
        list.getClass();
        this.zza = objectData;
        this.zzb = list;
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final ObjectData getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getZzb() {
        return this.zzb;
    }
}
