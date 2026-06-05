package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzug, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/ObjectDeletedEvent;", "Lcom/google/nest/platform/mesh/interaction/SubscribeTraitsEvent;", "deletedObjects", "", "", "<init>", "(Ljava/util/List;)V", "getDeletedObjects", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ObjectDeletedEvent implements SubscribeTraitsEvent {
    private final List zza;

    public ObjectDeletedEvent(List list) {
        list.getClass();
        this.zza = list;
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final List getZza() {
        return this.zza;
    }
}
