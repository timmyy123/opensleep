package com.google.android.gms.internal.serialization;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadw extends zzyy implements zzaar {
    public /* synthetic */ zzadw(byte[] bArr) {
        super(zzadx.zzb);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzadx) this.instance).zza());
    }

    public final zzadw zzb(Iterable iterable) {
        copyOnWrite();
        ((zzadx) this.instance).zzc(iterable);
        return this;
    }
}
