package com.google.android.gms.internal.serialization;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadq extends zzyy implements zzaar {
    public /* synthetic */ zzadq(byte[] bArr) {
        super(zzadr.zzc);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzadr) this.instance).zza());
    }

    public final zzadq zzb(Iterable iterable) {
        copyOnWrite();
        ((zzadr) this.instance).zzd(iterable);
        return this;
    }

    public final List zzc() {
        return Collections.unmodifiableList(((zzadr) this.instance).zzb());
    }

    public final zzadq zzd(zzadn zzadnVar) {
        copyOnWrite();
        ((zzadr) this.instance).zze(zzadnVar);
        return this;
    }

    public final zzadq zze(Iterable iterable) {
        copyOnWrite();
        ((zzadr) this.instance).zzf(iterable);
        return this;
    }
}
