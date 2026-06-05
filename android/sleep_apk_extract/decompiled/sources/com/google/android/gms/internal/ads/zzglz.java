package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
final class zzglz {
    private final zzaux zza;
    private final long zzb;
    private final long zzc;
    private final String zzd;

    private zzglz(zzaux zzauxVar, long j, long j2, String str) {
        this.zza = zzauxVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = str;
    }

    public static /* synthetic */ zzglz zza(zzaux zzauxVar, byte[] bArr, boolean z) {
        zzauxVar.zza();
        zzauxVar.zzb(bArr);
        List list = (List) zzauxVar.zzc(Optional.empty());
        long jLongValue = ((Long) list.get(0)).longValue();
        long jLongValue2 = ((Long) list.get(1)).longValue();
        long jLongValue3 = ((Long) list.get(2)).longValue();
        zzauxVar.zzd(jLongValue, Optional.empty());
        String strZza = zzgea.zza(zzava.zza(), false);
        int length = strZza.length();
        String str = true != z ? "" : "-s";
        return new zzglz(zzauxVar, jLongValue2, jLongValue3, Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + length + 12), "3.878096153.", strZza, str));
    }

    public final /* synthetic */ String zzb(Map map) {
        return zzgea.zza((byte[]) this.zza.zzd(this.zzb, Optional.of(map)), true);
    }

    public final /* synthetic */ void zzc(Map map) {
        this.zza.zzd(this.zzc, Optional.of(map));
    }

    public final /* synthetic */ String zzd() {
        return this.zzd;
    }
}
