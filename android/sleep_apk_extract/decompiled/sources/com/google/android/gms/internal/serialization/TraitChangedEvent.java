package com.google.android.gms.internal.serialization;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzvc, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/TraitChangedEvent;", "Lcom/google/nest/platform/mesh/interaction/SubscribeTraitsEvent;", "objectData", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "<init>", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;)V", "getObjectData", "()Lcom/google/nest/platform/mesh/serialization/ObjectData;", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TraitChangedEvent implements SubscribeTraitsEvent {
    private final ObjectData zza;

    public TraitChangedEvent(ObjectData objectData) {
        objectData.getClass();
        this.zza = objectData;
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final ObjectData getZza() {
        return this.zza;
    }
}
