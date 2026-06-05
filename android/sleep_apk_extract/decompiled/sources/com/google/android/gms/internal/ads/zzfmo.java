package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbhv$zzb;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
final class zzfmo implements zzfmn {
    private final ConcurrentHashMap zza;
    private final zzfmu zzb;
    private final zzfmq zzc = new zzfmq();

    public zzfmo(zzfmu zzfmuVar) {
        this.zza = new ConcurrentHashMap(zzfmuVar.zzd);
        this.zzb = zzfmuVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfmu> creator = zzfmu.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhn)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfmu zzfmuVar = this.zzb;
            sb.append(zzfmuVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzg());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfmx) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfmm) entry.getValue()).zzc(); i2++) {
                    sb.append("[O]");
                }
                for (int iZzc = ((zzfmm) entry.getValue()).zzc(); iZzc < zzfmuVar.zzd; iZzc++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfmm) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < zzfmuVar.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final synchronized zzfmw zza(zzfmx zzfmxVar) {
        zzfmw zzfmwVarZzb;
        try {
            zzfmm zzfmmVar = (zzfmm) this.zza.get(zzfmxVar);
            if (zzfmmVar != null) {
                zzfmwVarZzb = zzfmmVar.zzb();
                if (zzfmwVarZzb == null) {
                    this.zzc.zzb();
                }
                zzfnk zzfnkVarZzh = zzfmmVar.zzh();
                if (zzfmwVarZzb != null) {
                    zzbhv$zzb.zzc zzcVarZzs = zzbhv$zzb.zzs();
                    zzbhv$zzb.zza.C0005zza c0005zzaZzs = zzbhv$zzb.zza.zzs();
                    c0005zzaZzs.zzc(zzbhv$zzb.zzd.IN_MEMORY);
                    zzbhv$zzb.zze.zza zzaVarZzq = zzbhv$zzb.zze.zzq();
                    zzaVarZzq.zzc(zzfnkVarZzh.zza);
                    zzaVarZzq.zzg(zzfnkVarZzh.zzb);
                    c0005zzaZzs.zzh(zzaVarZzq);
                    zzcVarZzs.zzh(c0005zzaZzs);
                    zzfmwVarZzb.zza.zza().zzd().zzj(zzcVarZzs.zzbm());
                }
                zzf();
            } else {
                this.zzc.zza();
                zzf();
                zzfmwVarZzb = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzfmwVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final synchronized boolean zzb(zzfmx zzfmxVar, zzfmw zzfmwVar) {
        boolean zZza;
        try {
            ConcurrentHashMap concurrentHashMap = this.zza;
            zzfmm zzfmmVar = (zzfmm) concurrentHashMap.get(zzfmxVar);
            zzfmwVar.zzd = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            if (zzfmmVar == null) {
                zzfmu zzfmuVar = this.zzb;
                zzfmm zzfmmVar2 = new zzfmm(zzfmuVar.zzd, zzfmuVar.zze * 1000);
                if (concurrentHashMap.size() == zzfmuVar.zzc) {
                    int i = zzfmuVar.zzg;
                    int i2 = i - 1;
                    zzfmx zzfmxVar2 = null;
                    if (i == 0) {
                        throw null;
                    }
                    long jZzd = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            if (((zzfmm) entry.getValue()).zzd() < jZzd) {
                                jZzd = ((zzfmm) entry.getValue()).zzd();
                                zzfmxVar2 = (zzfmx) entry.getKey();
                            }
                        }
                        if (zzfmxVar2 != null) {
                            concurrentHashMap.remove(zzfmxVar2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                            if (((zzfmm) entry2.getValue()).zze() < jZzd) {
                                jZzd = ((zzfmm) entry2.getValue()).zze();
                                zzfmxVar2 = (zzfmx) entry2.getKey();
                            }
                        }
                        if (zzfmxVar2 != null) {
                            concurrentHashMap.remove(zzfmxVar2);
                        }
                    } else if (i2 == 2) {
                        int iZzf = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                            if (((zzfmm) entry3.getValue()).zzf() < iZzf) {
                                iZzf = ((zzfmm) entry3.getValue()).zzf();
                                zzfmxVar2 = (zzfmx) entry3.getKey();
                            }
                        }
                        if (zzfmxVar2 != null) {
                            concurrentHashMap.remove(zzfmxVar2);
                        }
                    }
                    this.zzc.zzd();
                }
                concurrentHashMap.put(zzfmxVar, zzfmmVar2);
                this.zzc.zzc();
                zzfmmVar = zzfmmVar2;
            }
            zZza = zzfmmVar.zza(zzfmwVar);
            zzfmq zzfmqVar = this.zzc;
            zzfmqVar.zze();
            zzfmp zzfmpVarZzf = zzfmqVar.zzf();
            zzfnk zzfnkVarZzh = zzfmmVar.zzh();
            zzbhv$zzb.zzc zzcVarZzs = zzbhv$zzb.zzs();
            zzbhv$zzb.zza.C0005zza c0005zzaZzs = zzbhv$zzb.zza.zzs();
            c0005zzaZzs.zzc(zzbhv$zzb.zzd.IN_MEMORY);
            zzbhv$zzb.zzg.zza zzaVarZzs = zzbhv$zzb.zzg.zzs();
            zzaVarZzs.zzc(zzfmpVarZzf.zza);
            zzaVarZzs.zzg(zzfmpVarZzf.zzb);
            zzaVarZzs.zzk(zzfnkVarZzh.zzb);
            c0005zzaZzs.zzn(zzaVarZzs);
            zzcVarZzs.zzh(c0005zzaZzs);
            zzfmwVar.zza.zza().zzd().zzk(zzcVarZzs.zzbm());
            zzf();
        } catch (Throwable th) {
            throw th;
        }
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final synchronized boolean zzc(zzfmx zzfmxVar) {
        zzfmm zzfmmVar = (zzfmm) this.zza.get(zzfmxVar);
        if (zzfmmVar == null) {
            return true;
        }
        return zzfmmVar.zzc() < this.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    @Deprecated
    public final zzfmx zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfmu zzfmuVar = this.zzb;
        return new zzfmy(zzmVar, str, new zzcbg(zzfmuVar.zza).zza().zzj, zzfmuVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final zzfmu zze() {
        return this.zzb;
    }
}
