package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Objects;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgvp implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzgvt zze;

    public /* synthetic */ zzgvp(zzgvt zzgvtVar, byte[] bArr) {
        Objects.requireNonNull(zzgvtVar);
        this.zze = zzgvtVar;
        this.zzb = zzgvtVar.zzs();
        this.zzc = zzgvtVar.zzf();
        this.zzd = -1;
    }

    private final void zzb() {
        if (this.zze.zzs() == this.zzb) {
            return;
        }
        OggIO$$ExternalSyntheticBUOutline0.m();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        int i = this.zzc;
        this.zzd = i;
        Object objZza = zza(i);
        this.zzc = this.zze.zzg(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzgtj.zzj(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i = this.zzd;
        zzgvt zzgvtVar = this.zze;
        zzgvtVar.remove(zzgvtVar.zzo(i));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract Object zza(int i);
}
