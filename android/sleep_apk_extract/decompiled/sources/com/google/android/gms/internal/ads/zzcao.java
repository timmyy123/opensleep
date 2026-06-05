package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcao extends zzbee implements zzcaq {
    public zzcao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zze(zzcbd zzcbdVar, zzcau zzcauVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzcbdVar);
        zzbeg.zze(parcelZza, zzcauVar);
        zzda(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzf(zzcbd zzcbdVar, zzcau zzcauVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzcbdVar);
        zzbeg.zze(parcelZza, zzcauVar);
        zzda(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzg(zzcbd zzcbdVar, zzcau zzcauVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzcbdVar);
        zzbeg.zze(parcelZza, zzcauVar);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzh(String str, zzcau zzcauVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzcauVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzi(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzda(9, parcelZza);
    }
}
