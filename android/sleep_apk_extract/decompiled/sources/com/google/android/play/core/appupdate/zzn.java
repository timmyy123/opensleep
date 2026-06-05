package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes4.dex */
final class zzn extends com.google.android.play.core.appupdate.internal.zzn {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzr zzrVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, String str) {
        super(taskCompletionSource);
        this.zzc = zzrVar;
        this.zza = taskCompletionSource2;
        this.zzb = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.appupdate.internal.zzf] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        try {
            this.zzc.zza.zze().zzc(this.zzc.zzd, zzr.zzi(), new zzp(this.zzc, this.zza));
        } catch (RemoteException e) {
            zzr.zzb.zzc(e, "completeUpdate(%s)", this.zzb);
            this.zza.trySetException(new RuntimeException(e));
        }
    }
}
