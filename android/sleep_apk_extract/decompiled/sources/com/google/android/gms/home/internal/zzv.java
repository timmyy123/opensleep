package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.serialization.zzh;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/google/android/gms/home/internal/InternalInteractionClient$registerEventSubscriber$2$1", "Lcom/google/android/gms/home/interaction/internal/IEventCallback$Stub;", "onEvent", "", "data", "Lcom/google/android/gms/home/interaction/EventSubscriberNotificationParcelable;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzv extends com.google.android.gms.internal.serialization.zzaw {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ String zzb;

    public zzv(ListenerHolder listenerHolder, String str) {
        this.zza = listenerHolder;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.serialization.zzax
    public final void zze(zzh zzhVar) {
        zzhVar.getClass();
        this.zza.notifyListener(new zzu(zzhVar, this.zzb));
    }
}
