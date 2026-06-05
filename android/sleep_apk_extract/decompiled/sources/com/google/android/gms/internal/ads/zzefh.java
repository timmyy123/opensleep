package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
final class zzefh implements zzhbt {
    final /* synthetic */ zzefk zza;

    public zzefh(zzefk zzefkVar) {
        Objects.requireNonNull(zzefkVar);
        this.zza = zzefkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhh)).booleanValue()) {
            Matcher matcher = zzefk.zzh.matcher(th.getMessage());
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                zzefk zzefkVar = this.zza;
                zzefkVar.zzc().zzc(Integer.parseInt(strGroup));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkq zzfkqVar = (zzfkq) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhh)).booleanValue()) {
            zzefk zzefkVar = this.zza;
            zzfki zzfkiVar = zzfkqVar.zzb.zzb;
            zzefkVar.zzc().zzc(zzfkiVar.zzf);
            zzefkVar.zzc().zze(zzfkiVar.zzg);
        }
    }
}
