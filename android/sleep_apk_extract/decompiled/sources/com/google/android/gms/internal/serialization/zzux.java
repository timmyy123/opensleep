package com.google.android.gms.internal.serialization;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/google/nest/platform/mesh/interaction/SubscriptionData;", "previous", "event", "Lcom/google/nest/platform/mesh/interaction/SubscribeTraitsEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.nest.platform.mesh.interaction.SubscriptionFlowKt$subscribeTraitsMultiple$2", f = "SubscriptionFlow.kt", l = {}, m = "invokeSuspend")
final class zzux extends SuspendLambda implements Function3 {
    /* synthetic */ Object zza;
    /* synthetic */ Object zzb;

    public zzux(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        zzux zzuxVar = new zzux((Continuation) obj3);
        zzuxVar.zza = (SubscriptionData) obj;
        zzuxVar.zzb = (SubscribeTraitsEvent) obj2;
        return zzuxVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws SubscriptionException {
        Set setKeySet;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        SubscriptionData subscriptionData = (SubscriptionData) this.zza;
        SubscribeTraitsEvent subscribeTraitsEvent = (SubscribeTraitsEvent) this.zzb;
        int remainingUnprimedSubscriptions = subscriptionData.getRemainingUnprimedSubscriptions();
        Map mutableMap = MapsKt.toMutableMap(subscriptionData.getObjectsMap());
        if (subscribeTraitsEvent instanceof TraitChangedEvent) {
            TraitChangedEvent traitChangedEvent = (TraitChangedEvent) subscribeTraitsEvent;
            String id = traitChangedEvent.getZza().getId();
            Object linkedHashMap = mutableMap.get(id);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                mutableMap.put(id, linkedHashMap);
            }
            ((Map) linkedHashMap).putAll(traitChangedEvent.getZza().getContents());
        } else if (subscribeTraitsEvent instanceof TraitsDeletedEvent) {
            TraitsDeletedEvent traitsDeletedEvent = (TraitsDeletedEvent) subscribeTraitsEvent;
            Map map = (Map) mutableMap.get(traitsDeletedEvent.getZza().getId());
            if (map != null && (setKeySet = map.keySet()) != null) {
                Boxing.boxBoolean(setKeySet.removeAll(CollectionsKt.toSet(traitsDeletedEvent.getZzb())));
            }
        } else if (subscribeTraitsEvent instanceof ObjectDeletedEvent) {
            Boxing.boxBoolean(mutableMap.keySet().removeAll(CollectionsKt.toSet(((ObjectDeletedEvent) subscribeTraitsEvent).getZza())));
        } else if (subscribeTraitsEvent instanceof PrimingCompleteEvent) {
            Boxing.boxInt(remainingUnprimedSubscriptions);
            remainingUnprimedSubscriptions--;
        } else {
            if (!(subscribeTraitsEvent instanceof SubscriptionStateChangedEvent)) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            if (((SubscriptionStateChangedEvent) subscribeTraitsEvent).getZza() == zzvd.zzd) {
                throw new SubscriptionException("Permissions updated; subscription may be missing access.", null, 2, null);
            }
        }
        return new SubscriptionData(remainingUnprimedSubscriptions, mutableMap);
    }
}
