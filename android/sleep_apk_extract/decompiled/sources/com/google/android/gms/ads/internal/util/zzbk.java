package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzata;
import com.google.android.gms.internal.ads.zzate;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzcfw;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbk extends zzate {
    private final zzcfw zza;
    private final com.google.android.gms.ads.internal.util.client.zzl zzb;

    public zzbk(String str, Map map, zzcfw zzcfwVar) {
        super(0, str, new zzbj(zzcfwVar));
        this.zza = zzcfwVar;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        this.zzb = zzlVar;
        zzlVar.zzb(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzate
    public final zzatk zzr(zzata zzataVar) {
        return zzatk.zza(zzataVar, zzaub.zza(zzataVar));
    }

    @Override // com.google.android.gms.internal.ads.zzate
    public final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzata zzataVar = (zzata) obj;
        Map map = zzataVar.zzc;
        int i = zzataVar.zza;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = this.zzb;
        zzlVar.zzd(map, i);
        byte[] bArr = zzataVar.zzb;
        if (com.google.android.gms.ads.internal.util.client.zzl.zzj() && bArr != null) {
            zzlVar.zzf(bArr);
        }
        this.zza.zzc(zzataVar);
    }
}
