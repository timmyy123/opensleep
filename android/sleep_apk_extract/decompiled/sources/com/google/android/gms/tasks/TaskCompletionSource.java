package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes4.dex */
public class TaskCompletionSource<TResult> {
    private final zzw zza = new zzw();

    public Task<TResult> getTask() {
        return this.zza;
    }

    public void setException(Exception exc) {
        this.zza.zzc(exc);
    }

    public void setResult(TResult tresult) {
        this.zza.zza(tresult);
    }

    public boolean trySetException(Exception exc) {
        return this.zza.zzd(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zza.zzb(tresult);
    }
}
