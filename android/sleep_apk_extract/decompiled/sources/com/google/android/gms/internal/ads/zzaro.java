package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
final class zzaro implements zzarn {
    private final zzagb zza;
    private final zzahk zzb;
    private final zzarr zzc;
    private final zzv zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaro(zzagb zzagbVar, zzahk zzahkVar, zzarr zzarrVar, String str, int i) throws zzat {
        this.zza = zzagbVar;
        this.zzb = zzahkVar;
        this.zzc = zzarrVar;
        int i2 = zzarrVar.zzb * zzarrVar.zze;
        int i3 = zzarrVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzat.zzb(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i4).length() + 28 + String.valueOf(i3).length()), i4, "Expected block size: ", i3, "; got: "), null);
        }
        int i5 = zzarrVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzt zztVar = new zzt();
        zztVar.zzn("audio/wav");
        zztVar.zzo(str);
        zztVar.zzi(i6);
        zztVar.zzj(i6);
        zztVar.zzp(iMax);
        zztVar.zzG(zzarrVar.zzb);
        zztVar.zzH(zzarrVar.zzc);
        zztVar.zzI(i);
        this.zzd = zztVar.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zza(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zzb(int i, long j) {
        zzaru zzaruVar = new zzaru(this.zzc, 1, i, j);
        this.zza.zzw(zzaruVar);
        zzahk zzahkVar = this.zzb;
        zzahkVar.zzA(this.zzd);
        zzahkVar.zzO(zzaruVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final boolean zzc(zzafz zzafzVar, long j) {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZza = this.zzb.zza(zzafzVar, (int) Math.min(i2 - i, j2), true);
            if (iZza == -1) {
                j2 = 0;
            } else {
                this.zzg += iZza;
                j2 -= (long) iZza;
            }
        }
        zzarr zzarrVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzarrVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzv = this.zzf + zzfl.zzv(this.zzh, 1000000L, zzarrVar.zzc, RoundingMode.DOWN);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zze(jZzv, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
