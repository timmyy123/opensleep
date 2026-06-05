package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcbk {
    private final WeakHashMap zza = new WeakHashMap();

    public final Future zza(Context context) {
        return zzcfr.zza.zzc(new zzcbi(this, context));
    }

    public final /* synthetic */ WeakHashMap zzb() {
        return this.zza;
    }
}
