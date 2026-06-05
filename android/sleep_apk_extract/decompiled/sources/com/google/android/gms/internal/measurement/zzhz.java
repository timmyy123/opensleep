package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzhz extends zzadp implements zzafd {
    public /* synthetic */ zzhz(byte[] bArr) {
        super(zzib.zzi);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzib) this.zza).zza());
    }

    public final int zzb() {
        return ((zzib) this.zza).zzb();
    }

    public final zzid zzc(int i) {
        return ((zzib) this.zza).zzc(i);
    }

    public final zzhz zzd(int i, zzic zzicVar) {
        zzaY();
        ((zzib) this.zza).zzk(i, (zzid) zzicVar.zzbd());
        return this;
    }

    public final zzhz zze(zzic zzicVar) {
        zzaY();
        ((zzib) this.zza).zzl((zzid) zzicVar.zzbd());
        return this;
    }

    public final zzhz zzf(Iterable iterable) {
        zzaY();
        ((zzib) this.zza).zzm(iterable);
        return this;
    }

    public final zzhz zzg() {
        zzaY();
        ((zzib) this.zza).zzn();
        return this;
    }

    public final String zzh() {
        return ((zzib) this.zza).zze();
    }

    public final zzhz zzi(String str) {
        zzaY();
        ((zzib) this.zza).zzo(str);
        return this;
    }

    public final zzhz zzj(String str) {
        zzaY();
        ((zzib) this.zza).zzp(str);
        return this;
    }
}
