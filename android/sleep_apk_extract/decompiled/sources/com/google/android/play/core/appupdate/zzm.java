package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes4.dex */
final class zzm extends com.google.android.play.core.appupdate.internal.zzn {
    final /* synthetic */ String zza;
    final /* synthetic */ TaskCompletionSource zzb;
    final /* synthetic */ zzr zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzc = zzrVar;
        this.zza = str;
        this.zzb = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.appupdate.internal.zzf] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        try {
            ?? Zze = this.zzc.zza.zze();
            zzr zzrVar = this.zzc;
            Zze.zzd(zzrVar.zzd, zzr.zzb(zzrVar, this.zza), new zzq(this.zzc, this.zzb, this.zza));
        } catch (RemoteException e) {
            zzr.zzb.zzc(e, "requestUpdateInfo(%s)", this.zza);
            this.zzb.trySetException(new RuntimeException(e));
        }
    }
}
