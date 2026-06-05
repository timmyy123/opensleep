package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxv implements zzcxw {
    private final Map zza;

    public zzcxv(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcxw
    public final zzels zza(int i, String str) {
        return (zzels) this.zza.get(str);
    }
}
