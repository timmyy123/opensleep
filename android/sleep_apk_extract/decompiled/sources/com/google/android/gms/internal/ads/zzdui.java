package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdui extends zzbnu {
    private final String zza;
    private final zzdpo zzb;
    private final zzdpt zzc;
    private final zzdzl zzd;

    public zzdui(String str, zzdpo zzdpoVar, zzdpt zzdptVar, zzdzl zzdzlVar) {
        this.zza = str;
        this.zzb = zzdpoVar;
        this.zzc = zzdptVar;
        this.zzd = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final boolean zzA() {
        zzdpt zzdptVar = this.zzc;
        return (zzdptVar.zzE().isEmpty() || zzdptVar.zzF() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzB(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzb.zzA(zzdgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzC(com.google.android.gms.ads.internal.client.zzdc zzdcVar) {
        this.zzb.zzB(zzdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzD() {
        this.zzb.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzE() {
        this.zzb.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final zzbmb zzF() {
        return this.zzb.zzP().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final boolean zzG() {
        return this.zzb.zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final com.google.android.gms.ads.internal.client.zzdx zzH() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhI)).booleanValue()) {
            return this.zzb.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzI(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        try {
            if (!zzdqVar.zzf()) {
                this.zzd.zzb();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzQ(zzdqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzJ(Bundle bundle) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzox)).booleanValue()) {
            this.zzb.zzR(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final long zzK() {
        zzdpo zzdpoVar = this.zzb;
        if (zzdpoVar == null || zzdpoVar.zzo() == null) {
            return 0L;
        }
        return zzdpoVar.zzo().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzL(long j) {
        zzdpo zzdpoVar = this.zzb;
        if (zzdpoVar == null || zzdpoVar.zzo() == null) {
            return;
        }
        zzdpoVar.zzo().zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zze() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final List zzf() {
        return this.zzc.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zzg() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final zzbme zzh() {
        return this.zzc.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zzi() {
        return this.zzc.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zzj() {
        return this.zzc.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final double zzk() {
        return this.zzc.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zzl() {
        return this.zzc.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zzm() {
        return this.zzc.zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final com.google.android.gms.ads.internal.client.zzea zzn() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final String zzo() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzp() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final zzblx zzq() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzr(Bundle bundle) {
        this.zzb.zzc(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final boolean zzs(Bundle bundle) {
        return this.zzb.zze(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzt(Bundle bundle) {
        this.zzb.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final IObjectWrapper zzu() {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final IObjectWrapper zzv() {
        return this.zzc.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final Bundle zzw() {
        return this.zzc.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzx(zzbns zzbnsVar) {
        this.zzb.zzy(zzbnsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final void zzy() {
        this.zzb.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbnv
    public final List zzz() {
        return zzA() ? this.zzc.zzE() : Collections.EMPTY_LIST;
    }
}
