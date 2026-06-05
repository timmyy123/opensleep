package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdub extends zzbmp {
    private final String zza;
    private final zzdpo zzb;
    private final zzdpt zzc;

    public zzdub(String str, zzdpo zzdpoVar, zzdpt zzdptVar) {
        this.zza = str;
        this.zzb = zzdpoVar;
        this.zzc = zzdptVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final String zzc() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final List zzd() {
        return this.zzc.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final String zze() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final zzbme zzf() {
        return this.zzc.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final String zzg() {
        return this.zzc.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final double zzh() {
        return this.zzc.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final String zzi() {
        return this.zzc.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final String zzj() {
        return this.zzc.zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final Bundle zzk() {
        return this.zzc.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zzl() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final com.google.android.gms.ads.internal.client.zzea zzm() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zzn(Bundle bundle) {
        this.zzb.zzc(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final boolean zzo(Bundle bundle) {
        return this.zzb.zze(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zzp(Bundle bundle) {
        this.zzb.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final zzblx zzq() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final IObjectWrapper zzr() {
        return this.zzc.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final String zzs() {
        return this.zza;
    }
}
