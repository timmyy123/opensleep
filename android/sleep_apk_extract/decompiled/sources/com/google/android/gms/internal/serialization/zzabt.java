package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
final class zzabt extends zzabr {
    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzabs) obj).zzk(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i, int i2) {
        ((zzabs) obj).zzk((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i, long j) {
        ((zzabs) obj).zzk((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, zzwr zzwrVar) {
        ((zzabs) obj).zzk((i << 3) | 2, zzwrVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, Object obj2) {
        ((zzabs) obj).zzk((i << 3) | 3, (zzabs) obj2);
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* synthetic */ Object zzf() {
        return zzabs.zzb();
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* synthetic */ Object zzg(Object obj) {
        zzabs zzabsVar = (zzabs) obj;
        zzabsVar.zzd();
        return zzabsVar;
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzzg zzzgVar = (zzzg) obj;
        zzabs zzabsVar = zzzgVar.unknownFields;
        if (zzabsVar != zzabs.zza()) {
            return zzabsVar;
        }
        zzabs zzabsVarZzb = zzabs.zzb();
        zzzgVar.unknownFields = zzabsVarZzb;
        return zzabsVarZzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzzg) obj).unknownFields = (zzabs) obj2;
    }

    @Override // com.google.android.gms.internal.serialization.zzabr
    public final void zzj(Object obj) {
        ((zzzg) obj).unknownFields.zzd();
    }
}
