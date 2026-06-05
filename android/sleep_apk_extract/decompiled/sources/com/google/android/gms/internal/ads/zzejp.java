package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbhv$zzaf;

/* JADX INFO: loaded from: classes3.dex */
public final class zzejp implements zzfpl {
    private final zzejd zza;
    private final zzejh zzb;

    public zzejp(zzejd zzejdVar, zzejh zzejhVar) {
        this.zza = zzejdVar;
        this.zzb = zzejhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdL(zzfpe zzfpeVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdM(zzfpe zzfpeVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhh)).booleanValue()) {
            if (zzfpe.RENDERER == zzfpeVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime());
                return;
            }
            if (zzfpe.PRELOADED_LOADER == zzfpeVar || zzfpe.SERVER_TRANSACTION == zzfpeVar) {
                zzejd zzejdVar = this.zza;
                zzejdVar.zza(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime());
                final zzejh zzejhVar = this.zzb;
                final long jZzb = zzejdVar.zzb();
                zzejhVar.zza.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejg
                    @Override // com.google.android.gms.internal.ads.zzfok
                    public final /* synthetic */ Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzejhVar.zzf()) {
                            return null;
                        }
                        long j = jZzb;
                        zzbhv$zzaf.zza.C0004zza c0004zzaZzz = zzbhv$zzaf.zza.zzz();
                        c0004zzaZzz.zzad(j);
                        byte[] bArrZzaN = c0004zzaZzz.zzbm().zzaN();
                        zzejo.zzf(sQLiteDatabase, false, false);
                        zzejo.zze(sQLiteDatabase, j, bArrZzaN);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdN(zzfpe zzfpeVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhh)).booleanValue() && zzfpe.RENDERER == zzfpeVar) {
            zzejd zzejdVar = this.zza;
            if (zzejdVar.zzh() != 0) {
                zzejdVar.zzi(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzejdVar.zzh());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdO(zzfpe zzfpeVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhh)).booleanValue() && zzfpe.RENDERER == zzfpeVar) {
            zzejd zzejdVar = this.zza;
            if (zzejdVar.zzh() != 0) {
                zzejdVar.zzi(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzejdVar.zzh());
            }
        }
    }
}
