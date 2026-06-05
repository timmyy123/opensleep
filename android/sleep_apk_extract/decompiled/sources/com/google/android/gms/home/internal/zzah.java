package com.google.android.gms.home.internal;

import android.os.IInterface;
import com.google.android.gms.internal.serialization.zzaeh;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "clientImpl", "Lcom/google/android/gms/home/internal/InteractionClientImpl;", "subscriberCallback", "Landroid/os/IInterface;", "resultCallback", "Lcom/google/android/gms/home/interaction/internal/IRegisterSubscriberCallback$Stub;", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzah extends Lambda implements Function3 {
    final /* synthetic */ zzaeh zza;
    final /* synthetic */ InternalInteractionClient zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzah(zzaeh zzaehVar, InternalInteractionClient internalInteractionClient) {
        super(3);
        this.zza = zzaehVar;
        this.zzb = internalInteractionClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        InteractionClientImpl interactionClientImpl = (InteractionClientImpl) obj;
        IInterface iInterface = (IInterface) obj2;
        com.google.android.gms.internal.serialization.zzbf zzbfVar = (com.google.android.gms.internal.serialization.zzbf) obj3;
        interactionClientImpl.getClass();
        iInterface.getClass();
        zzbfVar.getClass();
        com.google.android.gms.internal.serialization.zzu zzuVar = new com.google.android.gms.internal.serialization.zzu();
        zzuVar.zza(zzbfVar);
        zzuVar.zzb((com.google.android.gms.internal.serialization.zzbp) iInterface);
        zzuVar.zzc(this.zza);
        zzuVar.zzd(this.zzb.zzP());
        ((com.google.android.gms.internal.serialization.zzba) interactionClientImpl.getService()).zzg(zzuVar.zze());
        return Unit.INSTANCE;
    }
}
