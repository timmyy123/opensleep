package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
final class zzepb implements zzhbt {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfki zzb;
    final /* synthetic */ zzfkf zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfry zze;
    final /* synthetic */ zzfkq zzf;
    final /* synthetic */ zzepd zzg;

    public zzepb(zzepd zzepdVar, long j, zzfki zzfkiVar, zzfkf zzfkfVar, String str, zzfry zzfryVar, zzfkq zzfkqVar) {
        this.zza = j;
        this.zzb = zzfkiVar;
        this.zzc = zzfkfVar;
        this.zzd = str;
        this.zze = zzfryVar;
        this.zzf = zzfkqVar;
        Objects.requireNonNull(zzepdVar);
        this.zzg = zzepdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Throwable th) {
        int i;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        Integer numValueOf;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        zzepd zzepdVar = this.zzg;
        long jElapsedRealtime = zzepdVar.zzj().elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i2 = 2;
        } else {
            if (th instanceof zzeol) {
                i = 3;
            } else if (th instanceof CancellationException) {
                i2 = 4;
            } else if (th instanceof zzflf) {
                i2 = 5;
            } else if (th instanceof zzeed) {
                i2 = zzfma.zza(th).zza == 3 ? 1 : 6;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcn)).booleanValue() && (th instanceof zzelw) && (zzeVarZzb = ((zzelw) th).zzb()) != null) {
                    numValueOf = Integer.valueOf(zzeVarZzb.zza);
                    i = i2;
                    synchronized (zzepdVar) {
                        try {
                            if (zzepdVar.zzn()) {
                                zzepdVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzelw ? (zzelw) th : null, jElapsedRealtime);
                                jElapsedRealtime = jElapsedRealtime;
                            }
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjE)).booleanValue()) {
                                zzfsc zzfscVarZzl = zzepdVar.zzl();
                                zzfry zzfryVar = this.zze;
                                zzfkq zzfkqVar = this.zzf;
                                zzfkf zzfkfVar = this.zzc;
                                zzfscVarZzl.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzn), zzfkfVar.zzax);
                            }
                            if (zzepdVar.zzp()) {
                                return;
                            }
                            LinkedHashMap linkedHashMapZzm = zzepdVar.zzm();
                            zzfkf zzfkfVar2 = this.zzc;
                            linkedHashMapZzm.put(zzfkfVar2, new zzepc(this.zzd, zzfkfVar2.zzaf, i, jElapsedRealtime, numValueOf));
                            com.google.android.gms.ads.internal.client.zze zzeVarZza = zzfma.zza(th);
                            int i3 = zzeVarZza.zza;
                            if ((i3 == 3 || i3 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals("com.google.android.gms.ads")) {
                                zzeVarZza = zzfma.zza(new zzelw(13, zzeVarZza.zzd));
                            }
                            zzepdVar.zzo().zze(zzfkfVar2, jElapsedRealtime, zzeVarZza);
                            return;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } else {
                i = 6;
            }
            numValueOf = null;
            synchronized (zzepdVar) {
            }
        }
        i = i2;
        numValueOf = null;
        synchronized (zzepdVar) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        long j;
        zzepd zzepdVar = this.zzg;
        long jElapsedRealtime = zzepdVar.zzj().elapsedRealtime() - this.zza;
        synchronized (zzepdVar) {
            try {
                if (zzepdVar.zzn()) {
                    j = jElapsedRealtime;
                    zzepdVar.zzk().zza(this.zzb, this.zzc, 0, null, j);
                } else {
                    j = jElapsedRealtime;
                }
                if (zzepdVar.zzp()) {
                    return;
                }
                zzfkf zzfkfVar = this.zzc;
                if (zzepdVar.zzi(zzfkfVar)) {
                    ((zzepc) zzepdVar.zzm().get(zzfkfVar)).zzd = j;
                } else {
                    long j2 = j;
                    j = j2;
                    zzepdVar.zzm().put(zzfkfVar, new zzepc(this.zzd, zzfkfVar.zzaf, 0, j2, null));
                }
                zzepdVar.zzo().zzd(zzfkfVar, j, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
