package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbwz extends zzbee implements zzbxb {
    public zzbwz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zze(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbxe zzbxeVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzbeg.zzc(parcelZza, bundle);
        zzbeg.zzc(parcelZza, bundle2);
        zzbeg.zzc(parcelZza, zzrVar);
        zzbeg.zze(parcelZza, zzbxeVar);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final zzbxq zzf() {
        Parcel parcelZzcZ = zzcZ(2, zza());
        zzbxq zzbxqVar = (zzbxq) zzbeg.zzb(parcelZzcZ, zzbxq.CREATOR);
        parcelZzcZ.recycle();
        return zzbxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final zzbxq zzg() {
        Parcel parcelZzcZ = zzcZ(3, zza());
        zzbxq zzbxqVar = (zzbxq) zzbeg.zzb(parcelZzcZ, zzbxq.CREATOR);
        parcelZzcZ.recycle();
        return zzbxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final com.google.android.gms.ads.internal.client.zzea zzh() {
        Parcel parcelZzcZ = zzcZ(5, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwp zzbwpVar, zzbvi zzbviVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwpVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzbeg.zzc(parcelZza, zzrVar);
        zzda(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbws zzbwsVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwsVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final boolean zzk(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(15, parcelZza);
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwy zzbwyVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwyVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(17, parcelZza);
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwv zzbwvVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwvVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzo(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzda(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwy zzbwyVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwyVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzq(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwp zzbwpVar, zzbvi zzbviVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwpVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzbeg.zzc(parcelZza, zzrVar);
        zzda(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzr(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwv zzbwvVar, zzbvi zzbviVar, zzblt zzbltVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwvVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzbeg.zzc(parcelZza, zzbltVar);
        zzda(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzs(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwm zzbwmVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbwmVar);
        zzbeg.zze(parcelZza, zzbviVar);
        zzda(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final boolean zzt(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(24, parcelZza);
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }
}
