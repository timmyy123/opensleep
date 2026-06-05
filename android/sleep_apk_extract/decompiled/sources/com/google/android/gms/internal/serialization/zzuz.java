package com.google.android.gms.internal.serialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*&\u0012\b\u0012\u00060\u0001j\u0002`\n\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b0\tj\u0002`\u0011H\u0002\u001a$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0013*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f\u001a0\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0013*\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u001a%\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e2\u0006\u0010\u001f\u001a\u0002H\u001dH\u0002¢\u0006\u0002\u0010 \"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007*D\b\u0002\u0010\b\"\u001a\u0012\u0004\u0012\u0002`\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b0\t2\"\u0012\b\u0012\u00060\u0001j\u0002`\n\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b0\t¨\u0006!"}, d2 = {"TAG", "", "getTAG", "()Ljava/lang/String;", "logger", "Lcom/google/nest/platform/mesh/api/logger/Logger;", "getLogger", "()Lcom/google/nest/platform/mesh/api/logger/Logger;", "ObjectsMap", "", "Lcom/google/nest/platform/mesh/serialization/ObjectId;", "", "Lcom/google/nest/platform/mesh/serialization/TraitId;", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "toObjectDataList", "", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "Lcom/google/nest/platform/mesh/interaction/ObjectsMap;", "subscribeTraitsMultiple", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "subscriptionParamList", "Lcom/google/nest/platform/mesh/interaction/SubscriptionParams;", "subscribeTraits", "objectFilter", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "traitFilter", "sendBlocking", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzuz {
    private static final zzru zzb = zzrv.zza("SubscriptionFlow");

    public static final zzru zza() {
        return zzb;
    }

    public static final Flow zzb(InteractionClient interactionClient, List list) {
        interactionClient.getClass();
        list.getClass();
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(FlowKt.callbackFlow(new zzuw(interactionClient, (SubscriptionParams) it.next(), null)));
        }
        return new zzut(FlowKt.conflate(new zzuq(FlowKt__ErrorsKt.retry$default(FlowKt.drop(FlowKt.runningFold(FlowKt.merge(arrayList), new SubscriptionData(list.size(), MapsKt.emptyMap()), new zzux(null)), 1), 0L, new zzuy(null), 1, null))));
    }

    public static final Flow zzc(InteractionClient interactionClient, FilterQuery filterQuery, List list) {
        interactionClient.getClass();
        filterQuery.getClass();
        list.getClass();
        return zzb(interactionClient, CollectionsKt.listOf(new SubscriptionParams(filterQuery, list)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List zzg(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new ObjectData((String) entry.getKey(), MapsKt.toMap((Map) entry.getValue()), false));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzh(SendChannel sendChannel, Object obj) throws Throwable {
        try {
            ChannelResult.m2588getOrThrowimpl(ChannelsKt.trySendBlocking(sendChannel, obj));
        } catch (CancellationException unused) {
        }
    }
}
