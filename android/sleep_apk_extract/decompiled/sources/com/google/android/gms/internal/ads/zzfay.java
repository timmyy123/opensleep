package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfay implements zzfci {
    private final String zza;
    private final Integer zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public zzfay(String str, Integer num, String str2, String str3, String str4, String str5) {
        this.zza = str;
        this.zzb = num;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfln.zze(bundle, "pn", this.zza);
        zzfln.zzh(bundle, "vc", this.zzb);
        zzfln.zze(bundle, "vnm", this.zzc);
        zzfln.zze(bundle, "dl", this.zzd);
        zzfln.zze(bundle, "ins_pn", this.zze);
        zzfln.zze(bundle, "ini_pn", this.zzf);
    }
}
