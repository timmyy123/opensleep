package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzwu implements zzze {
    private final zzgwm zza;
    private long zzb;

    public zzwu(List list, List list2) {
        int i = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        zzgtj.zza(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgwjVar.zzf(new zzwt((zzze) list.get(i2), (List) list2.get(i2)));
        }
        this.zza = zzgwjVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final void zzg(long j) {
        int i = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i >= zzgwmVar.size()) {
                return;
            }
            ((zzwt) zzgwmVar.get(i)).zzg(j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i >= zzgwmVar.size()) {
                break;
            }
            zzwt zzwtVar = (zzwt) zzgwmVar.get(i);
            long jZzi = zzwtVar.zzi();
            if ((zzwtVar.zza().contains(1) || zzwtVar.zza().contains(2) || zzwtVar.zza().contains(4)) && jZzi != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzi);
            }
            if (jZzi != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzi);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.zzb;
        return j != -9223372036854775807L ? j : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i >= zzgwmVar.size()) {
                break;
            }
            long jZzl = ((zzwt) zzgwmVar.get(i)).zzl();
            if (jZzl != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzl);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        boolean zZzm;
        boolean z = false;
        do {
            long jZzl = zzl();
            if (jZzl == Long.MIN_VALUE) {
                break;
            }
            int i = 0;
            zZzm = false;
            while (true) {
                zzgwm zzgwmVar = this.zza;
                if (i >= zzgwmVar.size()) {
                    break;
                }
                long jZzl2 = ((zzwt) zzgwmVar.get(i)).zzl();
                boolean z2 = jZzl2 != Long.MIN_VALUE && jZzl2 <= zzmaVar.zza;
                if (jZzl2 == jZzl || z2) {
                    zZzm |= ((zzwt) zzgwmVar.get(i)).zzm(zzmaVar);
                }
                i++;
            }
            z |= zZzm;
        } while (zZzm);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        int i = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i >= zzgwmVar.size()) {
                return false;
            }
            if (((zzwt) zzgwmVar.get(i)).zzn()) {
                return true;
            }
            i++;
        }
    }
}
