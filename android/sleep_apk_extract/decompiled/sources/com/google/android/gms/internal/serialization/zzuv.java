package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"com/google/nest/platform/mesh/interaction/SubscriptionFlowKt$subscribeTraitsMultiple$1$1$subscriber$1", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;", "onTraitsChanged", "", "handle", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "objectData", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "onTraitsChanged-n_T_TKg", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/ObjectData;)V", "onTraitsDeleted", "traitIds", "", "", "onTraitsDeleted-17BgtZs", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/List;)V", "onObjectDeleted", "deletedObjects", "onObjectDeleted-n_T_TKg", "(Ljava/lang/String;Ljava/util/List;)V", "onPrimingComplete", "onPrimingComplete-duiV754", "(Ljava/lang/String;)V", "onSubscriptionStateChanged", "type", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber$SubscriptionStateChangeType;", "onSubscriptionStateChanged-n_T_TKg", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/interaction/TraitSubscriber$SubscriptionStateChangeType;)V", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzuv implements TraitSubscriber {
    final /* synthetic */ ProducerScope zza;

    public zzuv(ProducerScope producerScope) {
        this.zza = producerScope;
    }

    @Override // com.google.android.gms.internal.serialization.TraitSubscriber
    public final void zza(String str, ObjectData objectData) throws Throwable {
        str.getClass();
        objectData.getClass();
        zzuz.zzh(this.zza, new TraitChangedEvent(objectData));
    }

    @Override // com.google.android.gms.internal.serialization.TraitSubscriber
    public final void zzb(String str, ObjectData objectData, List list) throws Throwable {
        str.getClass();
        objectData.getClass();
        list.getClass();
        zzuz.zzh(this.zza, new TraitsDeletedEvent(objectData, list));
    }

    @Override // com.google.android.gms.internal.serialization.TraitSubscriber
    public final void zzc(String str, List list) throws Throwable {
        str.getClass();
        list.getClass();
        zzuz.zzh(this.zza, new ObjectDeletedEvent(list));
    }

    @Override // com.google.android.gms.internal.serialization.TraitSubscriber
    public final void zzd(String str) throws Throwable {
        str.getClass();
        zzuz.zzh(this.zza, PrimingCompleteEvent.zza);
    }

    @Override // com.google.android.gms.internal.serialization.TraitSubscriber
    public final void zze(String str, zzvd zzvdVar) throws Throwable {
        str.getClass();
        zzvdVar.getClass();
        zzuz.zzh(this.zza, new SubscriptionStateChangedEvent(zzvdVar));
    }
}
