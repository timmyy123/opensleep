package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhh implements zzhp {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzht zzd;

    public zzhh(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
        zzinVar.getClass();
        ArrayList arrayList = this.zzb;
        if (arrayList.contains(zzinVar)) {
            return;
        }
        arrayList.add(zzinVar);
        this.zzc++;
    }

    public final void zzf(zzht zzhtVar) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzin) this.zzb.get(i)).zza(this, zzhtVar, this.zza);
        }
    }

    public final void zzg(zzht zzhtVar) {
        this.zzd = zzhtVar;
        for (int i = 0; i < this.zzc; i++) {
            ((zzin) this.zzb.get(i)).zzb(this, zzhtVar, this.zza);
        }
    }

    public final void zzh(int i) {
        zzht zzhtVar = this.zzd;
        String str = zzfl.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzin) this.zzb.get(i2)).zzc(this, zzhtVar, this.zza, i);
        }
    }

    public final void zzi() {
        zzht zzhtVar = this.zzd;
        String str = zzfl.zza;
        for (int i = 0; i < this.zzc; i++) {
            ((zzin) this.zzb.get(i)).zzd(this, zzhtVar, this.zza);
        }
        this.zzd = null;
    }
}
