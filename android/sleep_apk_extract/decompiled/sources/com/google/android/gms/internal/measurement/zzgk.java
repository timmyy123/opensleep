package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgk extends zzadp implements zzafd {
    public /* synthetic */ zzgk(byte[] bArr) {
        super(zzgl.zzw);
    }

    public final int zza() {
        return ((zzgl) this.zza).zzf();
    }

    public final zzgj zzb(int i) {
        return ((zzgl) this.zza).zzh(i);
    }

    public final zzgk zzc(int i, zzgi zzgiVar) {
        zzaY();
        ((zzgl) this.zza).zzu(i, (zzgj) zzgiVar.zzbd());
        return this;
    }

    public final List zzd() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzi());
    }

    public final zzgk zze() {
        zzaY();
        ((zzgl) this.zza).zzv();
        return this;
    }

    public final zzgk zzf() {
        zzaY();
        ((zzgl) this.zza).zzw();
        return this;
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzl());
    }

    public final String zzh() {
        return ((zzgl) this.zza).zzm();
    }

    public final List zzi() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzr());
    }
}
