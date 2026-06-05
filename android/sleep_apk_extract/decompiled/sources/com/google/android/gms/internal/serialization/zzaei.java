package com.google.android.gms.internal.serialization;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaei extends zzyy implements zzaar {
    public /* synthetic */ zzaei(byte[] bArr) {
        super(zzaej.zzb);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzaej) this.instance).zza());
    }

    public final zzaei zzb(zzacx zzacxVar) {
        copyOnWrite();
        ((zzaej) this.instance).zzd(zzacxVar);
        return this;
    }

    public final zzaei zzc(Iterable iterable) {
        copyOnWrite();
        ((zzaej) this.instance).zze(iterable);
        return this;
    }
}
