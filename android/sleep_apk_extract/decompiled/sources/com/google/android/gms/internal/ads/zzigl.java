package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzigl implements Iterator {
    final /* synthetic */ zzign zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzigl(zzign zzignVar, byte[] bArr) {
        Objects.requireNonNull(zzignVar);
        this.zza = zzignVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzign zzignVar = this.zza;
        if (i >= zzignVar.zzj()) {
            return !zzignVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzign zzignVar = this.zza;
        return i < zzignVar.zzj() ? (zzigk) zzignVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("remove() was called before next()");
            return;
        }
        this.zzc = false;
        zzign zzignVar = this.zza;
        zzignVar.zzh();
        int i = this.zzb;
        if (i >= zzignVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzignVar.zzg(i);
        }
    }
}
