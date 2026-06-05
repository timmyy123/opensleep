package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdud extends zzbmr {
    private final String zza;
    private final zzdpo zzb;
    private final zzdpt zzc;

    public zzdud(String str, zzdpo zzdpoVar, zzdpt zzdptVar) {
        this.zza = str;
        this.zzb = zzdpoVar;
        this.zzc = zzdptVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final String zzc() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final List zzd() {
        return this.zzc.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final String zze() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final zzbme zzf() {
        return this.zzc.zzR();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final String zzg() {
        return this.zzc.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final String zzh() {
        return this.zzc.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final Bundle zzi() {
        return this.zzc.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final void zzj() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final com.google.android.gms.ads.internal.client.zzea zzk() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final void zzl(Bundle bundle) {
        this.zzb.zzc(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final boolean zzm(Bundle bundle) {
        return this.zzb.zze(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final void zzn(Bundle bundle) {
        this.zzb.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final zzblx zzo() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final IObjectWrapper zzp() {
        return this.zzc.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final String zzq() {
        return this.zza;
    }
}
