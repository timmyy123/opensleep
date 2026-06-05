package com.google.android.gms.ads.internal.util;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.internal.ads.zzati;
import com.google.android.gms.internal.ads.zzatn;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbg implements zzati {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbi zzb;

    public zzbg(zzbl zzblVar, String str, zzbi zzbiVar) {
        this.zza = str;
        this.zzb = zzbiVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzati
    public final void zza(zzatn zzatnVar) {
        String str = this.zza;
        String string = zzatnVar.toString();
        String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length()), "Failed to load URL: ", str, "\n", string);
        int i = zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strM);
        this.zzb.zza((Object) null);
    }
}
