package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzamt {
    private final zzamu zza = new zzamu();
    private final zzet zzb = new zzet(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzamu zzamuVar = this.zza;
            if (i5 >= zzamuVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzamuVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final void zza() {
        this.zza.zza();
        this.zzb.zza(0);
        this.zzc = -1;
        this.zze = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzb(zzafz zzafzVar) {
        if (this.zze) {
            this.zze = false;
            this.zzb.zza(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                zzamu zzamuVar = this.zza;
                if (!zzamuVar.zzb(zzafzVar, -1L) || !zzamuVar.zzc(zzafzVar, true)) {
                    break;
                }
                int iZzf = zzamuVar.zzd;
                if ((zzamuVar.zza & 1) == 1 && this.zzb.zze() == 0) {
                    iZzf += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzagc.zzd(zzafzVar, iZzf)) {
                    return false;
                }
                this.zzc = i;
            }
            int iZzf2 = zzf(i);
            int i2 = this.zzc + this.zzd;
            if (iZzf2 > 0) {
                zzet zzetVar = this.zzb;
                zzetVar.zzc(zzetVar.zze() + iZzf2);
                if (!zzagc.zzc(zzafzVar, zzetVar.zzi(), zzetVar.zze(), iZzf2)) {
                    return false;
                }
                zzetVar.zzf(zzetVar.zze() + iZzf2);
                this.zze = this.zza.zzf[i2 + (-1)] != 255;
            }
            if (i2 == this.zza.zzc) {
                i2 = -1;
            }
            this.zzc = i2;
        }
    }

    public final zzamu zzc() {
        return this.zza;
    }

    public final zzet zzd() {
        return this.zzb;
    }

    public final void zze() {
        zzet zzetVar = this.zzb;
        if (zzetVar.zzi().length == 65025) {
            return;
        }
        zzetVar.zzb(Arrays.copyOf(zzetVar.zzi(), Math.max(65025, zzetVar.zze())), zzetVar.zze());
    }
}
