package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbh;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzesd extends com.google.android.gms.ads.internal.client.zzbp {
    final zzfkx zza;
    final zzdqc zzb;
    private final Context zzc;
    private final zzcnj zzd;
    private zzbh zze;

    public zzesd(zzcnj zzcnjVar, Context context, String str) {
        zzfkx zzfkxVar = new zzfkx();
        this.zza = zzfkxVar;
        this.zzb = new zzdqc();
        this.zzd = zzcnjVar;
        zzfkxVar.zzg(str);
        this.zzc = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final com.google.android.gms.ads.internal.client.zzbn zze() {
        zzdqd zzdqdVarZzg = this.zzb.zzg();
        ArrayList arrayListZzh = zzdqdVarZzg.zzh();
        zzfkx zzfkxVar = this.zza;
        zzfkxVar.zzm(arrayListZzh);
        zzfkxVar.zzn(zzdqdVarZzg.zzi());
        if (zzfkxVar.zzf() == null) {
            zzfkxVar.zzc(com.google.android.gms.ads.internal.client.zzr.zzb());
        }
        return new zzese(this.zzc, this.zzd, zzfkxVar, zzdqdVarZzg, this.zze);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzf(zzbh zzbhVar) {
        this.zze = zzbhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzg(zzbmz zzbmzVar) {
        this.zzb.zzb(zzbmzVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzh(zzbnc zzbncVar) {
        this.zzb.zza(zzbncVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzi(String str, zzbni zzbniVar, zzbnf zzbnfVar) {
        this.zzb.zzf(str, zzbniVar, zzbnfVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzj(zzblt zzbltVar) {
        this.zza.zzo(zzbltVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzk(zzbnm zzbnmVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb.zzd(zzbnmVar);
        this.zza.zzc(zzrVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzl(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzr(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzm(zzbnp zzbnpVar) {
        this.zzb.zzc(zzbnpVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzn(zzbsb zzbsbVar) {
        this.zza.zzq(zzbsbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzo(zzbsk zzbskVar) {
        this.zzb.zze(zzbskVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzp(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzs(adManagerAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzq(com.google.android.gms.ads.internal.client.zzcp zzcpVar) {
        this.zza.zzab(zzcpVar);
    }
}
