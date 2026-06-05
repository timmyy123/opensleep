package com.google.android.gms.internal.ads;

import java.nio.ByteOrder;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagl {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzagk zzk;
    private final zzap zzl;

    public zzagl(byte[] bArr, int i) {
        zzes zzesVar = new zzes(bArr, bArr.length);
        zzesVar.zzf(i * 8);
        this.zza = zzesVar.zzj(16);
        this.zzb = zzesVar.zzj(16);
        this.zzc = zzesVar.zzj(24);
        this.zzd = zzesVar.zzj(24);
        int iZzj = zzesVar.zzj(20);
        this.zze = iZzj;
        this.zzf = zzf(iZzj);
        this.zzg = zzesVar.zzj(3) + 1;
        int iZzj2 = zzesVar.zzj(5) + 1;
        this.zzh = iZzj2;
        this.zzi = zzg(iZzj2);
        this.zzj = zzesVar.zzk(36);
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzf(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static int zzg(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 20) {
            return 5;
        }
        if (i != 24) {
            return i != 32 ? -1 : 7;
        }
        return 6;
    }

    public final long zza() {
        long j = this.zzj;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        String str = zzfl.zza;
        return Math.max(0L, Math.min((j * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzv zzc(byte[] bArr, zzap zzapVar) {
        bArr[4] = -128;
        zzap zzapVarZzd = zzd(zzapVar);
        zzt zztVar = new zzt();
        zztVar.zzo("audio/flac");
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zztVar.zzp(i);
        zztVar.zzG(this.zzg);
        zztVar.zzH(this.zze);
        zztVar.zzI(zzfl.zzB(this.zzh, ByteOrder.LITTLE_ENDIAN));
        zztVar.zzr(Collections.singletonList(bArr));
        zztVar.zzl(zzapVarZzd);
        return zztVar.zzO();
    }

    public final zzap zzd(zzap zzapVar) {
        zzap zzapVar2 = this.zzl;
        return zzapVar2 == null ? zzapVar : zzapVar2.zzf(zzapVar);
    }

    public final zzagl zze(zzagk zzagkVar) {
        return new zzagl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzagkVar, this.zzl);
    }

    public zzagl(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, zzagk zzagkVar, zzap zzapVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzf(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzg(i7);
        this.zzj = j;
        this.zzk = zzagkVar;
        this.zzl = zzapVar;
    }
}
