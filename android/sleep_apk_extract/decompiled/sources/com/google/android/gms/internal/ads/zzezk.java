package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzezk implements zzfck {
    private final Context zza;
    private final zzhcg zzb;

    public zzezk(zzhcg zzhcgVar, Context context) {
        this.zzb = zzhcgVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zzb.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzezj
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 57;
    }

    public final /* synthetic */ zzezl zzc() {
        com.google.android.gms.ads.internal.zzt.zzc();
        return new zzezl(com.google.android.gms.ads.internal.util.zzs.zzu(this.zza));
    }
}
