package com.google.android.gms.internal.serialization;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/google/nest/platform/mesh/interaction/EventFlowKt$subscribeEvents$1$eventCallback$1", "Lcom/google/nest/platform/mesh/interaction/EventSubscriber;", "onSimpleEvent", "", "handle", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "objectId", "", "events", "", "Lcom/google/nest/platform/mesh/interaction/EventPayload;", "onSimpleEvent-17BgtZs", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zztr {
    final /* synthetic */ ProducerScope zza;

    public zztr(ProducerScope producerScope) {
        this.zza = producerScope;
    }

    public final void zza(String str, String str2, List list) {
        Throwable thM2586exceptionOrNullimpl;
        str.getClass();
        str2.getClass();
        list.getClass();
        Object objTrySendBlocking = ChannelsKt.trySendBlocking(this.zza, new OnSimpleEvent(str, str2, list, null));
        if ((objTrySendBlocking instanceof ChannelResult.Failed) && (thM2586exceptionOrNullimpl = ChannelResult.m2586exceptionOrNullimpl(objTrySendBlocking)) != null && !(thM2586exceptionOrNullimpl instanceof CancellationException)) {
            throw thM2586exceptionOrNullimpl;
        }
    }
}
