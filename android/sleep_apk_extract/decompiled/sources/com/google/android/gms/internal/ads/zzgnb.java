package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class zzgnb implements zzgmw {
    private final zzget zza;
    private final zzget zzb;
    private final zzget zzc;
    private final zzget zzd;
    private final zzimo zze;
    private final zzimo zzf;
    private final File zzg;
    private final ExecutorService zzh;
    private final zzgqh zzi;

    public zzgnb(zzget zzgetVar, zzget zzgetVar2, zzimo zzimoVar, zzget zzgetVar3, zzget zzgetVar4, zzimo zzimoVar2, File file, ExecutorService executorService, zzgqh zzgqhVar) {
        this.zza = zzgetVar;
        this.zzc = zzgetVar2;
        this.zze = zzimoVar;
        this.zzb = zzgetVar3;
        this.zzd = zzgetVar4;
        this.zzf = zzimoVar2;
        this.zzg = file;
        this.zzh = executorService;
        this.zzi = zzgqhVar;
    }

    private final ListenableFuture zzj(byte[] bArr) {
        ListenableFuture listenableFutureZzc = this.zzd.zzc(bArr);
        this.zzi.zze(15305, listenableFutureZzc);
        return listenableFutureZzc;
    }

    private final ListenableFuture zzk(zzgfq zzgfqVar) {
        ListenableFuture listenableFutureZzc = this.zzb.zzc(zzgfqVar);
        this.zzi.zze(15303, listenableFutureZzc);
        return listenableFutureZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zza() {
        return zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgna
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new Boolean(this.zza.zzf());
            }
        }, this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzb = this.zza.zzb();
        this.zzi.zze(15302, listenableFutureZzb);
        return listenableFutureZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zzc(final zzgfq zzgfqVar, byte[] bArr, byte[] bArr2) {
        ListenableFuture listenableFutureZzc = ((zzget) this.zzf.zzb()).zzc(bArr);
        this.zzi.zze(15307, listenableFutureZzc);
        return (zzhbo) zzhbw.zzj(zzhbo.zzw(zzhbw.zzl(listenableFutureZzc, zzj(bArr2))), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgmz
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzi(zzgfqVar, (List) obj);
            }
        }, zzhcn.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final ListenableFuture zzd(final zzgfq zzgfqVar, byte[] bArr) {
        return (zzhbo) zzhbw.zzj(zzhbo.zzw(zzj(bArr)), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgmy
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzh(zzgfqVar, (Void) obj);
            }
        }, zzhcn.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgmw
    public final ListenableFuture zze() {
        zzhbo zzhboVar = (zzhbo) zzhbw.zzk(zzhbo.zzw(this.zza.zzb()), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgmx
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzg((zzgfq) obj);
            }
        }, zzhcn.zza());
        this.zzi.zze(15314, zzhboVar);
        return zzhboVar;
    }

    public final /* synthetic */ boolean zzf() {
        zzget zzgetVar;
        try {
            zzget zzgetVar2 = this.zzb;
            File fileZza = zzgetVar2.zza();
            if (!fileZza.exists()) {
                zzgetVar2.zza().delete();
                ((zzget) this.zzf.zzb()).zza().delete();
                this.zzd.zza().delete();
                return false;
            }
            File fileZza2 = ((zzget) this.zzf.zzb()).zza();
            File fileZza3 = ((zzget) this.zze.zzb()).zza();
            try {
                if (fileZza2.exists()) {
                    File parentFile = fileZza3.getParentFile();
                    if (parentFile != null) {
                        zzfyr.zze(parentFile);
                    }
                    zzgzt.zzb(fileZza3);
                    zzgzt.zzc(fileZza2, fileZza3);
                }
                File fileZza4 = this.zzd.zza();
                File fileZza5 = this.zzc.zza();
                try {
                    if (fileZza4.exists()) {
                        zzgzt.zzb(fileZza5);
                        zzgzt.zzc(fileZza4, fileZza5);
                    }
                    File fileZza6 = this.zza.zza();
                    try {
                        if (fileZza.exists()) {
                            zzgzt.zzb(fileZza6);
                            zzgzt.zzc(fileZza, fileZza6);
                        }
                        this.zzb.zza().delete();
                        ((zzget) this.zzf.zzb()).zza().delete();
                        this.zzd.zza().delete();
                        return true;
                    } catch (IOException | SecurityException e) {
                        this.zzi.zzd(15313, e);
                        zzgetVar = this.zzb;
                        zzgetVar.zza().delete();
                        ((zzget) this.zzf.zzb()).zza().delete();
                        this.zzd.zza().delete();
                        return false;
                    }
                } catch (IOException | SecurityException e2) {
                    this.zzi.zzd(15312, e2);
                    zzgetVar = this.zzb;
                }
            } catch (IOException e3) {
                e = e3;
                this.zzi.zzd(15311, e);
                zzgetVar = this.zzb;
                zzgetVar.zza().delete();
                ((zzget) this.zzf.zzb()).zza().delete();
                this.zzd.zza().delete();
                return false;
            } catch (SecurityException e4) {
                e = e4;
                this.zzi.zzd(15311, e);
                zzgetVar = this.zzb;
                zzgetVar.zza().delete();
                ((zzget) this.zzf.zzb()).zza().delete();
                this.zzd.zza().delete();
                return false;
            }
        } catch (Throwable th) {
            this.zzb.zza().delete();
            ((zzget) this.zzf.zzb()).zza().delete();
            this.zzd.zza().delete();
            throw th;
        }
    }

    public final /* synthetic */ zzfyp zzg(zzgfq zzgfqVar) {
        if (zzgfqVar == null || zzgfqVar.equals(zzgfq.zzh())) {
            return null;
        }
        zzbeb zzbebVarZza = zzgfqVar.zza();
        File fileZza = ((zzget) this.zze.zzb()).zza();
        zzget zzgetVar = this.zzc;
        return new zzfyp(zzbebVarZza, fileZza, zzgetVar.zza(), this.zzg);
    }

    public final /* synthetic */ ListenableFuture zzh(zzgfq zzgfqVar, Void r2) {
        return zzk(zzgfqVar);
    }

    public final /* synthetic */ ListenableFuture zzi(zzgfq zzgfqVar, List list) {
        return zzk(zzgfqVar);
    }
}
