package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0006\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u001a&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\f\u001a,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f\u001a\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0018"}, d2 = {"eventLogger", "Lcom/google/nest/platform/mesh/api/logger/Logger;", "getEventLogger", "()Lcom/google/nest/platform/mesh/api/logger/Logger;", "subscribeEvents", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/nest/platform/mesh/interaction/ObjectEventPayload;", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "objectFilter", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "eventFilter", "", "", "subscribeEventForObject", "objectId", "eventId", "subscribeEventsForObject", "eventIds", "", "subscribeEventForObjects", "objectIds", "subscribeEventsForObjects", "subscribeAllEventsForObject", "subscribeAllEventsForObjects", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zztt {
    private static final zzru zza = zzrv.zza("EventFlow");

    public static final zzru zza() {
        return zza;
    }

    public static /* synthetic */ Flow zzb(InteractionClient interactionClient, FilterQuery filterQuery, List list, int i, Object obj) {
        List listEmptyList = CollectionsKt.emptyList();
        interactionClient.getClass();
        filterQuery.getClass();
        listEmptyList.getClass();
        return FlowKt.flow(new zztp(FlowKt.callbackFlow(new zzts(interactionClient, filterQuery, listEmptyList, null)), null));
    }
}
