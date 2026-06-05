package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzewt implements zzfck {
    private final zzfhe zza;

    public zzewt(zzfhe zzfheVar) {
        this.zza = zzfheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzfhe zzfheVar = this.zza;
        if (zzfheVar == null) {
            return zzhbw.zza(new zzews(null));
        }
        String strZza = zzfheVar.zza();
        return Strings.isEmptyOrWhitespace(strZza) ? zzhbw.zza(new zzews(null)) : zzhbw.zza(new zzews(strZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 15;
    }
}
