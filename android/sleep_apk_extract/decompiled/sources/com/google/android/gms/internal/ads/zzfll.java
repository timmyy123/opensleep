package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfll {
    private final zzfkf zza;
    private final zzfki zzb;
    private final zzfsc zzc;
    private final zzfru zzd;
    private final zzfqg zze;
    private final zzctj zzf;

    public zzfll(zzfsc zzfscVar, zzfru zzfruVar, zzfkf zzfkfVar, zzfki zzfkiVar, zzctj zzctjVar, zzfqg zzfqgVar) {
        this.zza = zzfkfVar;
        this.zzb = zzfkiVar;
        this.zzc = zzfscVar;
        this.zzd = zzfruVar;
        this.zzf = zzctjVar;
        this.zze = zzfqgVar;
    }

    public final void zza(List list, zzdfg zzdfgVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), 2, zzdfgVar);
        }
    }

    public final void zzb(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzhbw.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlw)).booleanValue() && zzctj.zzc(str)) ? this.zzf.zzb(str, com.google.android.gms.ads.internal.client.zzay.zzh()) : zzhbw.zza(str), new zzflk(this, i), zzcfr.zza);
        }
    }

    public final void zzc(String str, int i, zzdfg zzdfgVar) {
        zzfkf zzfkfVar = this.zza;
        if (zzfkfVar.zzai) {
            this.zzd.zza(str, this.zzb.zzb, i);
            return;
        }
        this.zzc.zzb(str, zzfkfVar.zzax, this.zze, zzdfgVar);
    }
}
