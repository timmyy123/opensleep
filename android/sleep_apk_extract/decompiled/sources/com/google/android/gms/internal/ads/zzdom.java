package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzdom implements zzbpq {
    private final WeakReference zza;
    private final zzfsc zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;
    private final zzfqg zzd;

    public /* synthetic */ zzdom(zzdon zzdonVar, zzfsc zzfscVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfqg zzfqgVar, byte[] bArr) {
        this.zza = new WeakReference(zzdonVar);
        this.zzb = zzfscVar;
        this.zzc = zzvVar;
        this.zzd = zzfqgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        zzdon zzdonVar = (zzdon) this.zza.get();
        String str = (String) map.get("u");
        if (zzdonVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.zzb.zzb(str, this.zzc, this.zzd, zzdonVar.zzF());
    }
}
