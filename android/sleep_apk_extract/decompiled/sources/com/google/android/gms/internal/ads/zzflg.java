package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzflg implements zzhbt {
    final /* synthetic */ zzcku zza;
    final /* synthetic */ zzctj zzb;
    final /* synthetic */ zzfsc zzc;
    final /* synthetic */ zzekg zzd;

    public zzflg(zzcku zzckuVar, zzctj zzctjVar, zzfsc zzfscVar, zzekg zzekgVar) {
        this.zza = zzckuVar;
        this.zzb = zzctjVar;
        this.zzc = zzfscVar;
        this.zzd = zzekgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzctj zzctjVar;
        String str = (String) obj;
        zzcku zzckuVar = this.zza;
        zzfkf zzfkfVarZzC = zzckuVar.zzC();
        if (zzfkfVarZzC != null && !zzfkfVarZzC.zzai) {
            com.google.android.gms.ads.internal.util.client.zzv zzvVar = zzfkfVarZzC.zzax;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlw)).booleanValue() && (zzctjVar = this.zzb) != null && zzctj.zzc(str)) {
                zzctjVar.zza(str, this.zzc, com.google.android.gms.ads.internal.client.zzay.zzh(), zzvVar);
                return;
            } else {
                this.zzc.zzb(str, zzvVar, null, null);
                return;
            }
        }
        zzfki zzfkiVarZzaC = zzckuVar.zzaC();
        if (zzfkiVarZzaC == null) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingClickGmsgHandler");
            return;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        boolean zZzs = com.google.android.gms.ads.internal.zzt.zzh().zzs(zzckuVar.getContext());
        boolean z = false;
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhj)).booleanValue() && zzfkfVarZzC != null && zzfkfVarZzC.zzS;
        if (zzfkfVarZzC != null && zzfkfVarZzC.zzad != null) {
            z = true;
        }
        this.zzd.zze(new zzeki(jCurrentTimeMillis, zzfkiVarZzaC.zzb, str, (zZzs || z2 || z) ? 2 : 1));
    }
}
