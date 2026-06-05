package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzewe implements zzfck {
    private final zzhcg zza;
    private final VersionInfoParcel zzb;

    public zzewe(VersionInfoParcel versionInfoParcel, zzhcg zzhcgVar) {
        this.zzb = versionInfoParcel;
        this.zza = zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzewd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 54;
    }

    public final /* synthetic */ zzewf zzc() {
        return zzewf.zzb(this.zzb);
    }
}
