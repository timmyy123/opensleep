package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhlh {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    public /* synthetic */ zzhlh(byte[] bArr) {
    }

    public final zzhlh zza(Enum r2, Object obj) {
        this.zza.put(r2, obj);
        this.zzb.put(obj, r2);
        return this;
    }

    public final zzhli zzb() {
        return new zzhli(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), null);
    }
}
