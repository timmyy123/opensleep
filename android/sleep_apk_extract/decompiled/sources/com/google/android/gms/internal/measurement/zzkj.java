package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class zzkj extends zzkr {
    private final TaskCompletionSource zza;

    public /* synthetic */ zzkj(TaskCompletionSource taskCompletionSource, byte[] bArr) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzc(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzd(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zze(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzf(Status status, @Nullable zzjh zzjhVar) {
        TaskUtil.setResultOrApiException(status, zzjhVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzg(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzh(Status status, @Nullable zzjl zzjlVar) {
        TaskUtil.setResultOrApiException(status, zzjlVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzi(Status status, @Nullable zzjj zzjjVar) {
        TaskUtil.setResultOrApiException(status, zzjjVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzj(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzk(Status status, @Nullable zzjo zzjoVar) {
        TaskUtil.setResultOrApiException(status, zzjoVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzl(Status status, @Nullable zzjh zzjhVar) {
        TaskUtil.setResultOrApiException(status, zzjhVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzm(Status status, long j) {
        TaskUtil.setResultOrApiException(status, null, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzn(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzo(Status status, @Nullable zzjs zzjsVar) {
        TaskUtil.setResultOrApiException(status, zzjsVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzp(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final void zzq(Status status, long j) {
        TaskUtil.setResultOrApiException(status, Long.valueOf(j), this.zza);
    }
}
