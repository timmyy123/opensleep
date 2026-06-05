package com.google.android.gms.internal.measurement;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzzy extends zzaaa {
    private final zzzj zza;
    private final zzzj zzb;
    private final int[] zzc;
    private final int zzd;

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zzzy(zzzj zzzjVar, zzzj zzzjVar2, byte[] bArr) {
        super(null);
        this.zza = zzzjVar;
        this.zzb = zzzjVar2;
        int iZza = zzzjVar2.zza();
        zzabr.zzb(iZza <= 28, "metadata size too large");
        int[] iArr = new int[iZza];
        this.zzc = iArr;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            zzyl zzylVarZzd = zzd(i);
            long jZzi = zzylVarZzd.zzi() | j;
            if (jZzi == j) {
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        i3 = -1;
                        break;
                    } else if (zzylVarZzd.equals(zzd(iArr[i3] & 31))) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    iArr[i3] = zzylVarZzd.zzf() ? iArr[i3] | (1 << (i + 4)) : i;
                } else {
                    iArr[i2] = i;
                    i2++;
                }
            }
            i++;
            j = jZzi;
        }
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzyl zzd(int i) {
        zzzj zzzjVar = this.zza;
        int iZza = zzzjVar.zza();
        return i >= iZza ? this.zzb.zzb(i - iZza) : zzzjVar.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final Object zze(int i) {
        zzzj zzzjVar = this.zza;
        int iZza = zzzjVar.zza();
        return i >= iZza ? this.zzb.zzc(i - iZza) : zzzjVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final void zza(zzzq zzzqVar, Object obj) {
        for (int i = 0; i < this.zzd; i++) {
            int i2 = this.zzc[i];
            zzyl zzylVarZzd = zzd(i2 & 31);
            if (zzylVarZzd.zzf()) {
                zzzqVar.zzb(zzylVarZzd, new zzzx(this, zzylVarZzd, i2, null), obj);
            } else {
                zzzqVar.zza(zzylVarZzd, zzylVarZzd.zze(zze(i2)), obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final Set zzc() {
        return new zzzw(this);
    }

    public final /* synthetic */ int[] zzf() {
        return this.zzc;
    }

    public final /* synthetic */ int zzg() {
        return this.zzd;
    }
}
