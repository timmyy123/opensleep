package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbgu implements zzbfk {
    final /* synthetic */ zzbgx zza;

    public zzbgu(zzbgx zzbgxVar) {
        Objects.requireNonNull(zzbgxVar);
        this.zza = zzbgxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z) {
        zzbgx zzbgxVar = this.zza;
        if (z) {
            zzbgxVar.zzf();
        } else {
            zzbgxVar.zzg();
        }
    }
}
