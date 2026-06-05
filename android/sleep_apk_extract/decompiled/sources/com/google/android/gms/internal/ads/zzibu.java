package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Objects;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzibu implements Iterator {
    zzibv zza;
    zzibv zzb;
    int zzc;
    final /* synthetic */ zzibw zzd;

    public zzibu(zzibw zzibwVar) {
        Objects.requireNonNull(zzibwVar);
        this.zzd = zzibwVar;
        this.zza = zzibwVar.zzd.zzd;
        this.zzb = null;
        this.zzc = zzibwVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzibv zzibvVar = this.zzb;
        if (zzibvVar == null) {
            Home$$ExternalSyntheticBUOutline0.m$2();
            return;
        }
        zzibw zzibwVar = this.zzd;
        zzibwVar.zzd(zzibvVar, true);
        this.zzb = null;
        this.zzc = zzibwVar.zzc;
    }

    public final zzibv zza() {
        zzibw zzibwVar = this.zzd;
        zzibv zzibvVar = this.zza;
        if (zzibvVar == zzibwVar.zzd) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        if (zzibwVar.zzc != this.zzc) {
            OggIO$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        this.zza = zzibvVar.zzd;
        this.zzb = zzibvVar;
        return zzibvVar;
    }
}
