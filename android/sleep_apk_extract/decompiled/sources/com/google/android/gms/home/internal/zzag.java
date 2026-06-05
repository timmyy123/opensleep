package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.serialization.ReceiveHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroid/os/IInterface;", "receiveHandle", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "listenerHolder", "Lcom/google/android/gms/common/api/internal/ListenerHolder;", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;", "invoke-n_T_TKg", "(Ljava/lang/String;Lcom/google/android/gms/common/api/internal/ListenerHolder;)Landroid/os/IInterface;"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzag extends Lambda implements Function2 {
    public static final zzag zza = new zzag();

    public zzag() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        String zza2 = ((ReceiveHandle) obj).getZza();
        ListenerHolder listenerHolder = (ListenerHolder) obj2;
        zza2.getClass();
        listenerHolder.getClass();
        return new zzaf(listenerHolder, zza2);
    }
}
