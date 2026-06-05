package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzigv extends zzigt {
    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzigu) obj).zzk(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i, int i2) {
        ((zzigu) obj).zzk((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i, long j) {
        ((zzigu) obj).zzk((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, zzida zzidaVar) {
        ((zzigu) obj).zzk((i << 3) | 2, zzidaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, Object obj2) {
        ((zzigu) obj).zzk((i << 3) | 3, (zzigu) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* synthetic */ Object zzf() {
        return zzigu.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* synthetic */ Object zzg(Object obj) {
        zzigu zziguVar = (zzigu) obj;
        zziguVar.zzd();
        return zziguVar;
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zziee zzieeVar = (zziee) obj;
        zzigu zziguVar = zzieeVar.zzt;
        if (zziguVar != zzigu.zza()) {
            return zziguVar;
        }
        zzigu zziguVarZzb = zzigu.zzb();
        zzieeVar.zzt = zziguVarZzb;
        return zziguVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zziee) obj).zzt = (zzigu) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzigt
    public final void zzj(Object obj) {
        ((zziee) obj).zzt.zzd();
    }
}
