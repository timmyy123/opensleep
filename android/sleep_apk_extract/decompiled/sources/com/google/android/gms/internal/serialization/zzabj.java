package com.google.android.gms.internal.serialization;

import java.util.Iterator;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzabj implements Iterator {
    final /* synthetic */ zzabl zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzabl zzablVar = this.zza;
        if (i >= zzablVar.zzj()) {
            return !zzablVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzabl zzablVar = this.zza;
        return i < zzablVar.zzj() ? (zzabi) zzablVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("remove() was called before next()");
            return;
        }
        this.zzc = false;
        this.zza.zzh();
        int i = this.zzb;
        zzabl zzablVar = this.zza;
        if (i >= zzablVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzablVar.zzg(i);
        }
    }
}
