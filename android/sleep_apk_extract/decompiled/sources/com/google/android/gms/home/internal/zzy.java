package com.google.android.gms.home.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.serialization.zzaef;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "clientImpl", "Lcom/google/android/gms/home/internal/InteractionClientImpl;", "subscriberCallback", "Landroid/os/IInterface;", "statusCallback", "Lcom/google/android/gms/common/api/internal/IStatusCallback$Stub;", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzy extends Lambda implements Function3 {
    final /* synthetic */ zzaef zza;
    final /* synthetic */ InternalInteractionClient zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(zzaef zzaefVar, InternalInteractionClient internalInteractionClient) {
        super(3);
        this.zza = zzaefVar;
        this.zzb = internalInteractionClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        InteractionClientImpl interactionClientImpl = (InteractionClientImpl) obj;
        IInterface iInterface = (IInterface) obj2;
        IStatusCallback.Stub stub = (IStatusCallback.Stub) obj3;
        interactionClientImpl.getClass();
        iInterface.getClass();
        stub.getClass();
        com.google.android.gms.internal.serialization.zzak zzakVar = new com.google.android.gms.internal.serialization.zzak();
        zzakVar.zza(stub);
        zzakVar.zzb((com.google.android.gms.internal.serialization.zzax) iInterface);
        zzakVar.zzc(this.zza);
        zzakVar.zzd(this.zzb.zzP());
        ((com.google.android.gms.internal.serialization.zzba) interactionClientImpl.getService()).zzj(zzakVar.zze());
        return Unit.INSTANCE;
    }
}
