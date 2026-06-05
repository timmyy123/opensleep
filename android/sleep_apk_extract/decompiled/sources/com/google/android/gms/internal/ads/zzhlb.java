package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzhlb {
    final zzhla zza;
    final long[] zzb;

    public zzhlb() {
        this(new zzhla(), new long[10]);
    }

    public static /* synthetic */ zzhlb zza(zzhlb zzhlbVar, zzhkz zzhkzVar) {
        zzb(zzhlbVar, zzhkzVar);
        return zzhlbVar;
    }

    private static zzhlb zzb(zzhlb zzhlbVar, zzhkz zzhkzVar) {
        zzhla zzhlaVar = zzhkzVar.zza;
        zzhla zzhlaVar2 = zzhlbVar.zza;
        long[] jArr = zzhlaVar2.zza;
        long[] jArr2 = zzhlaVar.zza;
        long[] jArr3 = zzhkzVar.zzb;
        zzhlj.zze(jArr, jArr2, jArr3);
        long[] jArr4 = zzhlaVar2.zzb;
        long[] jArr5 = zzhlaVar.zzb;
        long[] jArr6 = zzhlaVar.zzc;
        zzhlj.zze(jArr4, jArr5, jArr6);
        zzhlj.zze(zzhlaVar2.zzc, jArr6, jArr3);
        zzhlj.zze(zzhlbVar.zzb, jArr2, jArr5);
        return zzhlbVar;
    }

    public zzhlb(zzhla zzhlaVar, long[] jArr) {
        this.zza = zzhlaVar;
        this.zzb = jArr;
    }

    public zzhlb(zzhkz zzhkzVar) {
        this();
        zzb(this, zzhkzVar);
    }
}
