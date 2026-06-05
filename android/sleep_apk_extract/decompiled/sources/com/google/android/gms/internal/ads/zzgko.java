package com.google.android.gms.internal.ads;

import androidx.appfunctions.AppFunctionException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzgko {
    private final zzgox zza;
    private final zzgme zzb;
    private final zzgmv zzc;
    private final zzgqh zzd;
    private final zzgel zze;
    private final boolean zzf;
    private final long zzg;
    private final long zzh;

    public zzgko(zzgox zzgoxVar, zzgme zzgmeVar, zzgmv zzgmvVar, zzgqh zzgqhVar, zzgel zzgelVar, boolean z, long j, long j2) {
        this.zza = zzgoxVar;
        this.zzb = zzgmeVar;
        this.zzc = zzgmvVar;
        this.zzd = zzgqhVar;
        this.zze = zzgelVar;
        this.zzf = z;
        this.zzg = j;
        this.zzh = j2;
    }

    private final ListenableFuture zzh(final int i) {
        zzhbo zzhboVar = (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzk(zzhbo.zzw(this.zzb.zza()), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgkf
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzgfo zzgfoVar = (zzgfo) obj;
                this.zza.zzd(zzgfoVar);
                return zzgfoVar;
            }
        }, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgkg
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zze((zzgfo) obj);
            }
        }, zzhcn.zza()), zzgkh.zza, zzhcn.zza()), zzgka.class, zzgki.zza, zzhcn.zza()), zzgkb.class, zzgkj.zza, zzhcn.zza()), zzgjz.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzgkk
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzf(i, (zzgjz) obj);
            }
        }, zzhcn.zza());
        this.zzd.zze(1002, zzhboVar);
        return zzhboVar;
    }

    public final void zza(long j) {
        if (j > 0) {
            this.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgkm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzb();
                }
            }, j);
        } else {
            zzb();
        }
    }

    public final ListenableFuture zzb() {
        zzhbo zzhboVar = (zzhbo) zzhbw.zzg(zzhbo.zzw(this.zzc.zzb()), Throwable.class, zzgkd.zza, zzhcn.zza());
        final zzgox zzgoxVar = this.zza;
        Objects.requireNonNull(zzgoxVar);
        return (zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzk(zzhboVar, new zzgta() { // from class: com.google.android.gms.internal.ads.zzgkc
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return new Boolean(zzgoxVar.zza((zzgfq) obj));
            }
        }, zzhcn.zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzgke
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Boolean) obj);
            }
        }, zzhcn.zza());
    }

    public final /* synthetic */ ListenableFuture zzc(Boolean bool) {
        if (bool.booleanValue()) {
            return zzh(0);
        }
        this.zzd.zzb(AppFunctionException.ERROR_FUNCTION_NOT_FOUND);
        return zzhbw.zza(zzgkn.RESULT_NOOP_LOCAL_PROGRAM_STILL_VALID);
    }

    public final /* synthetic */ zzgfo zzd(zzgfo zzgfoVar) {
        int iZzj = zzgfoVar.zzj() - 1;
        if (iZzj == 1 || iZzj == 2) {
            return zzgfoVar;
        }
        if (iZzj == 3) {
            zzgqh zzgqhVar = this.zzd;
            int iZzj2 = zzgfoVar.zzj() - 1;
            StringBuilder sb = new StringBuilder(String.valueOf(iZzj2).length());
            sb.append(iZzj2);
            zzgqhVar.zzc(1004, sb.toString());
            throw new zzgkb(zzgfoVar.zzj() - 1);
        }
        zzgqh zzgqhVar2 = this.zzd;
        if (iZzj != 12) {
            int iZzj3 = zzgfoVar.zzj() - 1;
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj3).length());
            sb2.append(iZzj3);
            zzgqhVar2.zzc(1005, sb2.toString());
            throw new zzgka(zzgfoVar.zzj() - 1);
        }
        int iZzj4 = zzgfoVar.zzj() - 1;
        StringBuilder sb3 = new StringBuilder(String.valueOf(iZzj4).length());
        sb3.append(iZzj4);
        zzgqhVar2.zzc(1005, sb3.toString());
        throw new zzgjz(zzgfoVar.zzj() - 1);
    }

    public final /* synthetic */ ListenableFuture zze(zzgfo zzgfoVar) {
        if (zzgfoVar.zzj() == 2) {
            return this.zzc.zzd(zzgfoVar.zza(), zzgfoVar.zzb().zzA());
        }
        if (zzgfoVar.zzj() == 3) {
            return this.zzc.zzc(zzgfoVar.zza(), zzgfoVar.zzc().zzA(), zzgfoVar.zzb().zzA());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "Unreachable");
        return null;
    }

    public final /* synthetic */ zzgkn zzf(final int i, zzgjz zzgjzVar) {
        if (this.zzf && i < this.zzg) {
            this.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgkl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzg(i);
                }
            }, this.zzh * ((long) Math.pow(2.0d, i)));
        }
        return zzgkn.RESULT_FAILURE_FETCHER_HTTP_RUNTIME_EXCEPTION;
    }

    public final /* synthetic */ void zzg(int i) {
        zzh(i + 1);
    }
}
