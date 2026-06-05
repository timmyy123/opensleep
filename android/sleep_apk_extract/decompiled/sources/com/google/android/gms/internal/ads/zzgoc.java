package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class zzgoc implements zzgmw {
    private final zzgkz zza;
    private final ExecutorService zzb;
    private final zzgqh zzc;

    public zzgoc(zzgkz zzgkzVar, ExecutorService executorService, zzgqh zzgqhVar) {
        this.zza = zzgkzVar;
        this.zzb = executorService;
        this.zzc = zzgqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zza() {
        return zzhbw.zza(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzd = zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgob
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzf();
            }
        }, this.zzb);
        this.zzc.zze(15302, listenableFutureZzd);
        return listenableFutureZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zzc(final zzgfq zzgfqVar, final byte[] bArr, final byte[] bArr2) {
        ListenableFuture listenableFutureZzd = zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgoa
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zzi(zzgfqVar, bArr, bArr2);
                return null;
            }
        }, this.zzb);
        this.zzc.zze(15321, listenableFutureZzd);
        return listenableFutureZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zzd(final zzgfq zzgfqVar, final byte[] bArr) {
        ListenableFuture listenableFutureZzd = zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgnz
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zzh(zzgfqVar, bArr);
                return null;
            }
        }, this.zzb);
        this.zzc.zze(15305, listenableFutureZzd);
        return listenableFutureZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgmw
    public final ListenableFuture zze() {
        ListenableFuture listenableFutureZzd = zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgny
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzg();
            }
        }, this.zzb);
        this.zzc.zze(15314, listenableFutureZzd);
        return listenableFutureZzd;
    }

    public final /* synthetic */ zzgfq zzf() {
        zzgfq zzgfqVarZzc = this.zza.zzc(1);
        return zzgfqVarZzc == null ? zzgfq.zzh() : zzgfqVarZzc;
    }

    public final /* synthetic */ zzfyp zzg() {
        return this.zza.zzb(1);
    }

    public final /* synthetic */ Void zzh(zzgfq zzgfqVar, byte[] bArr) {
        this.zza.zza(zzgfqVar, null, bArr);
        return null;
    }

    public final /* synthetic */ Void zzi(zzgfq zzgfqVar, byte[] bArr, byte[] bArr2) {
        this.zza.zza(zzgfqVar, bArr, bArr2);
        return null;
    }
}
